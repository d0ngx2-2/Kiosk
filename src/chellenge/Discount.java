package chellenge;

import java.util.function.Function;
//할인을 적용시킬 enum class 생성
public enum Discount {
    SOLDIER(price -> price * 0.6),
    COUPON1(price -> price * 0.7),
    COUPON2(price -> price * 0.8);

    //속성
    private final Function<Integer, Double> priceFunction;

    //생성자
    Discount(Function<Integer, Double> priceFunction) {
        this.priceFunction = priceFunction;
    }
    //기능
    //값을 할인시켜 계산한 값을 반환시키는 계산 메서드
    public double apply(Integer price) {
        return this.priceFunction.apply(price);
    }
}