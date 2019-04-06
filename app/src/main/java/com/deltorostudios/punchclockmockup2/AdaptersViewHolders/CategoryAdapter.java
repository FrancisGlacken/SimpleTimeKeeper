package com.deltorostudios.punchclockmockup2.AdaptersViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deltorostudios.punchclockmockup2.Database.Category;
import com.deltorostudios.punchclockmockup2.R;
import com.deltorostudios.punchclockmockup2.Util.FormatMillisIntoTimer;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private FormatMillisIntoTimer form = new FormatMillisIntoTimer();
    private List<Category> categoryList = new ArrayList<>();

    public void setCategories(List<Category> categories) {
        this.categoryList = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_card_view, viewGroup, false);
        return new CategoryHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder categoryHolder, int position) {
        Category category = categoryList.get(position);
        categoryHolder.categoryTitleTextView.setText(category.getTitle());
        categoryHolder.categoryTotalTimeView.setText(form.FormatMillisIntoDHM(category.getTotalTime()));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class CategoryHolder extends RecyclerView.ViewHolder {
        public TextView categoryTitleTextView, categoryTotalTimeView;

        public CategoryHolder(View itemView) {
            super(itemView);

            categoryTitleTextView = itemView.findViewById(R.id.categoryTitleTextView);
            categoryTotalTimeView = itemView.findViewById(R.id.totalTimeTextView);
        }
    }
}

