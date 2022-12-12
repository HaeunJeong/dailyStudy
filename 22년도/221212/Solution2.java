public class Solution2 {

    public int solution(int num, int k) {

        char[] chars = Integer.toString(num).toCharArray();
        for(int i = 0; i<chars.length; i++){
            if(k == Integer.parseInt(chars[i]+"")){
                return i+1;
            }
        }
        return -1;

    }
}
