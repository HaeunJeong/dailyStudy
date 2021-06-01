import java.util.*;

// Write your Checker class here

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class SolutionComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}

class Checker implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        if( ((Player)o1).score == ((Player)o2).score){
            return ((Player) o1).name.compareTo(((Player)o2).name);
        }
        return  ((Player)o1).score > ((Player)o2).score ? -1 : 1;
    }
}