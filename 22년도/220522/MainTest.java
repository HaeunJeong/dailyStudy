import java.util.Stack;

public class MainTest {

    public static void main(String[] args){
        System.out.println(solution("[](){}"));
    }

    public static int solution(String s) {
        int answer = -1;

        for(int i = 0; i<s.length(); i++){
            StringBuilder builder = new StringBuilder();
            builder.append(s.substring(i));
            builder.append(s.substring(0,i));

            if(isValid(builder.toString())){
                if(answer==-1){
                    answer=1;
                }else{
                    answer++;
                }
            }
        }
        return answer;
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();

        stack.push(s.charAt(0));
        int index = 1 ;

        while(!stack.isEmpty() && index<=s.length()-1){
            if(isPair(stack.peek(), s.charAt(index))){
                stack.pop();
            }else{
                stack.push(s.charAt(index));
            }
            index++;
        }

        if(!stack.isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public static boolean isPair(Character first,Character second){
        switch(first){
            case '(' :
                return second==')'? true:false;
            case '{' :
                return second=='}'? true:false;
            case '[' :
                return second==']'? true:false;
            default:
                return false;
        }

    }


}
