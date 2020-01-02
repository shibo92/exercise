package DesignPatterns.observer;

import DesignPatterns.observer.observer.NewsPaperObserver;
import DesignPatterns.observer.observer.TVObserver;
import DesignPatterns.observer.subject.PublishSubject;
import DesignPatterns.observer.subject.Subject;

/**
 * @author shibo
 * @date 20-1-2 下午7:27
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new PublishSubject();
        subject.setNews("明天不上班.");
        subject.attach(new TVObserver(subject));
        subject.attach(new NewsPaperObserver(subject));
        subject.notifyOb();
    }
}
