public class Main1116_2 {

    public String solution(String s, int n) {
/*       공백은 아무리 밀어도 공백입니다.
        s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
        s의 길이는 8000이하입니다.
         n은 1 이상, 25이하인 자연수입니다.*/

        String answer = "";

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c >= 'a' && c <= 'z') {
                if(c + n > 'z')
                    answer += (char)(c + n-26) +"";
                else
                    answer += (char)(c + n) +"";
            }
            else if(c >= 'A' && c <= 'Z') {
                if(c + n > 'Z')
                    answer += (char)(c + n-26)+"";
                else
                    answer += (char)(c + n)+"";
            }
            else{
                answer += (char)c+"";
            }

        }

        return answer;
    }
}
