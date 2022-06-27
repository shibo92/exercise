package server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author by Administrator on 2022/6/24.
 */
public class MyClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8081);
            OutputStream output = socket.getOutputStream();
            output.write(Thread.currentThread().getName().getBytes());
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
