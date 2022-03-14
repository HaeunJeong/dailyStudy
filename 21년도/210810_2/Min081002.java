import java.util.Arrays;

public class Min081002 {
    public int[] solution(int []arr) {
        int[] answer = new int[arr.length];

        answer[0] = arr[0];
        int idx=1;
        for(int i=1; i<arr.length; i++){
            if(arr[i-1]!=arr[i]){
                answer[idx] = arr[i];
                idx++;
            }
        }
        return Arrays.copyOfRange(answer,0,idx);
    }
}
