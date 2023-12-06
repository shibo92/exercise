package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author by Administrator on 2023/1/3.
 */
public class MyLock implements Lock {

    public class MySync extends AbstractQueuedSynchronizer {
        public boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        public boolean isHeldExclusively() {
            return getState() == 1;
        }

        public boolean tryRelease(int arg) {
            // compareAndSetState(1, 0);
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }
        // 包含condition队列
        Condition newCondition(){
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
