package server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author by Administrator on 2022/6/24.
 */
public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8081);
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("新的请求");
                InputStream inputStream = socket.getInputStream();
                byte[] buffer = new byte[1];
                StringBuilder content = new StringBuilder();
                while (inputStream.read(buffer) != -1) {
                    content.append(new String(buffer, StandardCharsets.UTF_8));
                }
                System.out.println(content.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
