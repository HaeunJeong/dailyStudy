import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args){
        romanToInt("III");
    }

    public static int romanToInt(String s) {
        //('I', 'V', 'X', 'L', 'C', 'D', 'M').
        char[] charArray = s.toCharArray();

        int result = 0;
        int i=0;
        for( i=0; i<charArray.length-1; i++){
            int currentNum = Roman.getNum(charArray[i]);
            int afterNum = Roman.getNum(charArray[i+1]);
            if(currentNum >= afterNum){
                result += currentNum;
            }else{
                result += (afterNum-currentNum);
                i++;
            }
        }

        if(i < charArray.length) {
            result += Roman.getNum(charArray[i]);
        }

        return result;
    }


    enum Roman{
        I('I', 1),
        V('V', 5),
        X('X', 10),
        L('L', 50),
        C('C', 100),
        D('D', 500),
        M('M', 1000)
        ;


        public char getRoman() {
            return roman;
        }

        public int getNum() {
            return num;
        }

        private char roman;
        private int num;

        Roman(char v, int i) {
            this.roman = v;
            this.num = i;
        }

        private static Map<Character, Roman> map = Stream.of(Roman.values()).collect(Collectors.toMap(c->c.getRoman(), c->c));

        public static int getNum(char roman){
            return map.get(roman).getNum();
        }
    }
}