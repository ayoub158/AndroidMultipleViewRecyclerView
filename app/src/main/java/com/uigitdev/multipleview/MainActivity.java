package com.uigitdev.multipleview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uigitdev.multipleview.adapter.GroupAdapter;
import com.uigitdev.multipleview.model.Group;
import com.uigitdev.multipleview.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private GroupAdapter groupAdapter;
    private ArrayList<Group> groups;
    private ArrayList<Movie> cover;
    private ArrayList<Movie> simple;
    private ArrayList<Movie> vertical;
    //todo 0. If you want to add more types of objects, you can easily do so. Check "todo list" (I added it step by step)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAdapterType();
        setAdapter();
    }

    private void initGroupData() {
        groups = new ArrayList<>();
        groups.add(new Group("Cover", "View All"));
        groups.add(new Group("Simple", "View All"));
        groups.add(new Group("Vertical", "View All"));
    }

    private void initMovieData() {
        cover = new ArrayList<>();
        simple = new ArrayList<>();
        vertical = new ArrayList<>();

        cover.add(new Movie("Movie Title", "Movie Subtitle", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/cover_item_0.jpg"));
        cover.add(new Movie("Movie Title1", "Movie Subtitle1", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/cover_item_1.jpg"));
        cover.add(new Movie("Movie Title2", "Movie Subtitle2", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/cover_item_2.jpg"));

        simple.add(new Movie("Movie Title3", "Movie Subtitle3", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_3.jpg"));
        simple.add(new Movie("Movie Title5", "Movie Subtitle5", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_5.jpg"));
        simple.add(new Movie("Movie Title4", "Movie Subtitle4", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_4.jpg"));
        simple.add(new Movie("Movie Title6", "Movie Subtitle6", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_6.png"));
        simple.add(new Movie("Movie Title7", "Movie Subtitle7", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_7.jpg"));

        vertical.add(new Movie("Movie Title8", "Movie Subtitle8", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_8.jpg"));
        vertical.add(new Movie("Movie Title10", "Movie Subtitle10", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_10.jpg"));
        vertical.add(new Movie("Movie Title9", "Movie Subtitle9", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_9.jpg"));
        vertical.add(new Movie("Movie Title11", "Movie Subtitle11", "http://uigitdev.nhely.hu/project_tools_images/multiple_view/item_11.jpg"));
    }

    private void setAdapterType() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void setAdapter() {
        initGroupData();
        initMovieData();
        //todo 1. Add the new object to the parameter list.
        groupAdapter = new GroupAdapter(MainActivity.this, groups, cover, simple, vertical);
        recyclerView.setAdapter(groupAdapter);
    }
}
