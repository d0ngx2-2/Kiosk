package lv4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    //속성
    //Menu의 데이터를 다루는 List 형태의 menus를 선언
    List<Menu> menus;

    //생성자
    Kiosk(List<Menu> menus) {
        this.menus = menus;  //속성값을 초기화
    }

    // 기능
    //main에서 실행 동작을 시켜주는 메서드 start 선언
    void start() {

        Scanner sc = new Scanner(System.in);
        while (true) {
            // 카테고리 메뉴 불러오기
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println(0 + " 뒤로가기");
            System.out.println("카테고리 번호를 선택하여 주세요.");
            int categoriIndex = sc.nextInt();
            if (categoriIndex == 0) {
                continue;
            }
            if(categoriIndex < 0 || categoriIndex-1 >= menus.size()) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                break;
            }

            Menu choiceMenu = menus.get(categoriIndex-1);
            choiceMenu.plintItems();

            System.out.println("선택할 음식의 번호를 선택하여 주세요.");
            System.out.println(0 + "종료하기");
            int itemIndex = sc.nextInt();
            if (itemIndex == 0) {
                break;
            }
            if(itemIndex < 0 || itemIndex-1 >= choiceMenu.getMenuItems().size()) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                continue;
            }

            MenuItem itemSelect = choiceMenu.getMenuItems().get(itemIndex-1);
            System.out.println("선택한 메뉴 : " + itemSelect.getName() + "\t| W " + itemSelect.getPrice() + "\t| " + itemSelect.getDescription());
        }
    }
}