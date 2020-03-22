package ru.smith.ch04.xml.profiles.highschool;

import ru.smith.ch04.xml.profiles.Food;
import ru.smith.ch04.xml.profiles.FoodProviderService;

import java.util.ArrayList;
import java.util.List;

public class FoodProviderServiceImpl implements FoodProviderService {
    @Override
    public List<Food> providerLunchSet() {
        List<Food> launchSet = new ArrayList<>();
        launchSet.add(new Food("Яйцо"));
        launchSet.add(new Food("Бутерброд"));
        launchSet.add(new Food("Салат"));
        return launchSet;
    }
}
