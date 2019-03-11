package DesignPatterns.chainOfResponsibility.filter;

import DesignPatterns.chainOfResponsibility.web.Request;
import DesignPatterns.chainOfResponsibility.web.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * 2、定义链
 */
public class FilterChain implements Filter {
    private List<Filter> filterList = new ArrayList<>();
    int index = 0;

    public FilterChain addFilter(Filter filter) {
        this.filterList.add(filter);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        // 已经没有需要继续执行的filter了
        if (index == filterList.size()) return;
        Filter filter = filterList.get(index++);
        // 链式调用，继续执行下一个过滤器
        filter.doFilter(request, response, filterChain);
    }
}
