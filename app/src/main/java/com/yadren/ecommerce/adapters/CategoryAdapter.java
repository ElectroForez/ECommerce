package com.yadren.ecommerce.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yadren.ecommerce.MainActivity;
import com.yadren.ecommerce.R;
import com.yadren.ecommerce.model.Category;
import com.yadren.ecommerce.model.Course;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    Context context;
    List<Category> categories;

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItems = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new CategoryViewHolder(categoryItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category curCategory = categories.get(position);
        holder.categoryTitle.setText(curCategory.getTitle());
        if (curCategory.getSelected()) {
            holder.categoryBg.setImageResource(R.drawable.ic_category_selected);
            holder.categoryTitle.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            holder.categoryBg.setImageResource(R.drawable.ic_bg_category_item);
            holder.categoryTitle.setTextColor(context.getResources().getColor(R.color.black));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetSelectedCategories();
                curCategory.setSelected(true);
                MainActivity.showCoursesByCategory(curCategory.getId());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTitle;
        ImageView categoryBg;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTitle = itemView.findViewById(R.id.category_title);
            categoryBg = itemView.findViewById(R.id.categoryBg);
        }

    }

    public void resetSelectedCategories() {
        for (Category category: categories) {
            category.setSelected(false);
        }
    }
}
