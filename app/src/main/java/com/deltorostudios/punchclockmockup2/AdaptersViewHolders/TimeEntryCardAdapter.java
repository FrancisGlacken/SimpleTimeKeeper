package com.deltorostudios.punchclockmockup2.AdaptersViewHolders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.deltorostudios.punchclockmockup2.Database.Category;
import com.deltorostudios.punchclockmockup2.Database.TimeEntry;
import com.deltorostudios.punchclockmockup2.R;
import com.deltorostudios.punchclockmockup2.Util.FormatMillisIntoTimer;

import java.util.ArrayList;
import java.util.List;

public class TimeEntryCardAdapter extends RecyclerView.Adapter<TimeEntryCardAdapter.TimeEntryCardHolder> {

    private FormatMillisIntoTimer form = new FormatMillisIntoTimer();
//    private List<TimeEntry> categoryList = new ArrayList<>();

//    public void setCategories(List<Category> categories) {
//        this.categoryList = categories;
//        notifyDataSetChanged();
//    }

    @NonNull
    @Override
    public TimeEntryCardHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.time_entry_row, viewGroup, false);
        return new TimeEntryCardHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TimeEntryCardHolder timeEntryCardHolder, int position) {
        timeEntryCardHolder.timeEntryPositionView.setText(position);
        timeEntryCardHolder.timeEntryTimeView.setText("00:00:00");
        timeEntryCardHolder.timeEntryDateView.setText("12/31/19");
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    //Todo: Do I have the right context?

    public class TimeEntryCardHolder extends RecyclerView.ViewHolder {
        public TextView timeEntryPositionView, timeEntryTimeView, timeEntryDateView;

        public TimeEntryCardHolder(View itemView) {
            super(itemView);

            timeEntryPositionView = itemView.findViewById(R.id.timeEntryPositionView);
            timeEntryTimeView = itemView.findViewById(R.id.timeEntryTimeView);
            timeEntryDateView = itemView.findViewById(R.id.timeEntryDateView);
        }
    }
}
