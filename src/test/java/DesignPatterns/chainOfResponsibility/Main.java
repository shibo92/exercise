package DesignPatterns.chainOfResponsibility;

import DesignPatterns.chainOfResponsibility.filter.FilterChain;
import DesignPatterns.chainOfResponsibility.filter.HtmlFilter;
import DesignPatterns.chainOfResponsibility.filter.SymbolFilter;
import DesignPatterns.chainOfResponsibility.filter.WordsFilter;
import DesignPatterns.chainOfResponsibility.web.Request;
import DesignPatterns.chainOfResponsibility.web.Response;

public class Main {
    public static void main(String[] args) {
        String msg = "啦啦啦，这是一段植入代码<script>alert('哈哈哈')</script>，这是敏感词。。。";
        Processor processor = new Processor();
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HtmlFilter())
                .addFilter(new WordsFilter());
        FilterChain filterChain2 = new FilterChain();
        filterChain2.addFilter(new SymbolFilter());
        filterChain.addFilter(filterChain2);
        processor.setFilterChain(filterChain);

        Request request = new Request();
        Response response = new Response();
        request.setMsg("Request Start : ");
        response.setMsg("Response Start : ");
        processor.doFilter(request, response, filterChain);
        System.out.println(request.getMsg());
        System.out.println(response.getMsg());
    }
}
