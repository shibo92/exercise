package DesignPatterns.chainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
    private List<Filter> filterList = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        this.filterList.add(filter);
        return this;
    }

    public String doFilter(String msg){
        for(Filter f : filterList){
            msg = f.doFilter(msg);
        }
        return msg;
    }
}
