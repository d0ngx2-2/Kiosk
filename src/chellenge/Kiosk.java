package chellenge;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//Main 함수에서 실행만을 위한 기능을 가진 Kiosk class 생성

public class Kiosk {
    //속성
    //Menu의 데이터를 다루는 List 형태의 menus를 선언(카테고리 + 음식메뉴 세부내용)
    private final List<Menu> menus;
    //장바구니 기능을 구현하기 위한 Basket class 선언
    private Basket basket = new Basket();

    //생성자
    Kiosk(List<Menu> menus) {
        this.menus = menus;  //속성값을 초기화
    }

    // 기능
    //main에서 실행 동작을 시켜주는 메서드 start 선언
    void start() {
        Scanner sc = new Scanner(System.in);
        //입력을 위한 스캐너 객체 생성

        //반복문
        while (true) {
            //메뉴 타이틀 출력
            System.out.println("[ 만 리 장 성 메 뉴 ]");

            // 카테고리 메뉴 불러오기
            for (int i = 0; i < this.menus.size(); i++) {
                System.out.println((i + 1) + ". " + this.menus.get(i).getCategoryName());
            }

            //Order Menu 생성 [장바구니가 비어져있다면 종료하기 버튼만 나오도록 조건문 작성]
            if (!this.basket.getBasketList().isEmpty()) {
                System.out.println("""
                        \n[ Order Menu ]
                        4. Order\t| 장바구니 확인 후 결제합니다.
                        5. Canccel\t| 진행중인 주문을 취소합니다.
                        0 종료하기\n""");
            } else {
                System.out.println(0 + " 종료하기\n");
            }

            //카테고리를 고를 때 쓸 변수
            int categoryIndex = inputHelper(sc, "[ 카테고리 ]를 선택해주세요.");

            //장바구니 리스트 출력, 주문, 예외처리
            if (categoryIndex == 0) {
                System.out.println("종료하겠습니다.\n");
                break;
            } else if (categoryIndex < 0 || categoryIndex - 1 >= this.menus.size() + 2) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.\n");
                continue;
            } else if ((categoryIndex == 4 || categoryIndex == 5) && this.basket.getBasketList().isEmpty()) {
                System.out.println("잘못된 숫자 입력입니다.\n");
                continue;
            } else if (categoryIndex == 4) {
                //장바구니에 실린 MenuItem List값들을 출력
                this.basket.basketPrint();

                //장바구니 주문 후 클리어
                int payChoice = inputHelper(sc, "\n총 계산금액은 " + this.basket.allPrice() + "원 입니다. 주문하시겠습니까? \n\n1. [주문]\n2. [할인]\n3. [메뉴 삭제]\n4. [뒤로 가기]");
                if (payChoice == 1) {
                    System.out.println("주문이 완료되었습니다. 감사합니다.\n");
                    this.basket.removeAll();
                    continue;
                }

                //할인 메뉴 및 적용시키기 및 예외처리
                if (payChoice == 2) {
                    System.out.println("적용할 할인을 선택하여 주세요.\n");
                    int discountChoice = inputHelper(sc, "1. [군인 할인]\t| 40%\n2. [쿠폰 할인]\t| 30%\n3. [쿠폰 할인]\t| 20%");
                    if (discountChoice == 1) {
                        System.out.println("할인 적용 금액 : " + (int) Discount.SOLDIER.apply(this.basket.allPrice()) + "원\n[주문 완료]\n");
                        this.basket.removeAll();
                        continue;
                    } else if (discountChoice == 2) {
                        System.out.println("할인 적용 금액 : " + (int) Discount.COUPON1.apply(this.basket.allPrice()) + "원\n[주문 완료]\n");
                        this.basket.removeAll();
                        continue;
                    } else if (discountChoice == 3) {
                        System.out.println("할인 적용 금액 : " + (int) Discount.COUPON2.apply(this.basket.allPrice()) + "원\n[주문 완료]\n");
                        this.basket.removeAll();
                        continue;
                    } else {
                        System.out.println("잘못된 숫자 입력 입니다.");
                    }

                //장바구니 리스트 중 선택 후 제거하기 및 예외처리
                } else if (payChoice == 3) {
                    int deleteChoice = inputHelper(sc, "삭제할 메뉴를 입력해주세요");
                    this.basket.removeBasket(deleteChoice);
                    continue;
                } else if (payChoice == 4) {
                    continue;
                } else {
                    System.out.println("잘못된 숫자 입력입니다.");
                    continue;
                }

                //장바구니 비우기
            } else if (categoryIndex == 5) {
                System.out.println("장바구니 비우기 완료\n");
                this.basket.removeAll();
                continue;
            }

            //해당 카테고리에 있는 메뉴리스트를 다음 함수에 선언
            Menu choiceMenu = this.menus.get(categoryIndex - 1);

            //카테고리 내 메뉴리스트 제목 출력 = 카테고리 이름
            System.out.println("[ " + choiceMenu.getCategoryName() + " 메뉴 ]");

            //입력한 숫자값 순서의 메뉴 리스트들을 출력
            choiceMenu.printItems();

            System.out.println("0. 뒤로가기\n");
            int itemIndex = inputHelper(sc, "선택할 음식의 번호를 선택하여 주세요.");
            if (itemIndex == 0) {
                continue;
            } else if (itemIndex < 0 || itemIndex - 1 >= choiceMenu.getMenuItems().size()) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.\n");
                continue;
            } //예외처리

            //선택한 카테고리의 메뉴리스트를 출력
            MenuItem itemSelect = choiceMenu.getMenuItems().get(itemIndex - 1);
            System.out.print("선택한 메뉴 : ");
            itemSelect.Print();

            //장바구니에 수량 선택 후 담기
            System.out.println("선택한 메뉴를 장바구니에 담으시겠습니까?\n");
            int basketChoice = inputHelper(sc, "1. [담는다]\n2. [취소]");
            if (basketChoice == 1) {
                int multichoice = inputHelper(sc, "담을 수량을 입력해주세요.");
                this.basket.addBasket(itemSelect, multichoice); //(아이템리스트,수량) 각 배열에 추가
                System.out.println("[ " + itemSelect.getName() + " " + multichoice + " 개 ] 을 장바구니에 담았습니다.\n");
            } else if (basketChoice == 2) {
                continue;
            } else {
                System.out.println("잘못된 숫자 입력입니다.\n");
            }
        }
        sc.close();
    }

    //예외 처리 메서드
    int inputHelper(Scanner sc, String message) {
        while (true) {
            try {
                System.out.println(message);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}