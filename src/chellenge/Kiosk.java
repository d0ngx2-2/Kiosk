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
    Basket basket = new Basket();

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
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }

            //Order Menu 생성 [장바구니가 비어져있다면 종료하기 버튼만 나오도록 조건문 작성]
            if (!basket.getBasketList().isEmpty()) {
                System.out.println("""
                        [ Order Menu ]
                        4. Order\t| 장바구니 확인 후 결제합니다.
                        5. Canccel\t| 진행중인 주문을 취소합니다.
                        0 종료하기""");
            } else {
                System.out.println(0 + " 종료하기");
            }
            //카테고리를 고를 때 쓸 변수
            int categoriIndex = tCatch(sc,"[ 카테고리 ]를 선택해주세요.");

            //종료 기능 및 예외 처리
            if (categoriIndex == 0) {
                System.out.println("종료하겠습니다.");
                break;
            }
            //0보다 작거나 카테고리 수보다 큰 숫자를 입력시 오류 문구 출력
            else if (categoriIndex < 0 || categoriIndex - 1 >= menus.size() + 2) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                continue;
            }
            //장바구니 리스트 출력 및 결제
            else if (categoriIndex == 4) {
                //장바구니에 실린 MenuItem List값들을 출력
                if (!basket.getBasketList().isEmpty()) {
                    basket.basketPrint();
                    System.out.println("총 계산은 " + basket.allPrice() + "원 입니다. 결제하시겠습니까?");
                } else {
                    System.out.println("잘못된 숫자 입력입니다.");
                    continue;
                }

                //장바구니 결제
                int payChoice = tCatch(sc,"1. [예]\n2. [아니오]");
                if (payChoice == 1) {
                    System.out.println("결제가 완료되었습니다. 감사합니다.");
                    basket.removeAll();
                    continue;
                } else if (payChoice == 2) {
                    continue;
                }

                //장바구니 비우기
            } else if (categoriIndex == 5) {
                if (!basket.getBasketList().isEmpty()) {
                    System.out.println("장바구니를 비우시겠습니까?");
                    int clearChoice = tCatch(sc,"1. [비운다] \n2. [취소]");
                    if (clearChoice == 1) {
                        basket.removeAll();
                        System.out.println("[ 비우기 완료 ]");
                        continue;
                    } else if (clearChoice == 2) {
                        continue;
                    }
                }
            }

            //해당 카테고리에 있는 메뉴리스트를 다음 함수에 선언
            Menu choiceMenu = menus.get(categoriIndex - 1);

            //카테고리 내 메뉴리스트 제목 출력 = 카테고리 이름
            System.out.println("[ " + choiceMenu.getCategoryName() + " 메뉴 ]");

            //입력한 숫자값 순서의 메뉴 리스트들을 출력
            choiceMenu.printItems();

            System.out.println("0. 뒤로가기");
            int itemIndex = tCatch(sc,"선택할 음식의 번호를 선택하여 주세요.");
            if (itemIndex == 0) {
                continue;
            }// 뒤로가기 기능
            if (itemIndex < 0 || itemIndex - 1 >= choiceMenu.getMenuItems().size()) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                continue;
            } //0보다 작거나 카테고리 수보다 큰 숫자를 입력시 오류 문구 출력

            //선택한 카테고리의 메뉴리스트를 출력
            MenuItem itemSelect = choiceMenu.getMenuItems().get(itemIndex - 1);
            System.out.print("선택한 메뉴 : ");
            itemSelect.Print();//카테고리의 아이템 리스트를 출력한다.

            //장바구니에 담기
            System.out.println("선택한 메뉴를 장바구니에 담으시겠습니까?");
            int basketChoice = tCatch(sc,"1. [담는다]\n2. [취소]");
            if (basketChoice == 1) {
                int multichoice = tCatch(sc,"담을 수량을 입력해주세요.");

                basket.addBasket(itemSelect, multichoice);
                System.out.println("[ " + itemSelect.getName() + " " + multichoice + " 개 ] 을 장바구니에 담았습니다.");
            } else if (basketChoice == 2) {
                continue;
            } else {
                System.out.println("잘못된 숫자 입력입니다.");
            }
        }
        sc.close();
    }

    //예외 처리 메서드
    int tCatch(Scanner sc, String message) {
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