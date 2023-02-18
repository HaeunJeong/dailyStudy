import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public int solution(int[] elements) {

        Set<Integer> set = new HashSet<>();
        int[] nEle = new int[elements.length*2];

        for(int i =0; i<elements.length; i++){
            nEle[i] = elements[i];
            nEle[elements.length+i] = elements[i];
        }

        //길이가 n개인 부분수열
        for(int i = 1; i<=elements.length; i++){

            for(int j=0; j<elements.length; j++){
                int sum = 0;
                for(int x=j; x<j+i; x++){
                    sum+=nEle[x];
                }
                set.add(sum);
            }

        }
        return set.size();
    }
}
