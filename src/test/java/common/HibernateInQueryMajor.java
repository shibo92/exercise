package common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * http://sp.corp.qiuduoduo.cn/pages/viewpage.action?pageId=8356235
 *
 * 这个是hibernate的SQL缓存，代码层面in查询使用不当很容易造成内存泄漏问题。
 *
 * ref : https://stackoverflow.com/questions/31557076/spring-hibernate-query-plan-cache-memory-usage
 *
 * 解决方案：
 * 代码里有大量用ID对球员和球队的批量查询，如果每次传入的参数ID个数不一样，都会新生成一个SQL statement缓存下来。
 *
 * 优化思路：
 *
 * 把可变的参数个数转换成不可变的，自定义一个列表[1, 2, 4, 8, 16, 32, 64, 128, 256]，9个值。
 *
 * 不论传入的参数个数是多少，都可以由列表里的9个数字组合而成，e.g. 499 = 256 + 128 + 64 + 32 + 16 + 2 + 1
 *
 * 只需缓存9个SQL，不会随接口请求参数变化导致缓存无限增加。
 */
public class HibernateInQueryMajor {
    public List findByIdIn(List<Integer> ids) {
        if (null == ids || ids.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        ids = ids.stream().distinct().collect(Collectors.toList()); // 去重
        /* 把参数ID打散成固定尺寸的一组列表 */
        int[] batch = {1, 2, 4, 8, 16, 32, 64, 128, 256};
        int cursor = batch.length - 1;
        List<List<Integer>> param = new ArrayList<>();
        while (true) {
            int size = batch[cursor];
            if (ids.size() >= size) {
                param.add(ids.subList(0, size));
                ids = ids.subList(size, ids.size());
            } else {
                cursor --;
                if (cursor < 0) {
                    break;
                }
            }
        }

        /* 用拆分后的参数分批查询，然后合并结果集 */
        List result = new ArrayList();
        System.out.println(param);
        /*param.stream().forEach(p -> {
            switch (type) {
                case "player":
                    // result.addAll(playerRepository.findByIdIn(p));
                    break;
                case "team":
                    // result.addAll(teamRepository.findByIdIn(p));
                    break;
                default:
            }
        });*/
        return result;
    }
}
