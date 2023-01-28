package first.javapoint.com.movedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // get the Intent object
        Intent intent = getIntent();
        // retrieve the data from Intent object
        String s = intent.getStringExtra("first");
        String s1 = intent.getStringExtra("second");

        // find the TextView object
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(s+":"+s1);
    }
}
