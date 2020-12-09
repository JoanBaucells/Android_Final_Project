package com.uvic.padlemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.uvic.padlemanager.Entitats.Competidor;
import com.uvic.padlemanager.Entitats.User;
import com.uvic.padlemanager.Singleton.App_singleton;

public class Usuaris extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuaris);

        ListView list = findViewById(R.id.list);
        ArrayAdapter<Competidor> adapter = new ArrayAdapter<Competidor>(this, android.R.layout.simple_list_item_1, App_singleton.getInstance().getList_competidors());
        list.setAdapter(adapter);
    }
}