import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main1123_1 {

    public static void main(String[] args){
        System.out.println("???");
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(solution(info,query).toString());
    }
    public static int[] solution(String[] info, String[] query) {

        List<Candi> candiList = Arrays.stream(info).map(s->s.split(" ")).map(c->new Candi(c)).collect(Collectors.toList());
        List<Object[]> queryList = Arrays.stream(query)
                .map(array->Arrays.stream(array.split(" "))
                        .filter(s->!s.equals("and")).toArray())
                .collect(Collectors.toList());

        return queryList.stream().map(condition-> candiList.stream().filter(candi->
                                                                    pass(candi.lang,(String)condition[0])
                                                                && pass(candi.major, (String)condition[1])
                                                                && pass(candi.grade,(String)condition[2])
                                                                && pass(candi.food, (String)condition[3])
                                                                && candi.score>=Integer.valueOf((String)condition[4]).intValue()
                                                                ).count()).mapToInt(c->c.intValue()).toArray();


    }
    private static boolean pass(String factor, String condition){
        return factor.equals(condition) || condition.equals("-");
    }
    static class Candi{
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
