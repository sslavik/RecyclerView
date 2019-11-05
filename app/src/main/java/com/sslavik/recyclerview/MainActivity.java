package com.sslavik.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerUserAdapter.OnItemClickListener{

    private RecyclerView rvUser;
    private RecyclerUserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvUser = findViewById(R.id.rvUsers);
        rvUser.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        userAdapter = new RecyclerUserAdapter(this, this);
        rvUser.setAdapter(userAdapter);

    }
    // Este es el método que se ejecuta automáticamente cuando se hace click en un elemento del RecyclerView
    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Se ha pulsado" + v.getId(),Toast.LENGTH_SHORT);
    }
}
