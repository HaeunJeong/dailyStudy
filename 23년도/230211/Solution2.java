class Solution2 {

    public static void main(String[] args){
        solution(437674, 3);
    }

    public static int solution(int n, int k) {
        int answer = 0;
        String kth = Long.toString(n, k);

        String[] nums =kth.split("0");
        for(String num: nums){
            if(num.length()>0 && isPrime(Long.parseLong(num))) answer++;
        }

        return answer;
    }

    public static boolean isPrime(long n){
            if(n==1){
                return false;
            }


        for(int i = 2; i<= Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}