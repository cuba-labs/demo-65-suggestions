package com.company.demo.web.screens;

import com.company.demo.entity.Region;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.gui.components.SuggestionPickerField;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

import javax.inject.Inject;
import java.util.Map;

public class ExtAppMainWindow extends AppMainWindow {
    @Inject
    private SuggestionPickerField suggestionPicker;
    @Inject
    private DataManager dataManager;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        suggestionPicker.setSearchExecutor((searchString, searchParams) -> dataManager.loadList(
                LoadContext.create(Region.class)
                        .setQuery(
                                new LoadContext.Query("select r from demo$Region r where r.title like :search")
                                        .setParameter("search", "%" + searchString + "%")
                        )));
    }

    public void subscribe() {
        showNotification("Subscribed! " + ((Region) suggestionPicker.getValue()).getTitle());
    }
}