package lv3;

import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItemList;

    //생성자
    public Kiosk(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    // 기능
    void start() {
        Scanner sc = new Scanner(System.in);

        // 접속 문구 및 종료 선택 화면
        System.out.println("만다린에 오신 것을 환영합니다. 메뉴를 선택하시겠습니까?[나가기]");
        String choice = sc.next();

        if ("나가기".equals(choice)) {
            System.out.println("종료하겠습니다.");
            System.exit(0);
        } else {
            System.out.println("메뉴를 불러오겠습니다.");
        }
        // 메뉴 불러오기
        while (true) {
            System.out.println("[ 만다린 메뉴 ]");
            for (int i = 0; i < menuItemList.size(); i++) {
                MenuItem menuItem = menuItemList.get(i);
                System.out.println((i + 1) + ". " + menuItem.getName() + "\t|W " + menuItem.getPrice() + " \t| " + menuItem.getDescription());
            }
            System.out.println(0 + " 종료하기");
            System.out.println("원하시는 메뉴를 선택하여주세요.");
            int choiceNum = sc.nextInt();
            if (choiceNum == 1) {
                System.out.println("장바구니에 담겼습니다.");
            } else if (choiceNum == 2) {
                System.out.println("장바구니에 담겼습니다.");
            } else if (choiceNum == 3) {
                System.out.println("장바구니에 담겼습니다.");
            } else if (choiceNum == 4) {
                System.out.println("장바구니에 담겼습니다.");
            } else if (choiceNum == 0) {
                System.out.println("종료하겠습니다.");
                System.exit(0);
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
