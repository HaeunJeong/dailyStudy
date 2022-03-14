import java.util.*;
class Test0629_1 {
    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        Map<Integer, Integer> mapX = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for(int[] temp : v){
            mapX.put(temp[0], mapX.getOrDefault(temp[0],0)+1);
            mapY.put(temp[1], mapX.getOrDefault(temp[1],0)+1);
        }

        answer[0] = mapX.keySet().stream().filter(x->mapX.getOrDefault(x, -1).intValue()==1).findAny().get().intValue();
        answer[1] = mapY.keySet().stream().filter(y->mapY.getOrDefault(y, -1).intValue()==1).findAny().get().intValue();


        return answer;
    }

    public static void main (String[] args){

        String tc1 = "[[1, 4], [3, 4], [3, 10]]";
        System.out.println(solution(toIntegerDoubleArray(tc1)));

    }
    public static int[][] toIntegerDoubleArray(String temp){
        Set<Character> notNumber = new HashSet<>();
        notNumber.add('[');
        notNumber.add(']');
        notNumber.add(',');
        notNumber.add(' ');
        char[] chars = temp.toCharArray();
        List<Integer> tempIntStore = new ArrayList<>();
        boolean flag = false; //한번 숫자 들어가면 true, 다음이 문자면 false;
        for(int i=0; i<chars.length; i++){
            if( !notNumber.contains(chars[i])){
                if(flag){
                    char tempNum = Character.forDigit(tempIntStore.remove(tempIntStore.size() - 1),10);
                    tempIntStore.add(Integer.parseInt(new StringBuilder().append(tempNum).append(chars[i]).toString()));
                    flag = true;
                }else{
                    tempIntStore.add(chars[i]-'0');
                    flag = true;
                }

            }else{
                flag = false;
            }
        }

/*
        int[] v1 = new int[2];
        int[] v2 = new int[2];
        int[] v3 = new int[2];

        for(int i=0; i<2; i++){
            v1[i] = tempIntStore.get(i);
            v2[i] = tempIntStore.get(i+2);
            v3[i] = tempIntStore.get(i+4);
        }
        int[][] result = new int[2][3];
        result[0] = v1;
        result[1] = v2;
        result[2] = v3;
*/
        //"[[1, 4], [3, 4], [3, 10]]";
        int[] v1 = new int[]{1, 4};
        int[] v2 = new int[]{3,4};
        int[] v3 = new int[]{3,10};

        int[][] result = new int[3][2];
        result[0] = v1;
        result[1] = v2;
        result[2] = v3;

        return result;
    }
}