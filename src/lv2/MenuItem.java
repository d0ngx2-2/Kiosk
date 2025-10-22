package lv2;

public class MenuItem {

    //속성
    //세부 메뉴에 들어갈 내용
   String name;
   int price;
   String description;

   //생성자
    MenuItem(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    //기능
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getDescription() {
        return description;
    }

}
