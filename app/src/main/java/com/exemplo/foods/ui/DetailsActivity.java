package com.exemplo.foods.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.exemplo.foods.R;
import com.exemplo.foods.services.business.FoodBusiness;
import com.exemplo.foods.services.constants.FoodConstants;
import com.exemplo.foods.entities.FoodEntity;


public class DetailsActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();
    private int mId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        this.mViewHolder.mTextName = findViewById(R.id.text_name);
        this.mViewHolder.mTextCalories = findViewById(R.id.text_valueCalorie);
        this.mViewHolder.mTextQuantity = findViewById(R.id.text_qnt);
        this.mViewHolder.mTextUnit = findViewById(R.id.text_unt);
        this.mViewHolder.mDescription = findViewById(R.id.showDescription);

        this.getData();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            this.mId = bundle.getInt(FoodConstants.FOOD_ID);
            FoodEntity foodEntity = new FoodBusiness().get(mId);

            this.mViewHolder.mTextName.setText(foodEntity.getName());
            this.mViewHolder.mTextQuantity.setText(String.valueOf(foodEntity.getQuantity()));
            this.mViewHolder.mTextUnit.setText(foodEntity.getUnit());

            String strCalories = String.format("%s %s",foodEntity.getCalories(),this.getString(R.string.calories));
            this.mViewHolder.mTextCalories.setText(strCalories);

            if(! "".equals(foodEntity.getDescription())){
                this.mViewHolder.mDescription.setText(foodEntity.getDescription());
            }
        }
    }

    private static class ViewHolder {
        TextView mTextName;
        TextView mTextCalories;
        TextView mTextQuantity;
        TextView mTextUnit;
        TextView mDescription;
    }
}