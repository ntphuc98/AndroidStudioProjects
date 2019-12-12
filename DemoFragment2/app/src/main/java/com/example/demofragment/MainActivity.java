package com.example.demofragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.MessageSendListener {

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState != null) { //lưu trữ thông tin ứng dụng của mình trước khi trở về home
            return;
        }
        GoNextFragment goNextFragment = new GoNextFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction().
                add(R.id.fragment_container, goNextFragment, null);
        fragmentTransaction.commit();

    }

    public void onMesage(String message) {
        TextView displayMsgTV = findViewById(R.id.msgTV);
        displayMsgTV.setText(message);
    }

    public void nguocMsg(String nguoc) {
        TextView displayMsgTV = findViewById(R.id.msgTV);
        displayMsgTV.setText(nguoc);
    }
}