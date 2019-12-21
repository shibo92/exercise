package DesignPatterns.prototype;

/**
 * @author shibo
 * @date 19-12-18 下午6:04
 */
public class FilePrototype extends Prototype {
    public FilePrototype(String title, String content) {
        super(title, content);
        ;
    }

    public void show() {
        System.out.println(super.getTitle() + ":" + super.getContent());
    }
}
