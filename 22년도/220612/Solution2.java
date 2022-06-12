import java.util.*;

class Solution2 {
    //순위검색 새로운 풀이

    List<String> keyList = new ArrayList<>();
    public int[] solution(String[] info, String[] query) {

        Map<String, ArrayList<Integer>> scoreMap = new HashMap<>();

        Arrays.sort(info, Comparator.comparingInt(a->getScoreByString(a)));

        for(String candi: info){
            String key = getKeyByCandi(candi);
            Integer score = getScoreByString(candi);
            if(scoreMap.containsKey(key)){
                ArrayList scoreList = scoreMap.get(key);
                scoreList.add(score);
                scoreMap.put(key, scoreList);
            }else{
                ArrayList<Integer> scoreList = new ArrayList<>();
                scoreList.add(score);
                scoreMap.put(key, scoreList);
            }
        }

        int[] result = new int[query.length];
        for(int i = 0; i<query.length; i++){
            int scoreSum = 0;
            List<String> keyList = getKeyList(query[i]);
            int targetScore = getScoreByString(query[i]);
            for(String key: keyList){
                if(scoreMap.containsKey(key)){
                    scoreSum += getOverScoreCount(scoreMap.get(key), targetScore);
                }
            }
            result[i] = scoreSum;
        }
        return result;

    }
    private int getOverScoreCount(ArrayList<Integer> scoreList, int targetScore){
        //scoreList 는 오름차순 정렬되어있음.
        //처음으로 targetScore를 넘는 index를 구하면, 전체 size에서 그 index까지를 빼면됨. (Lower bound)
        int start = 0;
        int end = scoreList.size()-1;
        int mid = (start+end)/2;
        while(end>start){
            mid = (start+end)/2;
            if(targetScore<=scoreList.get(mid)){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        int count = scoreList.size()-start;
        if(end==start){
            return targetScore <= scoreList.get(start) ? count : count-1;
        }else{
            return count;
        }

        //return (int) scoreMap.stream().filter(score->score>=targetScore).count(); --> 효율성이 안나옴.
    }

    private List<String> getKeyList(String query){
        //최대 24개.
        keyList = new ArrayList<>();
        String[] queryUnits = query.replaceAll("[0-9]", "").split(" and "); //["java", "-", "-", "pizza"]
        dfs(queryUnits, "", 0);
        return keyList;
    }
    private void dfs(String[] queryUnits, String making, int depth){
        if(depth==4){
            keyList.add(making);
            return;
        }

        if(depth==0 && queryUnits[depth].trim().equals("-")){
            dfs(queryUnits, "cpp", depth+1);
            dfs(queryUnits, "java", depth+1);
            dfs(queryUnits, "python", depth+1);
            //cpp, java, python
        }else if(depth==1 && queryUnits[depth].trim().equals("-")){
            dfs(queryUnits, making+"backend", depth+1);
            dfs(queryUnits, making+"frontend", depth+1);
            //backend, frontend
        }else if(depth==2 && queryUnits[depth].trim().equals("-")){
            dfs(queryUnits, making+"junior", depth+1);
            dfs(queryUnits, making+"senior", depth+1);
            //junior, senior
        }else if(depth==3 && queryUnits[depth].trim().equals("-")){
            dfs(queryUnits, making+"chicken", depth+1);
            dfs(queryUnits, making+"pizza", depth+1);
            //chicken, pizza
        }else{
            dfs(queryUnits, making+queryUnits[depth].trim(), depth+1);
        }

    }
    private String getKeyByCandi(String candi){
        String candiInfo = candi.substring(0, candi.lastIndexOf(" "));
        return candiInfo.replaceAll(" ", "");
    }
    private Integer getScoreByString(String candi){
        return Integer.valueOf(candi.substring(candi.lastIndexOf(" ")+1));
    }


}