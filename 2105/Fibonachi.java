package programmers.main;

import java.util.*;
class Fibonachi {
    Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        public int solution(int n) {
            return findFibonachiNum(n)%1234567;
        }
        public int findFibonachiNum(int n){
            //Butom-up 방식
            map.put(0,0);
            map.put(1,1);
            for(int i=2; i<=n; i++){
                map.put(i,map.get(i-1)+map.get(i-2));
            }

            //int result = map.getOrDefault(n-1,findFibonachiNum(n-1)).intValue() + map.getOrDefault(n-2,findFibonachiNum(n-2)).intValue();
            //map.put(n,result);


            return map.get(n);
            //return findFibonachiNum(n-1)+findFibonachiNum(n-2);
        }
}