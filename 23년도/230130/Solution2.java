import java.util.*;

class Solution2 {

    public static void main(String[] args){
        solution(new int[]{1, 3, 4, 6});
    }
    public static String solution(int[] food) {
        String answer = "";
        int[] result = new int[4500];
        int count = 0;

        for (int i = 0; i < food.length; i++) {
            int newFoodCount = food[i] / 2;
            for (int j = count; j < count+newFoodCount; j++) {
                result[j] = i;
            }
            count+=newFoodCount;
        }
        result[count] = 0;
        int z = 0;
        for (z = count; count >= 0; z++) {
            result[z] = result[count];
            count--;
        }

        int[] result2 = Arrays.copyOfRange(result, 0, z);

        return Arrays.toString(result2).replaceAll("[^0-9]","");
    }
}