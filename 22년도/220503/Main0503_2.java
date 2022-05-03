import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main0503_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int n = Integer.parseInt(input);

        List<Character> moum = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));


        for(int i = 0; i<n; i++){
            String result="";
            String inputStr = br.readLine();
            char[] chars = inputStr.toCharArray();
            for(char c : chars){
                if(moum.contains(Character.toLowerCase(c))){
                    result+=c+"";
                }
            }
            if(result.isEmpty()){
                result +="???";
            }
            System.out.println(result);
        }

    }
}
