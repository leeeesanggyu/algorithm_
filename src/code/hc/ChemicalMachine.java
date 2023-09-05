package code.hc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChemicalMachine {

    private static final ArrayList<String> potions = new ArrayList<>();
    private static final ArrayList<String> validPotions = new ArrayList<>(List.of("GREEN, YELLOW"));

    public boolean hasInvalidPotions() {
        for (String potion : potions) {
            if (!isValidPotion(potion)) {
                return false; // 다른 문자열이 있는 경우 false 반환
            }
        }
        return true; // 다른 문자열이 없는 경우 true 반환
    }

    public boolean isValidPotion(String potion) {
        // validPotions 리스트에 포함된 문자열인 경우 유효한 potion 간주
        return validPotions.contains(potion);
    }


    public void add(String potion) {
        potions.add(potion);
    }

    public void applyHeat() {
        hasInvalidPotions();
        int yellowCount = Collections.frequency(potions, "YELLOW");
        int greenCount = Collections.frequency(potions, "GREEN");

        if (greenCount == 2) {
            potions.clear();
            potions.add("RED");
            potions.add("RED");
        } else if (yellowCount == 1 && greenCount == 1) {
            potions.clear();
            potions.add("BROWN");
        } else {
            potions.clear();
            potions.add("UNKNOWN");
        }
    }

    public ArrayList<String> emptyMachine() {
        ArrayList<String> potionsCopy = new ArrayList<>(potions);
        potions.clear();
        return potionsCopy;
    }

    public static void main(String[] args) {
        ChemicalMachine machine = new ChemicalMachine();

        machine.add("GREEN");
        machine.add("YELLOW");
        machine.applyHeat();
        System.out.println(String.join(",", machine.emptyMachine())); // should print BROWN

        machine.add("RED");
        machine.add("YELLOW");
        machine.applyHeat();
        System.out.println(String.join(",", machine.emptyMachine())); // should print UNKNOWN
    }
}

