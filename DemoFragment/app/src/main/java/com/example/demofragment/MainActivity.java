package com.example.demofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.IMessageSend{
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // quan ly fragment
        fragmentManager = getSupportFragmentManager();

        if (savedInstanceState != null){
            return ;
        }
        GoNextFragment goNextFragment = new GoNextFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction()
                .add(R.id.fragment_container, goNextFragment, null);
        fragmentTransaction.commit();
    }

    @Override
    public void onMessage(String msg) {
        TextView txt = findViewById(R.id.txt);
        txt.setText(msg);
    }
}
