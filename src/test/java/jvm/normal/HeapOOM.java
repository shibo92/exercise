package jvm.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * outOfMemory
 */
public class HeapOOM {
    static class OOMObject {
        //791580java
        //360145
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        int i = 0;
        while (true) {
            System.out.println(i++);
            list.add(new OOMObject());
        }
    }
}
