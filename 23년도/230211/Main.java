import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

class Solution {
    public static void main(String[] args){
        solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
    }
    public static int solution(int k, int[] tangerine) {
        int sum = 0;
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : tangerine){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> sortedList = map.values().stream()
                .sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        for(int num : sortedList){
            if(sum < k){
                answer++;
                sum+=num;
            }else{
                break;
            }
        }

        return answer;
    }
}
