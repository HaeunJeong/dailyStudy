

public class Main1221_2 {

    public int solution(String word) {
        String str = "AEIOU";
        int[] x = {781,156,31,6,1};
        int result=word.length();

        for(int i=0;i<word.length();i++){
            result+=x[i]*str.indexOf(word.charAt(i));
        }
        return result;
    }
}
