import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution2 {
    //https://programmers.co.kr/learn/courses/30/lessons/1829
    //카카오 프렌즈 컬러링북
    //테스트통과, 실행은 실패.

    int areaCnt;
    int maxArea;

    class Point{
        int x;
        int y;
        boolean visited;
        int color;
        public Point(int x, int y, int color){
            this.x=x;
            this.y=y;
            this.visited=false;
            this.color=color;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        areaCnt = 0;
        maxArea = 0;
        List<Point> list = new ArrayList<>();
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (picture[x][y] != 0) {
                    list.add(new Point(x, y, picture[x][y]));
                }

            }
        }
        bfs(list, picture);
        return new int[]{areaCnt, maxArea};

    }

    public void bfs(List<Point> points, int[][] picture) {
        Queue<Point> q = new LinkedList<Point>();
        while (!points.isEmpty() && !points.stream().allMatch(c -> c.visited)) {
            Point select = points.stream().filter(p -> !p.visited).findFirst().orElse(null);

            q.offer(select);
            int area = 0;
            while (!q.isEmpty()) {
                Point point = q.poll();
                area++;
                point.visited = true;
                List<Point> willVisit = willVisitListAlongSameColor(point, picture);
                for (Point visit : willVisit) {
                    q.add(visit);
                }
                points.removeAll(willVisit);
            }
            areaCnt++;
            maxArea = Math.max(maxArea, area);
        }
    }
    private List<Point> willVisitListAlongSameColor(Point position, int[][] picture){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        List<Point> result = new ArrayList<>();

        for(int i = 0; i<4; i++){
            int newX = position.x;
            int newY = position.y;

            if(position.x + dx[i] >= 0 && position.x + dx[i] <= picture.length-1){
                newX = position.x + dx[i];
            }

            if(position.y + dy[i] >= 0 && position.y + dy[i] <= picture[0].length-1){
                newY = position.y + dy[i];
            }

            if(newX != position.x && newY != position.y && ){
                result.add(new Point(newX, newY, picture[newX][newY]));
            }
        }
        return result;

        /*
        return  points.stream()
                .filter(p -> !p.visited && p.color == position.color
                        && !q.contains(p)
                        && Math.abs(p.x - position.x) <= 1 && Math.abs(p.y - position.y) <= 1 && !(Math.abs(p.x - position.x) == 1 && Math.abs(p.y - position.y) == 1))
                .collect(Collectors.toList());
         */
    }
}
