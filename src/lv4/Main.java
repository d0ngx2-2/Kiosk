package lv4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Menu chinaFood = new Menu("중식");
        chinaFood.addMenuItem(new MenuItem("짜장면", 6900, "맛있는 짜장면"));
        chinaFood.addMenuItem(new MenuItem("간짜장", 7500, "맛있는 간짜장"));
        chinaFood.addMenuItem(new MenuItem("간짬뽕", 9500, "맛있는 간짬뽕"));
        chinaFood.addMenuItem(new MenuItem("삼선짬뽕", 12500, "맛있는 삼선짬뽕"));

        Menu drink = new Menu("음료수");
        drink.addMenuItem(new MenuItem("코카콜라", 1500, "(뚱캔)시원한 코카콜라"));
        drink.addMenuItem(new MenuItem("칠성사이다", 1500, "(뚱캔)시원한 사이다"));
        drink.addMenuItem(new MenuItem("환타", 1500, "(뚱캔)오렌지 맛 환타"));
        drink.addMenuItem(new MenuItem("환타", 1500, "(뚱캔)파인애플 맛 환타"));
        drink.addMenuItem(new MenuItem("환타", 1500, "(뚱캔)포도맛 환타"));

        Menu desert = new Menu("후식");
        desert.addMenuItem(new MenuItem("식혜", "시원하고 맛난 식혜"));
        desert.addMenuItem(new MenuItem("아이스크림", "다 드시고 셀프로 퍼가세요"));

        List<Menu> menus = new ArrayList<>();
        menus.add(chinaFood);
        menus.add(drink);
        menus.add(desert);

        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
