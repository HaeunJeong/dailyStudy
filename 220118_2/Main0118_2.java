import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main0118_2 {

    public static void main(String[] args){
        solution(new String[]{"muzi", "frodo", "apeach", "neo"},
                new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
    }
    public static int[] solution(String[] id_list, String[] report, int k) {


        Map<String, Integer> shingo = new HashMap<>();
        Map<String, Set<String>> sendShingo = new HashMap<>();

        for(String s: id_list){
            shingo.put(s, 0);
        }
        for(String s: report){
            String[] ss = s.split(" ");
            if(!sendShingo.getOrDefault(ss[0], new HashSet<>()).contains(ss[1])){
                shingo.put(ss[1], shingo.getOrDefault(ss[1],0)+1);
            }
            Set<String> set = sendShingo.getOrDefault(ss[0], new HashSet<>());
            set.add(ss[1]);
            sendShingo.put(ss[0], set);
        }

        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            Set<String> set = sendShingo.get(id_list[i]);
            if(set==null || set.size()==0){
                answer[i] = 0;
            }else{
                answer[i] = (int) set.stream().filter(someone -> shingo.get(someone) >= k).count();
            }
         }
        return answer;
    }
}


