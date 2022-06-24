package com.yadren.ecommerce.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yadren.ecommerce.MainActivity;
import com.yadren.ecommerce.R;
import com.yadren.ecommerce.model.Course;
import com.yadren.ecommerce.model.Order;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderView> {
    Context context;

    public OrderAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public OrderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View orderItems = LayoutInflater.from(context).inflate(R.layout.order_item, parent, false);
        return new OrderAdapter.OrderView(orderItems);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderView holder, int position) {
        int itemId = Order.items.get(position);
        Course course = MainActivity.findCourseById(itemId);
        if (course != null)
            holder.itemTitle.setText(course.getTitle());
    }

    @Override
    public int getItemCount() {
        return Order.getItems().size();
    }

    public class OrderView extends RecyclerView.ViewHolder {
        TextView itemTitle;

        public OrderView(@NonNull View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.itemTitle);
        }
    }

}
