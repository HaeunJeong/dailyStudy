import java.io.*;
class Main0503_2 {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            System.out.println("Hello Goorm! Your input is " + input);

            char[] moum = {'a', 'e', 'i', 'o', 'u'};
            String[] str = input.split("\n");
            int n = Integer.parseInt(str[0]);

            String result;
            for(int i = 1; i<n+1; i++){
                char[] chars = str[i].toCharArray();
                for(char c : chars){
                    if(moum.contains(c)){
                        result+=c+"";
                    }
                }
                result += "";
            }

            System.out.println(result);
        }

}
