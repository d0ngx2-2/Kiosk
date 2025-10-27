package chellenge;

public class MenuItem {

    //속성
    //음식에 대한 세부 내용
    private final String name;
    private  int price;
    private final String description;

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
    //음식의 속성들을 출력해주는 메서드
    void Print() {
        System.out.println(this.name + "\t|W " + this.price + "\t| " + this.description);
    }
    
    //음식 이름을 반환하는 메서드
    String getName() {
        return this.name;
    }
    
    //음식 가격을 반환하는 메서드
    int getPrice() {
        return this.price;
    }
}
