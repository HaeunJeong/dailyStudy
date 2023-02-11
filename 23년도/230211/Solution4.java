import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {

    public static String solution(String a, String b){
        int[] aArray = new int[60];
        int[] bArray = new int[60];

        for(int i = 0; i< a.length(); i++){
            aArray[a.charAt(i)-'A']++;
        }

        for(int i = 0; i< b.length(); i++){
            bArray[b.charAt(i)-'A']++;
        }

        if(Arrays.compare(aArray, bArray) == 0) return "YES";
        return "NO";
    }
/*    public static void main(String[] args){
        Solution4 T = new Solution4();
        Scanner kb = new Scanner(System.in);
        String a=kb.next();
        String b=kb.next();
        System.out.print(T.solution(a, b));
    }*/
    public static void main(String[] args){

        System.out.print(solution("AbaAeCe", "baeeACA"));
    }
}
