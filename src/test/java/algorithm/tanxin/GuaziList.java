package algorithm.tanxin;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by Administrator on 2021/8/13.
 */
public class GuaziList {
    public static void main(String[] args) {
        List originalList = new ArrayList();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);
        originalList.add(4);
        originalList.add(5);
        originalList.add(6);
        List res = getSubList(originalList,3,1);
        System.out.println(JSON.toJSONString(res));
    }
    //originalList : 源集合
    // pageSize : 单页数量
    // pageNumber : 指定的页数
    public static List getSubList(List originalList, int pageSize, int pageNumber){
        List result = new LinkedList();
        int start = pageSize * pageNumber;
        int end = Math.min(originalList.size(), (pageNumber+1 )* pageSize);
        for (int i = start; i < end; i++) {
            result.add(originalList.get(i));
        }
        return result;
    }
}
