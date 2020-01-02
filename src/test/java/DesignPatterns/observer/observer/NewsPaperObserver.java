package DesignPatterns.observer.observer;

import DesignPatterns.observer.subject.Subject;

/**
 * @author shibo
 * @date 20-1-2 下午6:58
 */
public class NewsPaperObserver implements Observer {
    private final Subject subject;

    public NewsPaperObserver(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void showNews() {
        System.out.println("报纸发布新闻" + this.subject.getNews());
    }
}
