package lv4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<MenuItem> menuItemList = new ArrayList<>();

        menuItemList.add(new MenuItem("짜장면", 6900, "맛있는 짜장면"));
        menuItemList.add(new MenuItem("간짜장", 7500, "맛있는 간짜장"));
        menuItemList.add(new MenuItem("간짬뽕", 9500, "맛있는 간짬뽕"));
        menuItemList.add(new MenuItem("삼선짬뽕", 12500, "맛있는 삼선짬뽕"));

        Kiosk kiosk = new Kiosk(menuItemList);

        kiosk.start();
    }
}
