package lv4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    //속성
    String categoryName;
    List<MenuItem> menuItems;

    //생성자
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    //기능
    public String getCategoryName() {
        return categoryName;
    }

    void addMenuItem(MenuItem menuItem) {
        menuItems.add(menuItem);
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void plintItems() {
        for (int i = 0; i<menuItems.size(); i++) {
            System.out.println((i+1) + " . " +  menuItems.get(i).getName() + "\t| W" + menuItems.get(i).getPrice() + "\t| " +  menuItems.get(i).getDescription());
        }
    }
}
