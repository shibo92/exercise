package algorithm.tanxin;

import java.util.Stack;

/**
 * @author by Administrator on 2021/3/16.
 */
public class Kuohao {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }
    public static boolean isValid (String s) {
        Stack<String> stack = new Stack<>();
        // write code here
        for(int i=0;i<s.length();i++){
            String c = String.valueOf(s.charAt(i));
            if(c.equals("{")||c.equals("(")||c.equals("[")){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(c.equals("}") && stack.peek().equals("{")){
                    stack.pop();
                }else if(c.equals(")") && stack.peek().equals("(")){
                    stack.pop();
                }else if(c.equals("]") && stack.peek().equals("[")){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
