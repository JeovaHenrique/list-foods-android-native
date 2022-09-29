package com.exemplo.foods.ui.viewHolder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.exemplo.foods.services.listener.OnListClick;
import com.exemplo.foods.R;
import com.exemplo.foods.entities.FoodEntity;

public class FoodViewHolder extends RecyclerView.ViewHolder {

    private TextView mName;
    private TextView mCalorie;
    private TextView mQuantity;
    private TextView mUnit;

    private Context mContext;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

        this.mContext = itemView.getContext();

        this.mName = itemView.findViewById(R.id.text_name);
        this.mCalorie = itemView.findViewById(R.id.text_calories);
        this.mQuantity = itemView.findViewById(R.id.text_qnt);
        this.mUnit = itemView.findViewById(R.id.text_unt);
    }

    public void bind(FoodEntity Food, final OnListClick listener) {

        mName.setText(Food.getName());
        String strCalorie = String.format("%s %s", Food.getCalories(),this.mContext.getString(R.string.calories));
        mCalorie.setText(strCalorie);
        mQuantity.setText(String.valueOf(Food.getQuantity()));
        mUnit.setText(Food.getUnit());


        this.mName.setOnClickListener(v -> listener.onclick(Food.getId()));
    }
}
