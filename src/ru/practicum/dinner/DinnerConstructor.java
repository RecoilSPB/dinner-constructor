package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> menuDishes;

    DinnerConstructor(){
        menuDishes = new HashMap<>();
    }

    public boolean checkType(String type){
        return menuDishes.containsKey(type);
    }

    public ArrayList<String> getDishByType(String dishType) {
        if (checkType(dishType)){
            return menuDishes.get(dishType);
        }
        return new ArrayList<>();
    }
}
