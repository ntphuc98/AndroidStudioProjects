package com.example.demonotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final int NOTIFICATION_ID = 001;
    private final String CHANNEL_ID = "DemoNotification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayNotification(){
        Notification.Builder builder = new Notification.Builder(this, CHANNEL_ID);
        builder.setContentTitle("Title Notification");
        builder.setContentText("Content of Notification");
        builder.setPriority(NotificationCompat.)
    }
    public void clickBtnDisplay(View view){
        displayNotification();
    }
}
