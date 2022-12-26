public class Solution {
    public static void main(String[] args){
        solution(3, 1, 20);
    }
    public static int solution(int a, int b, int n) {
        return cola(a, b, n, 0);
    }
    public static int cola(int a, int b, int empty, int cola){
        if(empty < a) {
            return cola;
        }

        int newCola = empty/a * b;

        return cola(a, b
                , newCola + empty%a
                , newCola + cola);
    }
}

