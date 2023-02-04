import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {

    public static void main(String[] args){
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
    public static String longestCommonPrefix(String[] strs) {

        String[] sortedStrs = Arrays.stream(strs).sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);

        String commonPrefix = sortedStrs[0];

        for(int i=1 ; i < sortedStrs.length; i++){
            commonPrefix = getCommonPrefix(commonPrefix, sortedStrs[i]);
        }
        return commonPrefix;
    }
    private static String getCommonPrefix(String s1, String s2){

        if(s2.substring(0, s1.length()).equals(s1)){
            //prefix가 맞을경우,
            return s1;
        }else{
            if(s1.length()>1){
                String newPrefix = s1.substring(0, s1.length()-1);
                return getCommonPrefix(newPrefix, s2);
            }else{
                return "";
            }

        }
    }
}