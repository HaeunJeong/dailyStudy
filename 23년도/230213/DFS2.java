public class DFS2 {

    static int[][] graph;
    static boolean[] checked;
    static int n = 5;
    public static void main(String[] args){

        int n = 5;
        graph = new int[n+1][n+1];
        checked = new boolean[n+1];
        graph[1][2] = 1;
        graph[1][3] = 1;
        graph[1][4] = 1;
        graph[2][1] = 1;
        graph[2][3] = 1;
        graph[2][5] = 1;
        graph[3][4] = 1;
        graph[4][2] = 1;
        graph[4][5] = 1;

        checked[1] = true;
        DFS(1);

    }

    public static void DFS(int v){
        //1에서 노드 5 까지의 모든 경로를 출력
        if(v == 5){
            System.out.print(v);
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                if(graph[v][i] == 1 && !checked[i]){
                    System.out.print(v + " -> ");
                    checked[i] = true;
                    DFS(i);
                    checked[i] = false; // 백트래킹을 위해
                }
            }
        }
    }
}
