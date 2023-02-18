import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    /** 송아지 찾기 BFS*/

    public static void main(String[] args){
        System.out.println(BFS2(5, 14));
    }
    public static int BFS(int s, int e) {

        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[10001]; // 여기서는 값이 들어가있는지 여부.
        int[] dx = {-1, 1, 5};

        int level = -1;
        q.offer(s);

        while(!q.isEmpty()){
            level++;
            int len = q.size();
            for(int i=0; i<len; i++){
                int next = q.poll();
                if(next == e) {
                    return level;
                }

                for(int j=0; j<dx.length; j++) {
                    if(visited[next+dx[j]]==0) {
                        q.offer(next+dx[j]);
                        visited[next+dx[j]] = 1;
                    }
                }
            }


        }

        return -1;
    }

    public static int BFS2(int s, int e){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[10001];
        queue.offer(s);

        int[] dx = {-1, 1, 5};

        int level = 0;
        while(!queue.isEmpty()) {
            int len = queue.size(); // 같은 레벨의 노드들은 전부 탐색.
            for(int i=0; i<len; i++){
                int node = queue.poll();
                if(node == e) return level;

                for(int j=0; j<3; j++) {
                    int next = node+dx[j];
                    if(visited[next]==0 && next>0){
                        queue.offer(next);
                        visited[next] = 1;
                    }
                }
            }
            level++;
        }

        return -1;
    }
}
