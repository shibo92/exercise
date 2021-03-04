/*
package tmp;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

*/
/**
 * @author by shibo on 2020/10/22.
 *//*

public class Tmp {

    */
/**
     * 把node的有效前驱（有效是指node不是CANCELLED的）找到，
     * 并且将有效前驱的状态设置为SIGNAL，之后便返回true代表马上可以阻塞了。
     * @param pred
     * @param node
     * @return
     *//*

    private static boolean shouldParkAfterFailedAcquire(AbstractQueuedSynchronizer.Node pred, AbstractQueuedSynchronizer.Node node) {
        int ws = pred.waitStatus;
        if (ws == AbstractQueuedSynchronizer.Node.SIGNAL)
            */
/*
             * This node has already set status asking a release
             * to signal it, so it can safely park.
             *//*

            */
/*
             * 前驱节点已经设置了SIGNAL，闹钟已经设好，现在我可以安心睡觉（阻塞）了。
             * 如果前驱变成了head，并且head的代表线程exclusiveOwnerThread释放了锁，
             * 就会来根据这个SIGNAL来唤醒自己
             *//*

            return true;
        if (ws > 0) {
            */
/*
             * Predecessor was cancelled. Skip over predecessors and
             * indicate retry.
             *//*

            */
/*
             * 发现传入的前驱的状态大于0，即CANCELLED。说明前驱节点已经因为超时或响应了中断，
             * 而取消了自己。所以需要跨越掉这些CANCELLED节点，直到找到一个<=0的节点
             *//*

            do {
                node.prev = pred = pred.prev;
            } while (pred.waitStatus > 0);
            pred.next = node;
        } else {
            */
/*
             * 进入这个分支，ws只能是0或PROPAGATE。
             * CAS设置ws为SIGNAL
             *//*

            compareAndSetWaitStatus(pred, ws, AbstractQueuedSynchronizer.Node.SIGNAL);
        }
        return false;
    }
}
*/
