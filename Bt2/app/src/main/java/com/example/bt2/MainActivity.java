package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view) {
        ImageView image = findViewById(R.id.imageView);
        TextView text = findViewById(R.id.note);
        switch (view.getId()){
            case R.id.red:
                image.setImageDrawable(getResources().getDrawable(R.drawable.leo));
                text.setText("This is Leo");
                break;
            case R.id.gray:
                image.setImageDrawable(getResources().getDrawable(R.drawable.raph));
                text.setText("This is Raph");
                break;
            case R.id.blue:
                image.setImageDrawable(getResources().getDrawable(R.drawable.donatello));
                text.setText("This is Donatello");
                break;
            case R.id.pink:
                image.setImageDrawable(getResources().getDrawable(R.drawable.michelangelo));
                text.setText("This is Michelangelo");
                break;
            default:
                break;
        }
    }

    public void hidden(View view) {
        Switch a = findViewById(R.id.switch_1);
        ImageView color = findViewById(R.id.imageView);
        if(a.isChecked()){
            color.setVisibility(View.VISIBLE);
        }else {
            color.setVisibility(View.INVISIBLE);
        }

    }
}