package rpc.demo;

import rpc.demo.service.IRpcService;
import rpc.demo.service.RpcServiceImpl;

/**
 * @author by shibo on 2020/10/13.
 */
public class Consumer {
    public static void main(String[] args) throws Exception {
        //服务调用者只需要设置依赖
        IRpcService service = MyRpcFramework.refer(IRpcService.class, "127.0.0.1", 2333);
        System.out.println(service.hello("娃哈哈"));
    }
}
