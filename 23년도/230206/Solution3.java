import java.util.Arrays;
import java.util.Comparator;

public class Solution3 {

    public static void main(String[] args){
        //[[1,4],[0,2],[3,5]]
        int[][] intervals = new int[3][2];
        intervals[0] = new int[]{1,4};
        intervals[1] = new int[]{0,2};
        intervals[2] = new int[]{3,5};
        System.out.println(merge(intervals));
    }
    public static int[][] merge(int[][] intervals) {

        int[][] res = new int[intervals.length][2];

        if(intervals.length == 1){
            res[0] = intervals[0];
            return Arrays.copyOf(res, 1);
        }

        //정렬을, 시작 기준으로
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int j = 0;

        for(int i =0; i<intervals.length ; i+=2){
            if(i+1 >= intervals.length ){
                res[j++] = intervals[i];
            }else{
                int[] merged = merge(intervals[i], intervals[i+1]);
                if(merged!=null){
                    res[j++] = merged;
                }else{
                    res[j++] = intervals[i];
                    res[j++] = intervals[i+1];
                }
            }

        }

        return Arrays.copyOf(res, j);

    }
    public static int[] merge(int[] a, int[] b){
        int[] res = new int[2];
        if(a[1] >= b[0]) {
            res[0] = a[0];
            if(a[1] <= b[1]){
                res[1] = b[1];
            }else{
                res[1] = a[1];
            }
            return res;
        }

        return null;
    }
}
