package DesignPatterns.observer.subject;

import DesignPatterns.observer.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shibo
 * @date 20-1-2 下午6:58
 */
public abstract class Subject {
    List<Observer> observers = new ArrayList<>();
    String news;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyOb() {
        observers.forEach(Observer::showNews);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
