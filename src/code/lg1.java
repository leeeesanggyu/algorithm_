package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lg1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] ings = new String[]{"r 10", "a 23", "t 124", "k 9"};
        String[] menu = new String[]{"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SANDWICH rar 45", "JUICE rra 55", "WATER a 20"};
        String[] sell = new String[]{"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};

        System.out.println(solution(ings, menu, sell));
    }

    private static Integer solution(String[] ings, String[] menu, String[] sell) {
        List<Ings> ingsList = getIngsList(ings);
        List<Menu> menuList = getMenuList(menu, ingsList);
        System.out.println("a = " + menuList);
        List<Sell> sellList = getSellList(sell);

        return getRevenue(menuList, sellList);
    }
    private static int getRevenue(List<Menu> menuList, List<Sell> sellList) {
        int revenue = 0;
        for (Sell s : sellList) {
            for (Menu m : menuList) {
                if (s.getMenuName().equals(m.name)) {
                    revenue += ((m.getSellPrice() - m.getTotalIngredient()) * s.getSellCount());
                }
            }
        }
        return revenue;
    }

    private static List<Sell> getSellList(String[] sell) {
        List<Sell> sellList = new ArrayList<>();

        Arrays.stream(sell).forEach(s -> {
            String[] splitS = s.split(" ");
            sellList.add(new Sell(splitS[0], Integer.parseInt(splitS[1])));
        });
        return sellList;
    }

    private static List<Menu> getMenuList(String[] menu, List<Ings> ingsList) {
        List<Menu> menuList = new ArrayList<>();
        Arrays.stream(menu).forEach(m -> {
            String[] splitM = m.split(" ");

            String[] ingredients = splitM[1].split("");

            int sumIngredient = 0;
            for (String ingredient: ingredients) {
                for (Ings ingsEl: ingsList) {
                    if (ingredient.equals(ingsEl.getIngredient())) {
                        sumIngredient += ingsEl.getPrice();
                    }
                }
            }
            menuList.add(new Menu(splitM[0], sumIngredient, Integer.parseInt(splitM[2])));
        });
        return menuList;
    }

    private static List<Ings> getIngsList(String[] ings) {
        List<Ings> ingsList = new ArrayList<>();
        Arrays.stream(ings).forEach(i -> {
            String[] splitI = i.split(" ");
            ingsList.add(new Ings(splitI[0], Integer.parseInt(splitI[1])));
        });
        return ingsList;
    }

    public static class Ings {
        private String ingredient;
        private Integer price;

        public String getIngredient() {
            return ingredient;
        }

        public Integer getPrice() {
            return price;
        }

        public Ings(String ingredient, Integer price) {
            this.ingredient = ingredient;
            this.price = price;
        }
    }

    public static class Menu {
        private String name;
        private Integer totalIngredient;
        private Integer sellPrice;

        @Override
        public String toString() {
            return "Menu{" +
                    "name='" + name + '\'' +
                    ", totalIngredient=" + totalIngredient +
                    ", sellPrice=" + sellPrice +
                    '}';
        }

        public Menu(String name, Integer totalIngredient, Integer sellPrice) {
            this.name = name;
            this.totalIngredient = totalIngredient;
            this.sellPrice = sellPrice;
        }

        public String getName() {
            return name;
        }

        public Integer getTotalIngredient() {
            return totalIngredient;
        }

        public Integer getSellPrice() {
            return sellPrice;
        }
    }

    public static class Sell {
        private String menuName;
        private Integer sellCount;

        public Sell(String menuName, Integer sellCount) {
            this.menuName = menuName;
            this.sellCount = sellCount;
        }

        public String getMenuName() {
            return menuName;
        }

        public Integer getSellCount() {
            return sellCount;
        }
    }
}

