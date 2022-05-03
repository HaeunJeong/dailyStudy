import java.io.*;
class Main {
    static int n;
    static int m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        String[] nm = NM.split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        int day = Integer.parseInt(br.readLine());

        for(int i=0; i<day; i++){
            if(i%2==0){
                nTom();
            }else{
                mTon();
            }
        }

        System.out.println(n +" " + m);
    }
    public static void nTom(){
        if(n % 2==0){
            m += n/2;
            n = n/2;
        }else{
            m += n/2+1;
            n = n/2;
        }
    }
    public static void mTon(){
        if(m % 2==0){
            n += m/2;
            m = m/2;
        }else{
            n += m/2+1;
            m = m/2;
        }
    }
}

