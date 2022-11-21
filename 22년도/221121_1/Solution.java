class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            int originPower = getOriginPower(i); //약수의 갯수
            if(originPower>limit){
                answer+=power;
            }else{
                answer+=originPower;
            }

        }


        return answer;
    }

    public int getOriginPower(int N){
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (i * i == N) count++;
            else if (N % i == 0) count += 2;
        }
        return count;
    }
}
