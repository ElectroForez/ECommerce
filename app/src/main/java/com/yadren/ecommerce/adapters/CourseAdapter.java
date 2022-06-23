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

        String colorName = curCourse.getColor();
        int color = Color.parseColor(colorName);
        holder.courseBg.setBackgroundColor(color);

        String imageName = "ic_"  + curCourse.getImg();
        int imageId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        holder.courseImage.setImageResource(imageId);

        String title = curCourse.getTitle();
        holder.courseTitle.setText(title);

        String date = curCourse.getDate();
        holder.courseDate.setText(date);

        String level = curCourse.getLevel();
        holder.courseLevel.setText(level);

        String text = curCourse.getText();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CoursePage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.courseImage, "courseImage")
                );

                intent.putExtra("courseBg", color);
                intent.putExtra("courseImageId", imageId);
                intent.putExtra("courseTitle", title);
                intent.putExtra("courseDate", date);
                intent.putExtra("courseLevel", level);
                intent.putExtra("courseText", text);

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
