package spider;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 建立http连接工具类
 */
public class ConnectionUtil {
    public static String Connect(String address) {
        HttpURLConnection conn = null;
        URL url = null;
        InputStream in = null;
        BufferedReader reader = null;
        StringBuffer stringBuffer = null;
        try {
            url = new URL(address);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            conn.setRequestProperty("cookie","cs_user_login2=kgQadj003ClkfhpjjIoGwSbxTqTnCeEwl2lbh55Byie8Ts6Zp8gE5gdj003yExGfXoWvbdj003x4; dj_urm_userId=15758833682291004; dj_urm_userOfficeId=14683956703412461; _djinpassuser=5231676443625467; _djinpasstkt=QrG6fLcEC2mP0sMsafCZPt8qKUVYTdj0016rVCf7M7gVV2cVjuzu4BDiWlxQ2dtyc13YQdg0rn2cdj003ESlSZdj003pifpbh9kSRmwJ3bTK; session=.eJxtkE2OwyAMhe_idVrx54Rk1W03PUE2BIhCVSAKQWpV9e4DmdFoFrOx7M_2k5_fkJPdYHiDXlywyd6UtzDAmFuczJiRo4IGdDSVkpIau6pt9zbsVwOD4Iz9Zb_r2M1qzJ0UpEYqqpShJbdaHCpJl7mUtbYpFWC9co9KFjfFi1Hx7tTJBX3W0df2c3XbCwbaMkRkXc8JIQ3c43TLfqoOgEkp-zIa_nWwLjFUTCVS0qEQPS807Wqeqw8uJKXN8YyjlKTF7_LH0XEXfD5fXv1b_g.YOKmGQ.uZIIObrI_NA6668l3Gv7nOLwQVg; secctf-user=admin");
            conn.setDoInput(true);
            conn.connect();
            in = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(in));
            stringBuffer = new StringBuffer();
            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
            try {
                in.close();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }
}
