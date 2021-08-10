import java.util.*;
class Main0810 {
    public Integer[] solution(int[] answers) {
        Integer[] answer = {};

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[]{0,0,0,0};

        for(int i=0; i<answers.length; i++){
            if(answers[i]==one[i%one.length]){
                score[1]++;
            }
            if(answers[i]==two[i%two.length]){
                score[2]++;
            }
            if(answers[i]==three[i%three.length]){
                score[3]++;
            }
        }
        answer = getMaxIndex(score);

        return answer;
    }
    public Integer[] getMaxIndex(int[] score){
        ArrayList<Integer> answer = new ArrayList<>();
        int maxVal = -1;
        for(int i=1; i<score.length; i++){
            if(score[i]>=maxVal){
                maxVal = score[i];
            }
        }
        for(int i=1; i<score.length; i++){
            if(score[i]==maxVal){
                answer.add(i);
            }
        }
        return answer.toArray(new Integer[answer.size()]);
    }
}