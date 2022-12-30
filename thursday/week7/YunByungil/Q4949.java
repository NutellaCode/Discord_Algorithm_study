import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q4949 {
    static Stack<String> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean result = true;
        while (result) {
            // 1. input �ޱ�
            // ���ڿ��� �� ����, (, ), [, ]�� �����Ѵ�.
            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    check("(");
                } else if (str.charAt(i) == '[') {
                    check2("[");
                } else if (str.charAt(i) == ')') {
                    check3(")");
                } else if (str.charAt(i) == ']') {
                    check4("]");
                }
            }


            // ���� ����
            if (str.equals(".")) {
                result = false;
            } else {
                // 2. ( ), [ ]�� ����� ¦�� �̷������ Ȯ��
                // ����� ¦�� �̷������ empty
                if (!stack.empty()) {
                    sb.append("no").append("\n");
                } else {
                    sb.append("yes").append("\n");
                }
                stack.clear();
            }
        }

        System.out.println(sb);
    }
    public static void check(String s) {
        stack.push(s);
    }

    public static void check2(String s) {
        stack.push(s);
    }

    public static void check3(String s) {
        if (!stack.empty()) {
            if (stack.peek().equals("(")) {
                stack.pop();
            } else {
                stack.push(s);
            }
        } else {
            stack.push(s);
        }
    }

    public static void check4(String s) {
        if (!stack.empty()) {
            if (stack.peek().equals("[")) {
                stack.pop();
            } else {
                stack.push(s);
            }
        } else {
            stack.push(s);
        }
    }
}