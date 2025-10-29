package chellenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//카테고리와 메뉴 리스트를 관리하기 위한 Menu class 생성
public class Menu {
    //속성
    //카테고리와, 메뉴아이템 객체를 가진 메뉴리스트를 선언
    private final String categoryName;
    private final List<MenuItem> menuItems;

    //생성자
    //각 필드들을 초기화
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    //기능
    //카테고리 이름 뽑아오는 기능
    public String getCategoryName() {
        return this.categoryName;
    }

    //MenuItem 속성들을 입력후 객체를 생성하면 menuItems 리스트에 추가하게 되는 기능
    void addMenuItem(MenuItem menuItem) {
        this.menuItems.add(menuItem);
    }

    //그 리스트를 뽑아오는 기능
    public List<MenuItem> getMenuItems() {
        return this.menuItems;
    }

    //그 카테고리에 있는 리스트만큼 출력시키는 print 기능 (스트림 활용 버전)
    public void printItems() {
        IntStream.range(0, this.menuItems.size()).forEach(i -> {
            System.out.print((i + 1) + ". ");
            this.menuItems.get(i).Print();
        });

    }
}
        //카테고리 리스트 출력( 기존 버전 )
//        void printItems () {
//            for (int i = 0; i < menuItems.size(); i++) {
//                System.out.print((i + 1) + " . ");
//                menuItems.get(i).Print();
//            }
//        }
