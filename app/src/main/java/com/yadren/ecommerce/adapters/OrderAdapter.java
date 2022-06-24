package com.yadren.ecommerce.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yadren.ecommerce.model.Order;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderView> {

    @NonNull
    @Override
    public OrderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderView holder, int position) {

    }

    @Override
    public int getItemCount() {
        return Order.getItems().size();
    }

    public class OrderView extends RecyclerView.ViewHolder {

        public OrderView(@NonNull View itemView) {
            super(itemView);
        }
    }

}
