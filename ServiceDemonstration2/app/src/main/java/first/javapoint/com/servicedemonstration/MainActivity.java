package first.javapoint.com.servicedemonstration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);

        Log.i(
                "mylog",
                "thread id in main activity is " + Thread.currentThread().getId() // id of thread
        );

        // event handling for start service button
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start the service
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                startService(intent);
            }
        });

        // event handling for stop service button
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stop the service
                Intent intent = new Intent(getApplicationContext(), MyService.class);
                stopService(intent);
            }
        });
    }
}
