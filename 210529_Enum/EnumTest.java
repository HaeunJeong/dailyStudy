import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum EnumTest {
    PLUS("+"){public double apply(double x, double y){return x+y;}},
    MINUS("-"){public double apply(double x, double y){return x-y;}},

    private String symbol;


    EnumTest(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }
    private static final Map<String, EnumTest> stringToEnum = Stream.of(values()).collect(Collectors.toMap(Object::toString, e->e)); //Object::toString은 자기자신 symbol

    public static Optional<EnumTest> fromString(String symbol){
        return Optional.ofNullable(stringToEnum.get(symbol));
    }
}
