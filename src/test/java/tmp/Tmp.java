package tmp;

import org.junit.Test;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.*;

public class Tmp implements Serializable {

    public static void main(String[] args) {
        Map<String ,String> m = new HashMap<>();
        m.put("11","");
        m.put("22","");
            for (String value : m.values()) {
            System.out.println(value);
        }
    }
}
