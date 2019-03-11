package DesignPatterns.chainOfResponsibility.filter;

import DesignPatterns.chainOfResponsibility.web.Request;
import DesignPatterns.chainOfResponsibility.web.Response;

/**
 * 1、首先定义filter借口
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain filterChain);
}
