package DesignPatterns.observer.observer;

import DesignPatterns.observer.subject.Subject;

/**
 * @author shibo
 * @date 20-1-2 下午6:58
 */
public class TVObserver implements Observer {
    private final Subject subject;

    public TVObserver(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void showNews() {
        System.out.println("电视播放新闻" + this.subject.getNews());
    }
}
