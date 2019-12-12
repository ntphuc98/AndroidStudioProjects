package com.example.imagesjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.activity_album);

        Intent intent=getIntent();
        String url = intent.getStringExtra("albumURL");
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            String albulmName = response.get("name").toString();
                            TextView albulmNameTV = findViewById(R.id.albumNameTV);
                            albulmNameTV.setText(albulmName);
                            JSONArray jsonArray=response.getJSONArray("images");

                            ArrayList<ImageItem> imageItems = new ArrayList<>();
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject ob=jsonArray.getJSONObject(i);
                                ImageItem item = new ImageItem(ob.get("name").toString()
                                        ,ob.get("description").toString());
                                imageItems.add(item);
                            }
                            ViewPager viewPager = findViewById(R.id.imgViewPager);
                            ImagePagerAdaper theAdapter = new ImagePagerAdaper(AlbumActivity.this,imageItems);
                            viewPager.setAdapter(theAdapter);


                        }
                        catch(JSONException e){
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("AlbumActivity","Network Error");
                    }
                });
        requestQueue.add(jsonRequest);
    }
}
