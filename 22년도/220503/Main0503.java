import java.io.*;
class Main0503 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int result = 0;
        String[] words = input.split(" ");

        for(String word: words){
            if(!word.isEmpty()){
                result++;
            }
        }
        System.out.println(result);

    }
}