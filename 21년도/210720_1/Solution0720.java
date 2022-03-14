public class Solution0720 {

        int answer = 100000;
        public int solution(int N, int number) {
            dfs(N, number, 0, 0);
            if(answer > 8){
                return -1;
            }
            return answer;
        }

        private void dfs(int N, int number, int Ncount, int result){

            if(Ncount>8) return;

            if(result==number){
                answer = Math.min(Ncount, answer);
            }

            int tempN = N; //NN, NNN,...
            for(int i=0; i<8-Ncount; i++){
                dfs(N, number, Ncount+1+i, result+tempN);
                dfs(N, number, Ncount+1+i, result-tempN);
                dfs(N, number, Ncount+1+i, result*tempN);
                dfs(N, number, Ncount+1+i, result/tempN);

                tempN = tempN*10+N;

            }
        }

}
