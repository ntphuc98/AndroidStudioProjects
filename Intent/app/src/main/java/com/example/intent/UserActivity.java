package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = getIntent();
        String usernameStr = intent.getStringExtra("username");
        TextView txtUsername2 = findViewById(R.id.txtUsername2);
        txtUsername2.setText(usernameStr);
    }

    public void backBtnClick(View view) {
        EditText etxtAge = findViewById(R.id.etxtAge);
        EditText etxtEmail = findViewById(R.id.etxtEmail);

        Intent dataIntent = new Intent();

        dataIntent.putExtra("userAge", etxtAge.getText().toString());
        dataIntent.putExtra("userEmail", etxtEmail.getText().toString());
        setResult(Activity.RESULT_OK, dataIntent);

        finish();
    }
}
