import java.util.*;
class Test2 {
    Stack<Integer> stack = new Stack<>();

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        for(int move: moves){
            if(moveResult(board, move)){
                answer = answer+2;
            }
        }
        return answer;
    }
    public boolean moveResult(int[][] board, int moveIndex){
        int dol = getDol(board, moveIndex);
        if(dol!=0){
            if(!stack.isEmpty() && stack.peek() == dol){
                stack.pop();
                return true;
            }else{
                stack.add(dol);
                return false;
            }
        }
        return false;
    }

    public int getDol(int[][] board, int moveIndex){
        for(int[] height: board){
            if(height[moveIndex-1] != 0){
                return height[moveIndex-1];
            }
        }
        return 0;
    }
}