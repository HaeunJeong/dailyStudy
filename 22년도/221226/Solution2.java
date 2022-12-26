public class Solution2 {
    public static void main(String[] args){
        solution("10203", "15");
    }
    public static int solution(String t, String p) {
        int answer = 0;
        long pLong = Long.parseLong(p);
        for(int i = 0 ; i<t.length()-p.length()+1 ; i++){
            long temp = Long.parseLong(t.substring(i, i+p.length()));
            if(temp <= pLong) answer++;
        }
        return answer;
    }



}

