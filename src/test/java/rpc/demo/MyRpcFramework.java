package rpc.demo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author by shibo on 2020/10/13.
 */
public class MyRpcFramework {

    public static void export(Object service, int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("开始暴露服务接口");
                    try {
                        System.out.println("开始暴露服务接口");
                        // 反序列化调用方传入的方法
                        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                        byte[] b = new byte[1];
                        int len=0;
                        StringBuilder methodName = new StringBuilder(); // 读取方法名
                        while ((len = inputStream.read(b)) != -1) {
                            methodName.append(new String(b, StandardCharsets.UTF_8));
                        }
                        Class<?>[] paramTypes = (Class<?>[]) inputStream.readObject(); // 读取参数类型
                        Object[] arguments = (Object[]) inputStream.readObject(); // 读取参数
                        Method method = service.getClass().getMethod(methodName.toString(), paramTypes); // 获取本地service对应的方法
                        Object result = method.invoke(service, arguments); // 调用本地方法
                        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                        outputStream.writeObject(result); // 返回处理结果
                        System.out.println("provider处理完毕");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static <T> T refer(Class<T> interfaceClass, String host, int port) throws Exception {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass},
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] arguments) throws Throwable {
                        Socket socket = new Socket(host, port);  //指定 provider 的 ip 和端口
                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                        output.write(method.getName().getBytes());  //传入方法名
                        output.writeObject(method.getParameterTypes());  //传参数类型
                        output.writeObject(arguments);  //传参数值
                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                        Object result = input.readObject();  //读取结果
                        return result;
                    }
                });
    }

}

