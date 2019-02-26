package DesignPatterns.chainOfResponsibility;

public class Processor {
    private FilterChain filterChain;

    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    public String doFilter(String msg){
        return this.filterChain.doFilter(msg);
    }
}
