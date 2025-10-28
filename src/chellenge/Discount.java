package chellenge;

import java.util.function.Function;

public enum Discount {
    SOLDIER(price -> price * 0.4),
    COUPON1(price -> price * 0.5),
    COUPON2(price -> price * 0.6),
    COUPON3(price -> price * 0.7);

    //속성
    private final Function<Integer, Double> priceFunction;

    //생성자
    Discount(Function<Integer, Double> priceFunction) {
        this.priceFunction = priceFunction;
    }
    //기능
    public double apply(Integer price) {
        return priceFunction.apply(price);
    }
}
