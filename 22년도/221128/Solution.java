

public class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = {};

        int index = 0;
        int s_cursor = 0;
        int l_cursor = n;
        while(true){
            if(l_cursor < my_str.length()){
                answer[index] = my_str.substring(s_cursor, l_cursor);
                s_cursor += n;
                l_cursor += n;
            }else{
                answer[index] = my_str.substring(s_cursor);
                break;
            }
        }


        return answer;
    }
}