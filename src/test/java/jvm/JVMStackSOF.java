package jvm;

/**
 * stackOverFlow
 */
public class JVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) {
        JVMStackSOF jvmStackSOF = new JVMStackSOF();
        try{
            jvmStackSOF.stackLeak();
        } catch (Throwable e){
            System.err.println("stack length : " + jvmStackSOF.stackLength);
            throw e;
        }
    }
}
