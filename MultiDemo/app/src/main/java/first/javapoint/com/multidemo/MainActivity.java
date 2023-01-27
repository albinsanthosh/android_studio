package first.javapoint.com.multidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the button
        Button button = (Button) findViewById(R.id.button);

        // register the button for event handling
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // create an intent object
                Intent intent = new Intent(
                        getApplicationContext(), // context(activity/application)
                        Welcome.class // name of the Activity class
                );
                startActivity(intent);
            }
        });
    }
}
