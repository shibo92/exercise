package DesignPatterns.observer.observer;

import DesignPatterns.observer.subject.Subject;

/**
 * @author shibo
 * @date 20-1-2 下午6:58
 */
public abstract class Observer {
    public Subject subject;

    public abstract void showNews();

    public Observer(Subject subject) {
        this.subject = subject;
    }
}
