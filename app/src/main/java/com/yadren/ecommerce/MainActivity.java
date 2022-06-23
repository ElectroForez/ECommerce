package com.yadren.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yadren.ecommerce.adapters.CategoryAdapter;
import com.yadren.ecommerce.adapters.CourseAdapter;
import com.yadren.ecommerce.model.Category;
import com.yadren.ecommerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;

    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> filterCourses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categoryRecycler = findViewById(R.id.categoryRecycler);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Прочее"));

        courseList.add(new Course(1, "Профессия Java\nразработчик", "java_course", "1 января", "начальный", "#424345", getString(R.string.java_course_desc), 1));
        courseList.add(new Course(2, "Профессия\nPython\nразработчик", "java_course", "24 мая", "middle", "#9FA52D", "TEST", 2));

        filterCourses.addAll(courseList);
        setCategoryRecycler(categoryList);
        setCourseRecycler(filterCourses);

        ImageView filterButton = findViewById(R.id.filterButton);
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryAdapter.resetSelectedCategories();
                categoryAdapter.notifyDataSetChanged();
                showCoursesByCategory(-1);
            }
        });
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    public static void showCoursesByCategory(int category) {
        filterCourses.clear();

        if (category != -1) {
            for (Course course : courseList) {
                if (course.getCategory() == category) {
                    filterCourses.add(course);
                }
            }
        } else {
            filterCourses.addAll(courseList);
        }

        courseAdapter.notifyDataSetChanged();
    }
}