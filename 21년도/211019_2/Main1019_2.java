import java.util.Stack;

public class Main1019_2 {


    public static void main(String[] args){
        System.out.println(solution("baabaab"));
    }
    public static int solution(String s)
    {

        if(s.length()%2!=0){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(!stack.isEmpty() && c.equals(stack.peek())){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.isEmpty()?1:0;
    }

}
