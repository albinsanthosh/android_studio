package com.example.applicationspecificfoldersstorefiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput("myFile.txt",MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String s = "This is a sample data";
        try {
            fileOutputStream.write(s.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("myFile.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        try {
            textView.append(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // To get the path of the file which is kept in the Application specific folder
        File file = getFilesDir();
        Log.d("file path is ", file.getAbsolutePath());
    }
}