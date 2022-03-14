import java.util.LinkedList;
import java.util.Queue;

public class Main0121_1 {

    public static void main(String[] args){
        int[][] maps = new int[5][5];
        maps[0] = new int[]{1,0,1,1,1};
        maps[1] = new int[]{1,0,1,0,1};
        maps[2] = new int[]{1,0,1,1,1};
        maps[3] = new int[]{1,1,1,0,1};
        maps[4] = new int[]{0,0,0,0,1};


        System.out.println(solution(maps));
    }
    public static int solution(int[][] maps) {
        return getShortestPath(maps);
    }


    public static class Node {
        int col;
        int row;
        int depth;

        public Node(int x, int y, int depth) {
            this.col = x;
            this.row = y;
            this.depth = depth;
        }
    }

    public static int getShortestPath(int[][] maps){
        //시작지점: maps[0][0]  도작치점: maps[n-1][m-1]
        //갈수있는 노드를 계속 add 해나가다가, 도착지점에 도달했을때, 거기까지 도달한 depth를 파악.
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        int[] dcol = {1,-1, 0, 0 };
        int[] drow = {0, 0, -1, 1};

        queue.offer(new Node(0,0, 1));

        while(!queue.isEmpty()){
            Node candiNode = queue.poll();

            if(candiNode.col==maps[0].length-1 && candiNode.row==maps.length-1){
                return candiNode.depth;
            }

            for(int i=0; i<4; i++){
                int newCol = candiNode.col + dcol[i];
                int newRow = candiNode.row + drow[i];

                if(newRow<maps.length && newRow>=0 && newCol<maps[0].length && newCol>=0
                        && maps[newRow][newCol]==1 && !visited[newRow][newCol]
                ){
                    visited[candiNode.row][candiNode.col] = true;
                    queue.offer(new Node(newCol, newRow, candiNode.depth+1));
                }
            }
        }
        return -1;
    }
}
