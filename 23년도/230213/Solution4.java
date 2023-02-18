import java.util.*;

public class Solution4 {

    public static void main(String[] args){
        solution(new int[]{2, 3, 3, 5});
    }
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        //Queue<Integer> queue = new PriorityQueue<>();
        List<Integer> stack = new ArrayList<>();
        for(int i = numbers.length -1 ; i>=0; i--){
            if(i+1 >= numbers.length || stack.isEmpty()){
                answer[i] = -1;
                //queue.offer(numbers[i]);
            }else{
                int big = -1;
                for(int x = 0; x<stack.size(); x++){
                    if( stack.get(stack.size()-x-1) > numbers[i]){
                        big = stack.get(stack.size()-x-1);
                        break;
                    }
                }
                answer[i] = big;
            }
            stack.add(numbers[i]);
        }
        return answer;
    }
}
