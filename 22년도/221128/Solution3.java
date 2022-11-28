import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution3 {

    public static void main(String[] args){
        int[] arr1 = new int[]{10, 100, 20, 150, 1, 100, 200};

        solution(3, arr1);
    }
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> pq = new PriorityQueue<>(k, Comparator.naturalOrder());

        for(int i=0; i<score.length; i++){
            if(pq.size() == k ){
                if(pq.peek() < score[i]){
                    pq.poll();
                    pq.add(score[i]);
                }
            }else{
                pq.add(score[i]);
            }
            answer[i] = pq.peek();
        }

        return answer;
    }
}
