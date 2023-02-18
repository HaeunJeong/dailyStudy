import java.util.Arrays;
import java.util.Optional;

public class Solution {

    public String solution(String[] params) {
        Optional<String> answer = Arrays.stream(params).map(str->str.toUpperCase()).filter(str->str.length()>=5 && str.length() <=10).findFirst();
        if(answer.isPresent()){
            return answer.get();
        }else{
            return "없음";
        }
    }
}
