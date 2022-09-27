package com.exemplo.foods.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.exemplo.foods.OnListClick;
import com.exemplo.foods.R;
import com.exemplo.foods.adapter.FoodAdapter;
import com.exemplo.foods.business.FoodBusiness;
import com.exemplo.foods.entity.FoodEntity;
import com.exemplo.foods.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<FoodEntity> list = new FoodBusiness().getList();

        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_foods);

        OnListClick clickFood = new OnListClick() {
            @Override
            public void onclick(int id) {
               Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
               startActivity(intent);
            }
        };

        FoodAdapter adapter = new FoodAdapter(list, clickFood);
        this.mViewHolder.mRecyclerFood.setAdapter(adapter);

        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this));
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}