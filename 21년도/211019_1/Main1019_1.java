
class Main1019_1 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int hightMax = 0;
        int widthMax = 0;
        for(int i=0; i<sizes.length; i++){
            hightMax = Math.max(Math.max(sizes[i][0], sizes[i][1]),hightMax);
            widthMax = Math.max(Math.min(sizes[i][0], sizes[i][1]),widthMax);
        }
        return hightMax*widthMax;
    }
}