package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" + " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit " + "esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est " + "laborum.";

    public static void main(String[] args) {
        Map<Character, Integer> myMap = new HashMap<>();
        Character symbol;
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        Character minValue = null;
        Character maxValue = null;
        for (int i = 0; i < text.length(); i++) {
            symbol = text.charAt(i);
            if (!Character.isLetter(symbol)) {
                continue;
            }
            if (myMap.containsKey(symbol)) {
                myMap.replace(symbol, myMap.get(symbol) + 1);
            } else {
                myMap.put(symbol, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : myMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                maxValue = key;
            }
            if (value < min) {
                min = value;
                minValue = key;
            }
        }
        System.out.println(String.format("Самый частый символ: '%c', был %d раз", maxValue, max));
        System.out.println(String.format("Самый редкий символ: '%c', был %d раз", minValue, min));
    }
}