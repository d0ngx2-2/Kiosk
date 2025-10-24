package lv5;

import java.util.ArrayList;
import java.util.List;

//카테고리와 메뉴 리스트를 관리하기 위한 Menu class 생성
public class Menu {
    //속성
    //카테고리와, 메뉴아이템 객체를 가진 메뉴리스트를 선언
    String categoryName;
    List<MenuItem> menuItems;

    //생성자
    //각 필드들을 초기화
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    //기능
    //카테고리 이름 뽑아오는 기능
    public String getCategoryName() {
        return categoryName;
    }

    //MenuItem 속성들을 입력후 객체를 생성하면 menuItems 리스트에 추가하게 되는 기능
    void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }
    //그 리스트를 뽑아오는 기능
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    //그 카테고리에 있는 리스트만큼 출력시키는 print 기능
    public void plintItems() {
        for (int i = 0; i<menuItems.size(); i++) {
            System.out.print((i+1) + " . ");
            menuItems.get(i).Pint();
        }
    }
}
