package DesignPatterns.chainOfResponsibility.filter;

import DesignPatterns.chainOfResponsibility.web.Request;
import DesignPatterns.chainOfResponsibility.web.Response;

/**
 * 3、实现链
 */
public class HtmlFilter implements Filter {

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        // 先处理request内容
        request.setMsg(request.getMsg() + " ==> HTMLFilter");
        // 调用下一层
        filterChain.doFilter(request, response, filterChain);
        // 下一层返回后再执行本层的response
        response.setMsg(response.getMsg() + " ==> HTMLFilter");
    }
}
