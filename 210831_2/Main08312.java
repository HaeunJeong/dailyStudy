import java.util.*;
class Main08312 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String s: skill_trees){
            if(isAvailable(skill, s)){
                answer++;
            }
        }
        return answer;
    }
    public boolean isAvailable(String skill, String s){
        // 1. s에서 skill에 있는 요소들만 남기기
        //2. 그 요소들 검사.
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()){
            for(char skillC: skill.toCharArray()){
                if(c==skillC){
                    sb.append(c);
                    break;
                }
            }
        }
        if(skill.indexOf(sb.toString())==0){
            System.out.println(sb.toString());
            return true;
        }
        else{
            return false;
        }
    }
}