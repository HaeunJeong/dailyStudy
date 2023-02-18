import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    public static void main(String[] args){
        lengthOfLongestSubstring("pwwkew");
    }
    public static int lengthOfLongestSubstring(String s) {

        int lt=0, rt=0;
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>(); //char, index;
        map.put(s.charAt(0), 0);


        while(rt++ >= lt && rt < s.length()) {
            if(map.containsKey(s.charAt(rt))){
                //중복된 키가 나왔다?
                lt = Math.max(rt, map.get(s.charAt(lt)+1));
            }
            map.put(s.charAt(rt), rt);
            maxLength = Math.max(maxLength, rt-lt+1);
        }
        return maxLength;
    }
}