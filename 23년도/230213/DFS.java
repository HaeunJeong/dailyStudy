import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {

    static class Node{
        int data;
        boolean visited;
        Node leftNode;
        Node rightNode;

        public Node(int n){
            this.data = n;
        }


    }

    public static int DFS(Node head){

        int level = 0;
        int min = 0;

        Stack<Node> stack = new Stack<>();
        stack.push(head);

        while(!stack.isEmpty()){
            Node current = stack.pop();
            current.visited = true;

            while(current.leftNode != null && !current.leftNode.visited) {
                stack.push(current);
                current = current.leftNode;
                current.visited = true;
                level++;
            }

            min = Math.min(min, level);



        }
        return 0;
    }

    public static int DFS2(int level, Node root){

        if(root.leftNode == null && root.rightNode == null){
            return level;
        }

        return Math.min(DFS2(level+1, root.leftNode), DFS2(level+1, root.rightNode));
    }

    public static int BFS(Node root){

       Queue<Node> q = new LinkedList<>();

       q.offer(root);
       int depth = 0;
       while(!q.isEmpty()) {
           int len = q.size();
           for(int i=0; i<len; i++){
               Node current = q.poll();

               if(current.leftNode == null && current.rightNode == null){
                   return depth;
               }

               q.offer(current.leftNode);
               q.offer(current.rightNode);

           }
           depth++;
       }
       return depth;
    }

    public static void main(String[] args){

        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node.leftNode = node2;
        node.rightNode = node3;

        node2.leftNode = node4;
        node2.rightNode = node5;

        System.out.println(DFS(node));
        System.out.println(DFS2(0, node));
        System.out.println(BFS(node));

    }
}
