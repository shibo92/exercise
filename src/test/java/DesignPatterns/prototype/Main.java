package DesignPatterns.prototype;

/**
 * @author shibo
 * @date 19-12-18 下午6:06
 */
public class Main {
    public static void main(String[] args) {
        FilePrototype file1 = new FilePrototype("title", "content");
        file1.show();
        FilePrototype file2 = (FilePrototype) file1.clone();
        file1.setTitle("titl1");
        file2.show();
        FilePrototype file3 = file1;
        file3.show();
    }
}
