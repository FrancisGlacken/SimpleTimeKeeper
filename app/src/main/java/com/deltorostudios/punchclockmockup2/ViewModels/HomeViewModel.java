package com.deltorostudios.punchclockmockup2.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.deltorostudios.punchclockmockup2.Database.Category;
import com.deltorostudios.punchclockmockup2.Database.DataRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {
    private DataRepository repository;
    private LiveData<List<Category>> allCategories;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new DataRepository(application);
        allCategories = repository.getAllCategories();
    }

    public void insertCategory(Category category) {
        repository.insertCategory(category);
    }

    public void updateCategory(Category category) {
        repository.updateCategory(category);
    }

    public void deleteCategory(Category category) {
        repository.deleteCategory(category);
    }

    public void deleteAllCategory() {
        repository.deleteAllCategories();
    }

    public LiveData<List<Category>> getAllCategories() {
        return allCategories;
    }
}
