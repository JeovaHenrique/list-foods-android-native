package com.exemplo.foods.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exemplo.foods.R;
import com.exemplo.foods.entity.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView name;
    private TextView calorie;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.text_name);
        calorie = itemView.findViewById(R.id.text_calories);
    }

    public void bind(FoodEntity Food) {
        name.setText(Food.getName());
        calorie.setText(String.valueOf(Food.getCalories()));
    }
}
