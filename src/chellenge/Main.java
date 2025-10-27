package chellenge;

import java.util.ArrayList;
import java.util.List;

public class Main {
//실행과 카테고리 메뉴 및 내 음식 메뉴들의 객체를 새로 생성하는 Main class안의 main 함수

    public static void main(String[] args) {
        Menu chinaFood = new Menu("중식");
        //Menu class를 활용하여 카테고리 이름 객체를 생성한다.
        //*생성자 존재 이유와 Menu를 참조하게 됨으로 Menu의 메서드를 사용할 수 있게됨

        chinaFood.addMenuItem(new MenuItem("짜장면", 6900, "맛있는 짜장면"));
        //Menu class에 있는 메서드를 활용하여 음식 메뉴들과 세부내용을 새로운 객체로 생성 및 배열에 추가한다.
        //[변수명]은 Menu를 참조하고 있어 .add를 바로 호출하여 새로운 MenuItem의 객체를 생성하되 ()안에는 MenuItem의 생성자 형식에 맞게 넣어추가한다.

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
        //Menu의 속성을 가진 List를 새로운 배열로 생성

        menus.add(chinaFood);
        menus.add(drink);
        menus.add(desert);
        //각 카테고리에 묶인 메뉴리스트를 배열에 추가.
        //위 메뉴리스트를 Kiosk class에 전달

        Kiosk kiosk = new Kiosk(menus);
        //리스트를 전달받은 Kiosk객체를 생성
        kiosk.start();
        //실행 함수 start
    }
}
