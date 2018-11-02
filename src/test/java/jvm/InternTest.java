package jvm;

import org.junit.Test;

public class InternTest {
    @Test
    public void test(){
        String str1 = new StringBuilder("ja").append("va").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str2.intern() == str2);
    }
}
