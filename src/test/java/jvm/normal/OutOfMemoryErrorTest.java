package jvm.normal;

import java.util.ArrayList;
import java.util.List;

public class OutOfMemoryErrorTest {
    public static void main(String[] args) {
        List l = new ArrayList<>();
        while (true){
            l.add(new Demo());
        }
    }
}
class Demo{

}
