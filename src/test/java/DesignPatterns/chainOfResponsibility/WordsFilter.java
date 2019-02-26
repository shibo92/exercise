package DesignPatterns.chainOfResponsibility;

public class WordsFilter extends Filter {

    @Override
    public String doFilter(String msg) {
        return msg.replaceAll("敏感词","**");
    }
}
