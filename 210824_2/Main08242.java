import java.util.Arrays;
import java.util.List;

public class Main08242 {
    Position leftCurrent = new Position(3,0);
    Position rightCurrent = new Position(3,2);
    public String solution(int[] numbers, String hand) {
        StringBuilder builder = new StringBuilder();
        for(int target : numbers){
            builder.append(getHands(target, hand));
        }

        return builder.toString();
    }

    public String getHands(int target, String hand){
        List<Integer> leftSide = Arrays.asList(1,4,7);
        List<Integer> rightSide = Arrays.asList(3,6,9);
        if(leftSide.contains(target)){
            leftCurrent = getCurrent(target);
            return "L";
        }else if(rightSide.contains(target)){
            rightCurrent = getCurrent(target);
            return "R";
        }else{

            if(getLength(rightCurrent, getCurrent(target)) > getLength(leftCurrent, getCurrent(target))){
                leftCurrent = getCurrent(target);
                return "L";
            }else if(getLength(leftCurrent, getCurrent(target)) > getLength(rightCurrent, getCurrent(target))){
                rightCurrent = getCurrent(target);
                return "R";
            }else{
                if(hand.equals("left")){
                    leftCurrent = getCurrent(target);
                    return "L";
                }else{
                    rightCurrent = getCurrent(target);
                    return "R";
                }
            }
        }
    }

    public int getLength(Position p1, Position p2){
        return Math.abs(p1.width - p2.width) + Math.abs(p1.hight - p2.hight);
    }

    public Position getCurrent(int target){
        switch(target){
            case 1: return new Position(0,0);
            case 2: return new Position(0,1);
            case 3: return new Position(0,2);
            case 4: return new Position(1,0);
            case 5: return new Position(1,1);
            case 6: return new Position(1,2);
            case 7: return new Position(2,0);
            case 8: return new Position(2,1);
            case 9: return new Position(2,2);
            case 0: return new Position(3,1);
        }
        return null;
    }
    public class Position{
        int hight;
        int width;
        public Position(int hight, int width){
            this.hight = hight;
            this.width = width;
        }
    }
}
