public class Main_1110 {
    public int solution(int n) {

        int x = 2;
        while(true){
            if(n%x==1){
                break;
            }else{
                x++;
            }
        }
        return x;
    }
}
