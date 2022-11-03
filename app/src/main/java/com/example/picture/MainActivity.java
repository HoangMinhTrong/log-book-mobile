package com.example.picture;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.picture.database.MyDatabaseHelper;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button addButton, prevButton, nextButton;
    int position = 0;
    int positionold = position;
    EditText urlImage;
    String url;
    ArrayList<String> id, url_Image;
    List<String> listImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        addButton = findViewById(R.id.addButton);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        urlImage = findViewById(R.id.urlImage);
        //
        id = new ArrayList<>();
        url_Image = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MyDatabaseHelper databaseHelper = new MyDatabaseHelper(MainActivity.this);
                getListImage(url);
//                databaseHelper.addImage(urlImage.getText().toString().trim());
                urlImage.getText().clear();
            }
        });

//        MyDatabaseHelper databaseHelper = new MyDatabaseHelper(MainActivity.this);
//        Cursor cursor = databaseHelper.getAll();
//        if(cursor.getCount() == 0){
//            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
//        }else{
//            cursor.moveToFirst();
//            while (cursor.moveToNext()){
//                id.add(cursor.getString(0));
//                url_Image.add((cursor.getString(1)));
//            }
//        }

    }
    public void getListImage(String url)
    {
        url = urlImage.getText().toString().trim();
//        List<String> i = Arrays.asList(url_Image).get(0);
//        int in = i.indexOf(0);
        listImg = new ArrayList<>();
        String url1 = "https://i.pinimg.com/736x/05/09/94/050994962c61328795f2568b4c51c0ab.jpg";
        String url2 = "https://1.bp.blogspot.com/-RoOiYu8pweY/YGLZiX0bQ_I/AAAAAAAArE4/4AUbslYlESME_-arrxmvha763Te_jh1kwCNcBGAsYHQ/s0/ff99e81f59e3a9c02ff4f799f35cfc90.jpeg";
        listImg.add(url);
        listImg.add(url1);
        listImg.add(url2);
        Glide.with(this).load(listImg.get(0)).into(image);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(url_Image.size() > url_Image.size())
                {
                    Glide.with(MainActivity.this).load(listImg.get(0)).into(image);
                }
                Glide.with(MainActivity.this).load(listImg.get(++position)).into(image);
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                --position;
                if(position == listImg.size() -1)
                    position = 0;
                Glide.with(MainActivity.this).load(listImg.get(position)).into(image);
            }
        });

    }

}