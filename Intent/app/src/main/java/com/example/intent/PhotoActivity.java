package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PhotoActivity extends AppCompatActivity {
    Button btnShoot;
    Button btnSave;
    Button btnBack;
    ImageView imgView;
    Bitmap bitmap = null;
    OutputStream outputStream;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        mapping();
        imgView.setVisibility(View.INVISIBLE);

    }

    public void mapping() {
        btnBack = findViewById(R.id.btnBack);
        btnSave = findViewById(R.id.btnSave);
        btnShoot = findViewById(R.id.btnShoot);
        imgView = findViewById(R.id.imgView);
    }

    public void clickBtnBack(View view) {
        finish();
    }

    public void clickBtnShoot(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 123 && resultCode == RESULT_OK && data != null) {
            bitmap = (Bitmap) data.getExtras().get("data"); // data là mặc định
            imgView.setImageBitmap(bitmap);
            imgView.setVisibility(View.VISIBLE);
        }

        super.onActivityResult(requestCode, resultCode, data);

    }

    public void clickBtnSave(View view){
        if (bitmap != null ){
            File filepath = Environment.getExternalStorageDirectory();
            File dir = new File(filepath.getAbsolutePath() + "/Demo");
            dir.mkdir();
            File file = new File(dir, System.currentTimeMillis() + ".jpg");
            outputStream = null;
            try {
                outputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                Toast.makeText(this, "Lưu thành công!", Toast.LENGTH_SHORT).show();
                bitmap = null;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
