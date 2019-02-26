package DesignPatterns.chainOfResponsibility;

import DesignPatterns.chainOfResponsibility.filter.FilterChain;
import DesignPatterns.chainOfResponsibility.web.Request;
import DesignPatterns.chainOfResponsibility.web.Response;

public class Processor {
    private FilterChain filterChain;

    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    public void doFilter(Request request, Response response, FilterChain chain){
        this.filterChain.doFilter(request, response, chain);
    }
}
