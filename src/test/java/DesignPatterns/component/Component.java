package DesignPatterns.component;

/**
 * @author shibo
 * @date 20-1-28 下午2:12
 */
public abstract class Component {
    String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract void add(Component component);

    public abstract void remove(Component component);

    public abstract void display();
}
