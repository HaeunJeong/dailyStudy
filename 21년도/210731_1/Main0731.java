import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main0731 {
    public static class Word{
        String word;
        boolean checked;//선정되었다.
        public Word(String word){
            this.word = word;
            this.checked = false;
        }
        public String getWord(){
            return this.word;
        }
    }
    static int checkCount = 0;

    public static void main(String[] args){
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }
    public static int solution(String begin, String target, String[] words) {
        if(!Stream.of(words).anyMatch(s->s.equals(target))){
            return 0;
        }
        List<Word> wordList = Arrays.stream(words).map(s->new Word(s)).collect(Collectors.toList());
        dfs(begin, target,wordList, 0);
        return checkCount;
    }

    public static void dfs(String begin, String target, List<Word> wordList, int step){

        if(begin.equals(target)){
            checkCount=step;
            return;
        }

        for(int i=0; i<wordList.size(); i++){

            if(wordList.get(i).checked==false && differCount(begin, wordList.get(i).getWord())==1){
                wordList.get(i).checked=true;
                dfs(wordList.get(i).getWord(), target,wordList,step+1);
                wordList.get(i).checked=false;
            }
        }

    }
    public static Word getOneDifferOnlyOne(String begin, List<Word> words){
        //방문안한것들 중에서, 1개만 다른 문자열 리턴.
        return words.stream()
                .filter(w->w.checked==false && differCount(begin, w.word)==1)
                .findFirst()
                .orElse(null);
    }

    public static long differCount(String begin, String target){

        int differCount = 0;
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i)!=target.charAt(i)){
                differCount++;
            }
        }
        return differCount;
    }
}
