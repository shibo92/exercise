package rpc.demo.service;

import java.io.Serializable;

/**
 * @author by shibo on 2020/10/13.
 */
public class RpcServiceImpl implements IRpcService {
    @Override
    public String hello(String name) {
        return "i'm " + name;
    }
}
