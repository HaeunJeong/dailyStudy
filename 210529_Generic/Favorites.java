import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Favorites{
    private Map<Class<?>, Object> favorites = new HashMap<>(); // <---- Map의 키가 와일드카드 타입으로, 모든 키가 서로 다른 매개변수화 타입일 수 있음.
    public <T> void putFavorite(Class<T> type, T instance){ //<--- Class<T> type : class 리터럴의 타입.
        favorites.put(Objects.requireNonNull(type), instance);
    }
    public <T> T getFavorite(Class<T> type){
        return type.cast(favorites.get(type));
    }
}

class Main{
    public static void main(String []arg){
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Class.class, Favorites.class);

        System.out.println(f.getFavorite(String.class));
    }
}