import java.util.*;
public class Solution2 {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        return map.size() < nums.length/2 ? map.size() : nums.length/2;
    }
}