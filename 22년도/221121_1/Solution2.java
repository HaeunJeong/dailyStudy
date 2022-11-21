import java.util.Arrays;
import java.util.Collections;

public class Solution2 {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Integer[] scoreInteger = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(scoreInteger, Collections.reverseOrder());

        int cursor = 0;
        while(true){
            if(cursor+m <= scoreInteger.length){
                answer+=scoreInteger[cursor+m-1]*m;
                cursor += m;
            }else{
                answer+=scoreInteger[scoreInteger.length-1]*(scoreInteger.length-cursor);
                break;
            }
        }


        return answer;
    }
}
