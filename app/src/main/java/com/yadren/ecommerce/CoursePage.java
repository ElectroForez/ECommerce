package com.yadren.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.yadren.ecommerce.model.Order;

import java.util.List;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout coursePageBg = findViewById(R.id.coursePageBg);
        TextView coursePageTitle = findViewById(R.id.coursePageTitle);
        TextView coursePageDate = findViewById(R.id.coursePageDate);
        TextView coursePageLevel = findViewById(R.id.coursePageLevel);
        TextView courseText = findViewById(R.id.courseText);
        ImageView coursePageImage = findViewById(R.id.coursePageImage);

        int coursePageBg_value = getIntent().getIntExtra("courseBg", 0);
        String coursePageTitle_value = getIntent().getStringExtra("courseTitle");
        String coursePageDate_value = getIntent().getStringExtra("courseDate");
        String coursePageLevel_value = getIntent().getStringExtra("courseLevel");
        String coursePageText_value = getIntent().getStringExtra("courseText");
        int coursePageImage_value = getIntent().getIntExtra("courseImageId", 0);


        coursePageBg.setBackgroundColor(coursePageBg_value);
        coursePageTitle.setText(coursePageTitle_value);
        coursePageDate.setText(coursePageDate_value);
        coursePageLevel.setText(coursePageLevel_value);
        courseText.setText(coursePageText_value);
        coursePageImage.setImageResource(coursePageImage_value);
    }

    public void addToCart(View view) {
        int courseId = getIntent().getIntExtra("courseId", 0);
        List<Integer> cartItems = Order.getItems();
        if (cartItems.contains(courseId)) {
            Toast.makeText(this, "Курс уже лежит в корзине", Toast.LENGTH_SHORT).show();
        } else {
            cartItems.add(courseId);
            Toast.makeText(this, "Добавлено в корзину", Toast.LENGTH_SHORT).show();
        }
    }
}