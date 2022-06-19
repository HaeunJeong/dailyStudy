import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution3 {
    //https://programmers.co.kr/learn/courses/30/lessons/1829
    //카카오 프렌즈 컬러링북
    // new 접근..



    public int[] solution(int m, int n, int[][] picture) {

        return bfs2(picture, m, n);
    }
    class Point{
        int x;
        int y;
        int color;
        public Point(int x, int y, int color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    private int[] bfs2(int[][] picture, int m, int n){
        int areaCnt = 0;
        int maxArea = 0;
        int visitCount = 0;
        boolean[][] visited = new boolean[m][n];
        int allPointCount = getNotZeroValueCount(picture);

        int mIndex = 0;
        int nIndex = 0;
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0, 0, picture[0][0]));

        while(!q.isEmpty()){

            Point point = q.poll();
            if(point.color != 0){
                visited[point.x][point.y] = true;
            }else{
                if(q.isEmpty()){

                }else{
                    continue;
                }

            }


            visitCount++;

            //상하좌우중, 방문하지 않은 걸 q에 넣어준다.
            q.addAll(getNotVisitedPoint(point));


        }



        return new int[]{areaCnt, maxArea};
    }
    private List<Point> getNotVisitedPoint(Point position){

    }
    private int getNotZeroValueCount(int[][] values){
        int count = 0 ;
        for(int[] i: values){
            for(int j: i){
                if(j != 0) count++;
            }
        }
        return count;
    }

}
