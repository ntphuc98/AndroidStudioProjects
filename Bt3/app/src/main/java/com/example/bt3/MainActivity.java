package com.example.bt3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> citySource;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        citySource = new ArrayList<>();
        citySource.add("Da Nang");
        citySource.add("Ha Noi");
        citySource.add("Ho Chi Ming");
        citySource.add("Hai Phong");
        citySource.add("Can Tho");

        listView = findViewById(R.id.listView);
    }
}
