import java.util.Scanner;

public class MainTest {
    /**
    * int 입력 형식
    * */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] numbers = new int[N];
        for(int i = 0; i<N; i++){
            numbers[i] = sc.nextInt();
        }

    }

    /**
    sql
    * */
    /**
     *
     select
     F.NAME
     , G.GRADE
     , F.D_RATE
     , CASE WHEN G.GRADE < 'D' THEN '' ELSE 'O' END
     FROM
     (SELECT
     NAME,
     ROUND(D_QTY/P_QTY*100, 3)  as D_RATE
     FROM FACTORIES
     ) F,  GRADES G
     WHERE F.D_RATE BETWEEN G.MIN_D_RATE AND IFNULL(G.MAX_D_RATE, 100)
     ORDER BY
     G.GRADE,
     (CASE WHEN G.GRADE < 'D' THEN F.D_RATE END) ASC,
     (CASE WHEN G.GRADE >= 'D' THEN F.D_RATE END) DESC,
     F.NAME


     /*
     WITH R AS (
     SELECT NAME,
     ROUND((D_QTY/P_QTY)*100, 3) AS 불량률
     FROM FACTORIES
     )
     ,R2 AS (
     SELECT
     R.NAME AS '공장의 이름',
     G.GRADE AS 등급,
     R.불량률 AS 불량률,
     CASE WHEN G.GRADE>='D'
     THEN 'O'
     ELSE ''
     END AS '관리대상 여부'
     FROM GRADES G
     JOIN R ON G.MIN_D_RATE <= R.불량률 AND
     R.불량률 < COALESCE(G.MAX_D_RATE,10000)
     )

     SELECT * FROM R2
     ORDER BY 등급 ASC,
     CASE WHEN 등급>='D'
     THEN 불량률 END DESC,
     CASE WHEN 등급<'D'
     THEN 불량률 END ASC,
     '공장의 이름' ASC

     */




}
