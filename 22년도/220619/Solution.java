import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
    //https://programmers.co.kr/learn/courses/30/lessons/17683
    //방금그곡, KMP알고리즘

    public String solution(String m, String[] musicinfos) {
        int[] pi = getPiArray(m);
        Map<String, Integer> resultMap = new HashMap<>();

        for (String music : musicinfos) {
            String[] spliteS = music.split(",");
            int minute = getMinute(spliteS[0], spliteS[1]);
            String totalMusic = getTotalMusic(spliteS[3], minute);

            if(KMP(totalMusic, m, pi)){
                resultMap.put(spliteS[2], minute);
            }
        }

        if(resultMap.values().size() > 1){
            return resultMap.keySet().stream().max(Comparator.comparingInt(resultMap::get)).get();
        }else if(resultMap.values().size() == 1){
            return resultMap.keySet().stream().findFirst().get();
        }else {
            return "(None)";
        }
    }

    private int getMinute(String start, String end) {

        StringTokenizer st = null;
        st = new StringTokenizer(start,":");
        int startTime = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());

        st = new StringTokenizer(end,":");
        int endTime = Integer.parseInt(st.nextToken())*60 + Integer.parseInt(st.nextToken());

        return endTime-startTime;
    }

    private String getTotalMusic(String pattern, int minute) {
        return "";
    }

    private boolean KMP(String str, String pattern, int[] p) {
        int j=0;
        for(int i=0;i<str.length();i++) {
            while(j>0 && str.charAt(i)!=pattern.charAt(j)) {
                j=p[j-1];
            }
            if(str.charAt(i)==pattern.charAt(j)) {
                if(j==pattern.length()-1) {
                    j=p[j];
                    return true;
                }else {
                    j++;
                }

            }
        }
        return false;
    }

    private int[] getPiArray(String pattern) {

        int[] p =new int[pattern.length()];

        int j=0;
        for(int i=1;i<pattern.length();i++) {
            while(j>0 && pattern.charAt(i)!=pattern.charAt(j)) {
                j=p[j-1];
            }

            if(pattern.charAt(i)==pattern.charAt(j)) {
                j++;
                p[i]=j;
            }
        }

        return p;
    }
}
