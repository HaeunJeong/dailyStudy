public class MainTest {

    public static void main(String[] args){
        System.out.println(solution(8, 4,7));
    }
    public static int solution(int n, int a, int b)
    {
        return recursive(n, a, b, 1);
    }
    public static int recursive(int n, int a, int b, int depth){

        // 더 큰 수가 짝수여야 만남.
        int bigger = a>b ? a : b;
        if(Math.abs(a-b)==1 && bigger%2==0){
            return depth;
        }

        int newA = (int) Math.ceil((double)a/2);
        int newB = (int) Math.ceil((double)b/2);

        return recursive(n/2, newA, newB, ++depth);
    }
}
