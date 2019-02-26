package DesignPatterns.chainOfResponsibility;

public class HtmlFilter extends Filter {

    @Override
    public String doFilter(String msg) {
        return msg.replaceAll("<","[")
                .replaceAll(">","]");
    }
}
