package DesignPatterns.component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shibo
 * @date 20-1-28 下午2:14
 */
public class Composite extends Component {
    private List<Component> components = new ArrayList<>();
    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        components.add(component);
    }

    @Override
    public void remove(Component component) {
        components.remove(component);
    }

    @Override
    public void display() {

    }
}
