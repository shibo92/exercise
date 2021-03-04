package tmp;

import com.alibaba.fastjson.JSON;

/**
 * @author by shibo on 2020/10/23.
 */
public class NodeTmp {
    static final class Node {
        static final Node SHARED = new Node();
        static final Node EXCLUSIVE = null;
        static final int CANCELLED = 1; // 当线程等待超时或者被中断，则取消等待，设等待状态为CANCELLED，进入取消状态后则不再变化。
        static final int SIGNAL = -1; // 后继节点处于待唤醒状态，前驱节点被取消或者中断时会释放锁，同时会通知待唤醒状态的后继节点，使后继节点的线程得以运行
        static final int CONDITION = -2; // 与Condition相关，该标识的结点处于等待队列中(Condition.await())，当其他线程调用了Condition.signal()方法后，CONDITION状态的结点将从等待队列转移到同步队列中，等待获取同步锁。
        static final int PROPAGATE = -3; // 与共享模式相关，在共享模式中，该状态标识结点的线程处于可运行状态。
        volatile int waitStatus; // 0 为初始化状态
        volatile Node prev;
        volatile Node next;
        volatile Thread thread;
        Node nextWaiter; // 1: 标识当前节点是独占模式还是共享模式(EXCLUSIVE、SHARED); 2: 当Node作为Condition的等待队列节点时，nextWaiter保存后继节点

        // 获取前驱节点
        final Node predecessor() throws NullPointerException {
            Node p = prev;
            if (p == null)
                throw new NullPointerException();
            else
                return p;

        }
    }

    public static void main(String[] args) {
        String body = "{\"create_time\":\"1596769634000\",\"imei\":\"867600032023581\",\"eventStatus\":\"2\",\"os_type\":\"2\",\"app_id\":\"100058\"}";
        AppEventMsgInfo appEventMsgInfo = JSON.parseObject(body, AppEventMsgInfo.class);
        System.out.println(appEventMsgInfo);
    }
}
