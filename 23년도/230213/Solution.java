import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args){
        System.out.println(Integer.toString(10,2));
    }

    public List<Integer> solution(int[] progresses, int[] speeds) {

        List<Integer> publNum = new ArrayList<>();

        int dayPublNum = 0;
        int totalPublNum = 0;

        int[] complete = new int[progresses.length];
        int publedIndex = 0;

        while(totalPublNum < progresses.length) {

            for(int i = 0; i<progresses.length; i++) {
                if(complete[i]==0) {
                    if(progresses[i] + speeds[i] > 100 ) {
                        complete[i] = 1;
                    }else{
                        progresses[i] += speeds[i];
                    }
                }
            }

            for(int i = publedIndex; i<progresses.length; i++){
                if(complete[i]==1){
                    dayPublNum++;
                    publedIndex++;
                }else{
                    break;
                }
            }

            if(dayPublNum>0){
                publNum.add(dayPublNum);
                totalPublNum += dayPublNum;
            }
            dayPublNum = 0;
        }

        return publNum;
    }


}
