package jvm;

/**
 * 可达性分析机制：进行两次标记
 * 第一次：判断是否有gc root的引用链，没有引用链的话会被第一次标记，并筛选。
 * 筛选条件：判断是否有必要执行finalize方法（没有覆盖finalize方法或者已经被执行过，则被视为没有必要执行finalize）
 *
 * 第二次: 如果执行完finalize之后，还是没有引用，则被回收
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOCK = null;

    private void isAlive(){
        System.out.println("i'm still alive, hahha");
    }
    /**
     * 任何对象的finalize都只会被执行一次
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize has been executed...");
        SAVE_HOCK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOCK = new FinalizeEscapeGC();
        SAVE_HOCK = null;
        System.gc();
        // 等待gc线程执行完毕
        Thread.sleep(2000);
        if (SAVE_HOCK != null) {
            SAVE_HOCK.isAlive();
        } else {
            System.out.println("i'm dead");
        }

        SAVE_HOCK = null;
        // 第二次gc不会再触发finalize方法,所以没有执行  SAVE_HOCK = this;
        System.gc();
        // 等待gc线程执行完毕
        Thread.sleep(2000);
        if (SAVE_HOCK != null) {
            SAVE_HOCK.isAlive();
        } else {
            System.out.println("i'm dead");
        }
    }
}
