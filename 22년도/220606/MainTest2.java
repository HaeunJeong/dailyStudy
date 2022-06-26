import java.util.*;
import java.util.stream.Collectors;

public class MainTest2 {

    /*메뉴 리뉴얼 1 */
    static Set<String> menuList = new HashSet<>();

    public static void main(String[] args){
        String[] orders = {"GCABF", "CA", "ECD", "ECDA", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        System.out.println(solution(orders, course));
    }
    public static String[] solution(String[] orders, int[] course) {
        Map<String, Integer> menuSet = new HashMap<>();
        for(String order: orders){
            for(int i: course){
                combination(order.split(""), new boolean[order.length()],0,order.length(),i );
            }
            for(String s: menuList){
                menuSet.put(s, menuSet.getOrDefault(s,0)+1);
            }
            menuList.clear();
        }
        List<String> setList = new ArrayList<>();
        for(int i : course) {
            setList.addAll(getList(menuSet, i));
        }
        return setList.stream().sorted().toArray(String[]::new);
    }
    public static List<String> getList(Map<String, Integer> menuSet, int length){
        int maxCount = menuSet.entrySet().stream().filter(c->c.getKey().length()==length)
                .map(c->c.getValue()).max((a,b)->a.intValue()-b.intValue()).orElse(0).intValue();

        return menuSet.entrySet().stream().filter(s->s.getValue()>=2 && s.getKey().length()==length)
                .filter(c->c.getValue()==maxCount)
                .map(c->c.getKey()).collect(Collectors.toList());
    }
    public static void combination(String[] args, boolean[] visited, int depth, int n, int r){
        if(r==0){
            menuList.add(getString(args, visited));
        }
        if(depth == n){
            return;
        }
        visited[depth] = true;
        combination(args, visited, depth+1, n, r-1);

        visited[depth] = false;
        combination(args, visited, depth+1, n, r);
    }

    public static String getString(String[] args, boolean[] visited){
        Set<String> sortedSet = new HashSet<>();
        for(int i=0; i<args.length; i++){
            if(visited[i]){
                sortedSet.add(args[i]);
            }
        }
        return sortedSet.stream().reduce("", (a,b)->a+b);
    }
}
