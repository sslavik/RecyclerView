package com.sslavik.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUser;
    private RecyclerUserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvUser = findViewById(R.id.rvUsers);
        rvUser.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        userAdapter = new RecyclerUserAdapter(this);
        rvUser.setAdapter(userAdapter);

    }
}
