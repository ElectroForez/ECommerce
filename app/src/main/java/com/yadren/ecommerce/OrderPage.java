package com.yadren.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yadren.ecommerce.adapters.OrderAdapter;
import com.yadren.ecommerce.model.Course;
import com.yadren.ecommerce.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {
    RecyclerView orderRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        List<String> ordersTitles = new ArrayList<>();
        for (int itemId: Order.items) {
            Course course = MainActivity.findCourseById(itemId);
            if (course != null)
                ordersTitles.add(course.getTitle());
        }
        setOrderRecycler();
    }

    private void setOrderRecycler() {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        orderRecycler = findViewById(R.id.orderRecycler);
        orderRecycler.setLayoutManager(layoutManager);

        OrderAdapter orderAdapter = new OrderAdapter(this);
        orderRecycler.setAdapter(orderAdapter);
    }
}