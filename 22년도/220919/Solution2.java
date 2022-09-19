public class Solution2 {
    public int solution(int n) {
        int ans = 0;

        //순간이동은 몇번을 해도 상관없으므로, 순간이동횟수를 늘린다.
        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }
        return ans;
    }
}
