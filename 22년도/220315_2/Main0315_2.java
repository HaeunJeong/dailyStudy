public class Main0315_2 {

    public int[] solution(int n) {
        int[][] arr = new int[n][n];

        int row = -1;
        int col = 0;

        int cnt = 0; //칸
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) //아래
                    row++;
                else if (i % 3 == 1) { //오른쪽
                    col++;
                } else if (i % 3 == 2) { //대각선
                    row--;
                    col--;
                }
                cnt++;
                arr[row][col] = cnt;
            }
        }

        int[] answer = new int[cnt];
        int k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 0) break;
                answer[k++] = arr[i][j];
            }
        }
        return answer;
    }
}
