public class Solution {
    public static void main(String[] args){
        int[] number = new int[]{-1,1,-1,1};

        solution(number);
    }

    public static int solution(int[] number) {
        int answer = 0;

        for(int i = 0; i<number.length-2; i++){

            for(int j = i+1; j<number.length-1; j++){

                for(int k = j+1; k<number.length; k++){
                    int temp = number[i] + number[j] + number[k];
                    if(temp == 0){
                        answer+=1;
                    }
                }
            }
        }

        return answer;
    }
}
