package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int USER_ACTIVITY_CODE = 100;
    TextView txtAge;
    TextView txtEmail;
    TextView txtPassword;
    EditText etxtUsername;
    EditText etxtPassword;
    Button btnLogin;
    Button btnSendEmail;
    Button btnTakePhoto;
    String username;
    String userEmail;
    String userAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
    }

    public void mapping() {
        txtAge = findViewById(R.id.txtAge);
        txtEmail = findViewById(R.id.txtEmail);
        etxtUsername = findViewById(R.id.etxtUsername);
        etxtPassword = findViewById(R.id.etxtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnSendEmail = findViewById(R.id.btnSendEmail);
        btnTakePhoto = findViewById(R.id.btnTakePhoto);
        txtPassword = findViewById(R.id.txtPassword);
    }

    public void loginBtnClick(View view) {
        username = etxtUsername.getText().toString();
        String password = etxtPassword.getText().toString();
        if (checkIdentity(username, password)) {
            Intent userIntent = new Intent(this, UserActivity.class);
            userIntent.putExtra("username", username);
            startActivityForResult(userIntent, USER_ACTIVITY_CODE);
        } else {
            Toast.makeText(this, "Wrong username & password combination",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == USER_ACTIVITY_CODE) {
            userAge = data.getStringExtra("userAge");
            userEmail = data.getStringExtra("userEmail");

            if (checkValidEmail(userEmail)) {
                txtAge.setText("User age: " + userAge);
                txtEmail.setText("Email: " + userEmail);

                txtPassword.setVisibility(View.INVISIBLE);
                btnLogin.setVisibility(View.INVISIBLE);
                etxtPassword.setVisibility(View.INVISIBLE);
            } else {
                Toast.makeText(this, "Invalid email",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean checkValidEmail(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean checkIdentity(String username, String password) {
        if (username.equals("ntphuc") && password.equals("ntphuc"))
            return true;
        else
            return false;
    }

    public void sendEmailToUser(View view) {
        //Implicit intent
        Intent emailIntent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello " + username);
        emailIntent.putExtra(Intent.EXTRA_TEXT,
                "This is an email for " + username + ", Age: " + userAge);
        String[] recipients = new String[]{userEmail};
        emailIntent.putExtra(Intent.EXTRA_EMAIL, recipients);

        startActivity(Intent.createChooser(emailIntent, "Send email from ..."));

    }

    public void clickBtnTakePhoto(View view) {
        Intent photoIntent = new Intent(this, PhotoActivity.class);
        startActivity(photoIntent);
    }
}
