package lv5;

public class MenuItem {

    //속성
    //음식에 대한 세부 내용
    String name;
    int price;
    String description;

    //생성자
    //생성자를 통해 값을 초기화
    MenuItem(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    //무료인 메뉴도 있어 생성자를 두개로 생성
    MenuItem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //기능
    //음식의 속성들을 프린트해주는 기능
    public void Pint() {
        System.out.println(this.name + "\t|W " + this.price + "\t| " + this.description);
    }
}

