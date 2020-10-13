package rpc.demo;

import rpc.demo.service.IRpcService;
import rpc.demo.service.RpcServiceImpl;

/**
 * @author by shibo on 2020/10/13.
 */
public class Provider {

    public static void main(String[] args) throws Exception {
        //服务提供者只需要暴露出接口
        IRpcService serviceProvider = new RpcServiceImpl();
        MyRpcFramework.export(serviceProvider, 2333);

    }
}
