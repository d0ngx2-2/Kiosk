package lv4;

import java.util.List;
import java.util.Scanner;

//Main 함수에서 실행만을 위한 기능을 가진 Kiosk class 생성
public class Kiosk {
    //속성
    //Menu의 데이터를 다루는 List 형태의 menus를 선언(카테고리 + 음식메뉴 세부내용)
    List<Menu> menus;

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
            // 카테고리 메뉴 불러오기
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }//출력 (i+1):번호 수 i=0부터 시작, menus리스트를. i번째를 가져온다. 카테고리 이름을
            System.out.println(0 + " 종료하기");
            System.out.println("카테고리 번호를 선택하여 주세요.");
            int categoriIndex = sc.nextInt();
            //카테고리를 고를 때 쓸 변수

            if (categoriIndex == 0) {
                System.out.println("종료하겠습니다.");
                break;
            }//종료 기능

            if(categoriIndex < 0 || categoriIndex-1 >= menus.size()) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                continue;
            } //0보다 작거나 카테고리 수보다 큰 숫자를 입력시 오류 문구 출력

            Menu choiceMenu = menus.get(categoriIndex-1);
            //입력한 숫자값 번째에 있는 리스트를 다음 변수에 넣는다.
            //메뉴리스트를. 가져온다(입력한 숫자-1번째에 있는)

            choiceMenu.plintItems();
            //입력한 숫자값 순서의 메뉴 리스트들을 출력
            //앞서 있던 코드에 결과가 Menu 타입의 객체이기 때문에 Menu가 가진 메서드를 사용할 수 있게된다.

            System.out.println("선택할 음식의 번호를 선택하여 주세요.");
            System.out.println(0 + "뒤로가기");
            int itemIndex = sc.nextInt();
            if (itemIndex == 0) {
                continue;
            }// 뒤로가기 기능
            if(itemIndex < 0 || itemIndex-1 >= choiceMenu.getMenuItems().size()) {
                System.out.println("잘못된 숫자입니다. 다시 입력해주세요.");
                continue;
            } //0보다 작거나 카테고리 수보다 큰 숫자를 입력시 오류 문구 출력

            //선택한 카테고리의 메뉴리스트를 출력
            MenuItem itemSelect = choiceMenu.getMenuItems().get(itemIndex-1);
            //선택한 카테고리리스트중에서 itmIndex-1번째에 있는 메뉴리스트를 가져온다. 이를 itemSelect에 저장한다.
            System.out.print("선택한 메뉴 : " );
            itemSelect.Pint();//그 카테고리의 아이템 리스트를 출력한다.
        }
    }
}