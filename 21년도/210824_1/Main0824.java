import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main0824 {

    public static void main(String[] args){
        String[] table = new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = new String[]{"PYTHON", "C++", "SQL"};
        int[] preference = new int[]{7, 5, 5};
        System.out.println(solution(table, languages, preference));
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        //언어선호도 X 직업군 언어점수의 합
        Map<String, Integer> map1 = new HashMap<>(); //직업군 key, 합계 점수 value
        Map<String, Map<String, Integer>> map2 = new HashMap<>(); //직업군 key, 각 언어의 점수
        for(int i=0; i<table.length; i++){
            String[] tableSplit = table[i].split(" ");
            Map<String, Integer> score = new HashMap<>();
            for(int j=1; j<tableSplit.length; j++){
                score.put(tableSplit[j], 6-j);
            }
           map2.put(tableSplit[0], score);
        }

        for(int i=0; i<languages.length; i++){
            for(Map.Entry<String, Map<String, Integer>> entry : map2.entrySet()){
                String work = entry.getKey();
                map1.put(work, map1.getOrDefault(work, 0) + preference[i] * map2.get(work).getOrDefault(languages[i],0));

            }
        }

        return map1.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

}
