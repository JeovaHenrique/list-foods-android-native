package com.exemplo.foods.services.repository;

import com.exemplo.foods.entities.FoodEntity;

import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    private List<FoodEntity> mListFood;

    public FoodRepository() {
        this.mListFood = new ArrayList<>();

        this.mListFood.add(new FoodEntity(0, "Curly lettuce", 8, 60, "g", "This food contains vitamin A, C and K."));
        this.mListFood.add(new FoodEntity(1, "Olive oil", 90, 10, "g", ""));
        this.mListFood.add(new FoodEntity(2, "Sweet potato", 115, 100, "g", "This food is rich in vitamin A."));
        this.mListFood.add(new FoodEntity(3, "Raw peas", 81, 70, "g", ""));
        this.mListFood.add(new FoodEntity(4, "Beans", 77, 75, "g", "Este alimento é rico em ferro."));
        this.mListFood.add(new FoodEntity(5, "Fried chicken fillet", 240, 100, "g", "Protein-rich food."));
        this.mListFood.add(new FoodEntity(6, "Chickpeas", 720, 200, "g", ""));
        this.mListFood.add(new FoodEntity(7, "Cooked noodles", 221, 140, "g", ""));
        this.mListFood.add(new FoodEntity(8, "12 grain loaf of bread", 110, 50, "g", "This food is low in saturated fat."));
        this.mListFood.add(new FoodEntity(9, "Parmesan cheese", 18, 71, "g", ""));
        this.mListFood.add(new FoodEntity(10, "Arugula", 5, 20, "g", "This food contains calcium and iron."));
        this.mListFood.add(new FoodEntity(11, "Cooked green beans", 44, 125, "g", ""));
        this.mListFood.add(new FoodEntity(12, "Vodka", 231, 100, "ml", "0g fat, 0g protein. Carbohydrate only."));
        this.mListFood.add(new FoodEntity(13, "Whiskey", 58, 23, "ml", ""));
    }

    public FoodEntity get(int id) {
        return this.mListFood.get(id);
    }

    public List<FoodEntity> getList() {
        return this.mListFood;
    }

}
