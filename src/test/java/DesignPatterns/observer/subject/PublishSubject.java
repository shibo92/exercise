package DesignPatterns.observer.subject;

/**
 * @author shibo
 * @date 20-1-2 下午6:58
 */
public class PublishSubject extends Subject {
    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
