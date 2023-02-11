public class Solution3 {

    /** 2pointer 로 부분수열 구하기 */
    public static void main(String[] args){
        solution(new int[]{1,1,0,0,1,1,0,1,1,0,1,1,0,1}, 2);
    }

    //11001101101101 2
    public static int solution(int[] arr, int k){

        int answer = 0;
        int lt = 0, rt = 0;
        int cnt = 0; // 0을 1로 바꾼 횟수

        while(lt < arr.length && rt < arr.length) {
            if(arr[rt] == 1){
                rt++;
            }else if(arr[rt] == 0 && cnt < k){
                rt++;
                cnt++;
            }else{
                //lt 움직이기
                while(arr[lt]==1){
                    lt++;
                }
                cnt--;
            }
            answer = Math.max(answer, rt-lt+1);
        }
        return answer;
    }

}
