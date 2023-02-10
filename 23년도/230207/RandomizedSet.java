import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {

    public static void main(String[] args){

           RandomizedSet obj = new RandomizedSet();
           boolean param_1 = obj.insert(1);
           boolean param_2 = obj.insert(2);
           boolean param_3 = obj.insert(2);
           boolean param_4 = obj.remove(2);
           int param_5 = obj.getRandom();
    }
    private Set<Integer> set;
    public RandomizedSet() {
        set = new HashSet<>();
    }

    public boolean insert(int val) {
        return set.add(val);
    }

    public boolean remove(int val) {
        return set.remove(val);
    }

    public int getRandom() {
        int random = new Random().nextInt(set.size());
        Object[] array = set.stream().toArray();
        return (int) array[random];
    }
}