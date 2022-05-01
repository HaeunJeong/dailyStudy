public class Main0501_1 {

    private boolean[] visited = new boolean[8];
    private String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    private int answer = 0;


    public int solution(int n, String[] data) {
        dfs("" , data);
        return answer;
    }
    public void dfs(String list, String[] conditions){

        if(list.length()==7){
            if(isComplete(list, conditions)){
                answer++;
            }
            return;
        }
        for(int i=0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                String newList = list+friends[i];
                dfs(newList, conditions);
                visited[i] = false;
            }
        }
    }

    public boolean isComplete(String list, String[] conditions){

        for(String condition: conditions) {

                char firstP = condition.charAt(0);
                char secondP = condition.charAt(2);
                char condiC = condition.charAt(3);
                char condiNum = condition.charAt(4);

                switch (condiC) {
                    case '=':
                        if (Math.abs(list.indexOf(firstP) - list.indexOf(secondP)) != condiNum-'0'+1) {
                            return false;
                        }
                        break;
                    case '>':
                        if (Math.abs(list.indexOf(firstP) - list.indexOf(secondP)) <= condiNum-'0'+1) {
                            return false;
                        }
                        break;
                    case '<':
                        if (Math.abs(list.indexOf(firstP) - list.indexOf(secondP)) >= condiNum-'0'+1) {
                            return false;
                        }
                        break;
                }
        }
        return true;
    }


}


