import java.util.Stack;

public class MainTest {

    public static void main(String[] args) {
        System.out.println(solution("}]()[{"));
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(s.substring(i));
            builder.append(s.substring(0, i));

            if (isValid(builder.toString())) {

                answer++;

            }
        }
        return answer;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (isPair(stack.peek(), s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (!stack.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isPair(Character first, Character second) {
        switch (first) {
            case '(':
                return second == ')' ? true : false;
            case '{':
                return second == '}' ? true : false;
            case '[':
                return second == ']' ? true : false;
            default:
                return false;
        }

    }


}
