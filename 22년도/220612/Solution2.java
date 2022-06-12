import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution2 {
    //순위검색 새로운 풀이 
    public int[] solution(String[] info, String[] query) {

        List<Candi> candiList = Arrays.stream(info).map(s->s.split(" ")).map(c->new Candi(c)).collect(Collectors.toList());

        List<Object[]> queryList = Arrays.stream(query)
                .map(array->Arrays.stream(array.split(" "))
                        .filter(s->!s.equals("and")).toArray())
                .collect(Collectors.toList());

        int[] result = new int[query.length];

        for(int i=0; i<query.length; i++){
            int count = 0;
            Object[] condition = queryList.get(i);
            for(Candi candi : candiList){
                if(pass(candi.lang,(String)condition[0])
                        && pass(candi.major, (String)condition[1])
                        && pass(candi.grade,(String)condition[2])
                        && pass(candi.food, (String)condition[3])
                        && candi.score>=Integer.valueOf((String)condition[4]).intValue()){
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
/*        return queryList.stream().map(condition-> candiList.stream().filter(candi->
                pass(candi.lang,(String)condition[0])
                        && pass(candi.major, (String)condition[1])
                        && pass(candi.grade,(String)condition[2])
                        && pass(candi.food, (String)condition[3])
                        && candi.score>=Integer.valueOf((String)condition[4]).intValue()
        ).count()).mapToInt(c->c.intValue()).toArray();*/

    }

    private  boolean pass(String factor, String condition){
        return factor.equals(condition) || condition.equals("-");
    }
    class Candi{
        String lang;
        String major;
        String grade;
        String food;
        int score;

        public Candi(String[] info) {
            this.lang = info[0];
            this.major = info[1];
            this.grade = info[2];
            this.food = info[3];
            this.score = Integer.valueOf(info[4]).intValue();
        }
    }
}