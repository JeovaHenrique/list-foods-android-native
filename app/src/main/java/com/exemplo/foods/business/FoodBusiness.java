package com.exemplo.foods.business;

import com.exemplo.foods.entity.FoodEntity;
import com.exemplo.foods.repository.FoodRepository;

import java.util.List;

public class FoodBusiness {

    public FoodEntity get(int id) {
        return new FoodRepository().get(id);
    }

    public List<FoodEntity> getList() {
        return new FoodRepository().getList();
    }
}
