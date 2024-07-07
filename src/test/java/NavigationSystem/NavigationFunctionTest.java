package NavigationSystem;

import SmartBusSystem.service.NavigationSystem.NavigationSystem;

import java.util.List;

public class NavigationFunctionTest {
    public static void main(String[] args) {
        List<String> navigationGuide = NavigationSystem.getNavigationGuide("新客运站", "雅斯超市");
        navigationGuide.forEach(System.out::println);
    }
}
