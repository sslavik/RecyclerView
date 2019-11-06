package com.sslavik.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sslavik.recyclerview.Model.UserModel;

public class MainActivity extends AppCompatActivity { //implements RecyclerUserAdapter.OnItemClickListener{

    private RecyclerView rvUser;
    private RecyclerUserAdapter userAdapter;
    // CREAMOS UN DELEGADO / LISTENER PARA LAS VISTAS (HOLDERS) DEL RECYCLERS
    private RecyclerUserAdapter.OnUserClickListener userClickListener = new RecyclerUserAdapter.OnUserClickListener() {
        @Override
        public void onClick(UserModel user) {
            Toast.makeText(MainActivity.this, user.getName(), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvUser = findViewById(R.id.rvUsers);
        rvUser.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        // userAdapter = new RecyclerUserAdapter(this, this); // CON ESTE CONSTRUCTOR BASAMOS EL LISTENER DIRECTAMENTE CON EL IMPLEMENT DEL LISTENER OnItemClickListener
        userAdapter = new RecyclerUserAdapter(this, userClickListener);
        rvUser.setAdapter(userAdapter);


    }
    /*
    // Este es el método que se ejecuta automáticamente cuando se hace click en un elemento del RecyclerView
    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Se ha pulsado " + userAdapter.getItem(rvUser.getChildAdapterPosition(v)).getName(),Toast.LENGTH_SHORT).show();
    }

     */
}
