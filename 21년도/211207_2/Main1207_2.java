import java.util.Arrays;

public class Main1207_2 {

    public static void main(String[] args){
        int[] arr1 = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};

        solution(5, arr1, arr2);
    }

    public static String[]  solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<arr1.length; i++){
            int[] binary1 = getBinary(n, arr1[i]);
            int[] binary2 = getBinary(n, arr2[i]);

            StringBuilder builder = new StringBuilder();
            for(int j=0; j<binary1.length; j++){
                if(binary1[j]==1 || binary2[j]==1){
                    builder.append("#");
                }else{
                    builder.append(" ");
                }
            }
            answer[i] = builder.toString();
        }


        return answer;
    }
    public static int[] getBinary(int n, int x){
        String binaryString = Integer.toBinaryString(x); //2진수
        while(binaryString.length()<n){
            binaryString="0"+binaryString;
        }
        return Arrays.stream(binaryString.split("")).mapToInt(c->Integer.valueOf(c)).toArray();
    }
}

