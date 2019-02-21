package common;

public class AppendAndAdd {
    public static void main(String[] args) {
        String[] arr = new String[]{"a","b","c"};
        StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < arr.length; i ++) {
            result.append(arr[i]);
        }
        System.out.println(result);
    }
}
