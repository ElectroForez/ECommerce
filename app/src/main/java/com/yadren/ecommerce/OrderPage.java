package com.yadren.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yadren.ecommerce.model.Course;
import com.yadren.ecommerce.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        ListView ordersListView = findViewById(R.id.orderListView);
        List<String> ordersTitles = new ArrayList<>();
        for (int itemId: Order.items) {
            for (Course course: MainActivity.courseList) {
                if (course.getId() == itemId) {
                    ordersTitles.add(course.getTitle());
                    break;
                }
            }
        }
        System.out.println(ordersTitles);
        ordersListView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ordersTitles));
    }
}