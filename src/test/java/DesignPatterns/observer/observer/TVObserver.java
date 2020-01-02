package DesignPatterns.observer.observer;

import DesignPatterns.observer.subject.Subject;

/**
 * @author shibo
 * @date 20-1-2 下午6:58
 */
public class TVObserver extends Observer{
    public TVObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void showNews() {
        System.out.println("电视播放新闻" + subject.getNews());
    }
}
