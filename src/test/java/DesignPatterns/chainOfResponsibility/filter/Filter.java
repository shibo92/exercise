package DesignPatterns.chainOfResponsibility.filter;

import DesignPatterns.chainOfResponsibility.web.Request;
import DesignPatterns.chainOfResponsibility.web.Response;

public interface Filter {
    void doFilter(Request request, Response response, FilterChain filterChain);
}
