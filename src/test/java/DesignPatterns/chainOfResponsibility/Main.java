package DesignPatterns.chainOfResponsibility;

public class Main {
    public static void main(String[] args) {
        String msg = "啦啦啦，这是一段植入代码<script>alert('哈哈哈')</script>，这是敏感词";
        Processor processor = new Processor();
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new HtmlFilter())
                .addFilter(new WordsFilter());
        processor.setFilterChain(filterChain);
        String msg2 = processor.doFilter(msg);
        System.out.println(msg2);
    }
}
