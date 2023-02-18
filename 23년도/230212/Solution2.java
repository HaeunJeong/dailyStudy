import java.util.Arrays;

class Solution2 {

    public static void main(String[] args){
        int[][] ss = new int[3][2];
        ss[0] = new int[]{0, 30};
        ss[1] = new int[]{5, 10};
        ss[2] = new int[]{15, 20};

        minMeetingRooms(ss);
    }
    public static int minMeetingRooms(int[][] intervals) {

        int[][] room = new int[10000][1000000];
        int roomNum = 0;
        for(int i=0; i<intervals.length; i++){

            int s = intervals[i][0];
            int e = intervals[i][1];

            int j;
            for(j=0 ; j<roomNum; j++) {
                while(s++ <= e){
                    if(room[j][s] != 0) {
                        break;
                    }
                    if(s==e){
                        Arrays.fill(room[j], intervals[i][0], intervals[i][1], 1 );
                        s++;
                        j=roomNum;
                    }
                }
            }
            if(j==roomNum && s<e){
                roomNum++;
            }
        }
        return roomNum;
    }
}