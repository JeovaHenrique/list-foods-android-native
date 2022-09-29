package com.exemplo.foods.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.exemplo.foods.services.listener.OnListClick;
import com.exemplo.foods.R;
import com.exemplo.foods.ui.adapter.FoodAdapter;
import com.exemplo.foods.services.business.FoodBusiness;
import com.exemplo.foods.services.constants.FoodConstants;
import com.exemplo.foods.entities.FoodEntity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private FoodBusiness mFoodBusiness = new FoodBusiness();
    private OnListClick clickFood;
    private int mFilter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.clickFood = id -> {

            Bundle bundle = new Bundle();
            bundle.putInt(FoodConstants.FOOD_ID, id);
           Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
           intent.putExtras(bundle);
           startActivity(intent);
        };

        this.mViewHolder.mRecyclerFood = findViewById(R.id.recycler_foods);
        this.mViewHolder.mRecyclerFood.setLayoutManager(new LinearLayoutManager(this));

        this.listFood();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.filter_low: {
                mFilter = FoodConstants.FILTER.CAL_LOW;
                break;
            }

            case R.id.filter_medium: {
                mFilter = FoodConstants.FILTER.CAL_MEDIUM;
                break;
            }
            default: {
                mFilter = FoodConstants.FILTER.CAL_HIGH;
                break;
            }
        }
        this. listFood();
        return super.onOptionsItemSelected(item);
    }

    private void listFood() {
        List<FoodEntity> list = this.mFoodBusiness.getList(this.mFilter);
        this.mViewHolder.mRecyclerFood.setAdapter(new FoodAdapter(list, clickFood));
    }

    private static class ViewHolder {
        RecyclerView mRecyclerFood;
    }
}