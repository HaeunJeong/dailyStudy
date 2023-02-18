import java.util.*;

public class Solution3 {
    public static void main(String[] args){

        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
    public static List< List<String> > groupAnagrams(String[] strs) {

        List< List<String> > result = new ArrayList<>();

        for(String str : strs) {
            boolean isExist = false;
            for(List<String> list : result) {
                if(list != null && list.size() > 0){

                    if(isEachAnagram(list.get(0), str)){
                        list.add(str);
                        isExist = true;
                    }
                }
            }
            if(!isExist){
                List<String> newL = new ArrayList<>();
                newL.add(str);
                result.add(newL);
            }
        }
        return result;
    }

    public static boolean isEachAnagram(String s1, String s2){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(char c : s2.toCharArray()){
            if(!map.containsKey(c)) return false;

            map.put(c, map.get(c)-1);
            if(map.get(c)==0) map.remove(c);
        }

        if(map.size() == 0) {
            return true;
        }else {
            return false;
        }
    }
}
