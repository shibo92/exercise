package DesignPatterns.chainOfResponsibility.filter;

import DesignPatterns.chainOfResponsibility.web.Request;
import DesignPatterns.chainOfResponsibility.web.Response;

public class HtmlFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setMsg(request.getMsg() + " ==> HTMLFilter");
        filterChain.doFilter(request, response, filterChain);
        response.setMsg(response.getMsg() + " ==> HTMLFilter");
    }
}
