package DesignPatterns.prototype;

/**
 * 原型模式
 *
 * @author shibo
 * @date 19-12-18 下午6:01
 */
public class Prototype implements Cloneable {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Prototype(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    protected Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
