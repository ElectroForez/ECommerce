package com.yadren.ecommerce.adapters;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.yadren.ecommerce.CoursePage;
import com.yadren.ecommerce.R;
import com.yadren.ecommerce.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        Course curCourse = courses.get(position);

        String courseColorName = curCourse.getColor();
        int curseColor = Color.parseColor(courseColorName);
        holder.courseBg.setBackgroundColor(curseColor);

        String courseImageName = "ic_"  + curCourse.getImg();
        int courseImageId = context.getResources().getIdentifier(courseImageName, "drawable", context.getPackageName());
        holder.courseImage.setImageResource(courseImageId);

        String courseTitle = curCourse.getTitle();
        holder.courseTitle.setText(courseTitle);

        String courseDate = curCourse.getDate();
        holder.courseDate.setText(courseDate);

        String courseLevel = curCourse.getLevel();
        holder.courseLevel.setText(courseLevel);

        String courseText = curCourse.getText();
        int courseId = curCourse.getId();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CoursePage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.courseImage, "courseImage")
                );

                intent.putExtra("courseBg", curseColor);
                intent.putExtra("courseImageId", courseImageId);
                intent.putExtra("courseTitle", courseTitle);
                intent.putExtra("courseDate", courseDate);
                intent.putExtra("courseLevel", courseLevel);
                intent.putExtra("courseText", courseText);
                intent.putExtra("courseId", courseId);

                context.startActivity(intent, options.toBundle());

            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout courseBg;
        ImageView courseImage;
        TextView courseTitle, courseDate, courseLevel;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            courseBg = itemView.findViewById(R.id.courseBg);
            courseImage = itemView.findViewById(R.id.courseImg);
            courseDate = itemView.findViewById(R.id.courseDate);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseLevel = itemView.findViewById(R.id.courseLevel);
        }
    }
}
