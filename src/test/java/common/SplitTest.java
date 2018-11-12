package common;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class SplitTest {
    @Test
    public void test() {
        String[] a = StringUtils.split("1,2,3,4,5",",");
    }
}
