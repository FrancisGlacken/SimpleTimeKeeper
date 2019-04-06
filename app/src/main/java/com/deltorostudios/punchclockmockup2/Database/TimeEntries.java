package com.deltorostudios.punchclockmockup2.Database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

@Entity
public class TimeEntries {

    @ColumnInfo(name = "date_committed")
    String dateCommitted;

    public String getDateCommitted() {
        return dateCommitted;
    }

    public void setDateCommitted(String dateCommitted) {
        this.dateCommitted = dateCommitted;
    }
}
