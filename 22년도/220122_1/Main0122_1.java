import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class Main0122_1 {

    public int[] solution(String[][] places) {

        int[] result = new int[places.length];
        for(int i=0; i<places.length; i++){

            String[] place = places[i];
            char[][] placeInt = new char[5][5];
            for(int j=0; j<5; j++){
                placeInt[j] = place[j].toCharArray();
            }

            Queue<Node> queue = new LinkedList<>();
            List<Node> pNode = getPNode(placeInt);

            while(true){
                Node node = pNode.stream().filter(n->!n.visit).findAny().get();
                if(node == null){
                    result[i] = 1;
                    break;
                }
                queue.add(node);
                while(!queue.isEmpty()){
                    Node willVisit = queue.poll();
                    if(getDistance2NodeList(willVisit).stream().anyMatch(n->placeInt[n.row][n.col]!='P')){
                        break;
                    }

                }
            }
        }

    }
    public List<Node> getPNode(char[][] placeInt ){
        List<Node> list = new ArrayList<>();
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(placeInt[i][j]=='P'){
                    list.add(new Node(j,i));
                }
            }
        }
        return list;
    }

    public int getDistance (Node x, Node y){
        return Math.abs(x.col-y.col) + Math.abs(x.row-y.row);
    }
    public List<Node> getDistance2NodeList(Node start){
        List<Node> list = new ArrayList<>();

        int[] dx = {0,-1,-2,-1,0,1,2,1};
        int[] dy = {2,1,0,-1,-2,-1,0,1};

        for(int d=0; d<8; d++){
            int nCol = start.col+dx[d];
            int nRow = start.row+dy[d];

            if(nCol>=0 && nCol<5 && nRow>=0 && nCol<5){
                list.add(new Node(nCol, nRow));
            }
        }
        return list;
    }
    public List<Node> getDistance1NodeList(Node start){
        List<Node> list = new ArrayList<>();

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,-1,1};

        for(int d=0; d<4; d++){
            int nCol = start.col+dx[d];
            int nRow = start.row+dy[d];

            if(nCol>=0 && nCol<5 && nRow>=0 && nCol<5){
                list.add(new Node(nCol, nRow));
            }
        }
        return list;
    }

    public class Node {
        int col ;
        int row ;

        boolean visit = false;

        public Node(int col, int row){
            this.col = col;
            this.row = row;
        }
    }

}
