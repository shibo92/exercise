package DesignPatterns.chainOfResponsibility.filter;

import DesignPatterns.chainOfResponsibility.web.Request;
import DesignPatterns.chainOfResponsibility.web.Response;

public class WordsFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setMsg(request.getMsg() + " ==> WordsFilter");
        filterChain.doFilter(request, response, filterChain);
        response.setMsg(response.getMsg() + " ==> WordsFilter");
    }
}
