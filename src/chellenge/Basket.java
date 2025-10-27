package chellenge;

import java.util.ArrayList;
import java.util.List;

//장바구니 기능을 위한 Basket class 생성
public class Basket {
    //속성
    //장바구니에 담을 새 배열을 생성
    private final List<MenuItem> basketList = new ArrayList<>();
    //생성자

    //기능
    //장바구니에 아이템을 담는기능
    void addBasket(MenuItem item) {
        basketList.add(item);
    }

    //장바구니 아이템들을 전부 없애는 기능 Cancel
    void removeAll() {
        basketList.clear();
    }

    //장바구니 내 목록들을 보여주는 기능 Order
    void basketPrint() {
        System.out.println("[ Basket 목록 ]");
        for (int i = 0; i < basketList.size(); i++) {
            System.out.print((i + 1) + " . ");
            basketList.get(i).Print();
        }
    }

    //장바구니를 반환하는 메서드
    List<MenuItem> getBasketList() {
        return basketList;
    }

    //장바구니 내용의 총 합계를 보여주는 기능
    int allPrice() {
        int sum = 0;
        for (int i = 0; i < basketList.size(); i++) {
            sum += basketList.get(i).getPrice();
        }
        return sum;
    }


}
