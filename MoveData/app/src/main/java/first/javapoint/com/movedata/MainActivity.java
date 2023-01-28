package first.javapoint.com.movedata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find EditText obj
        final EditText editText = (EditText) findViewById(R.id.editText);
        final EditText editText2 = (EditText) findViewById(R.id.editText2);

        // find the Button obj
        Button button = (Button) findViewById(R.id.button);

        // register the button for event handling
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // read the data from editText
                String data1 = editText.getText().toString();
                // read the data from editText2
                String data2 = editText2.getText().toString();
                // create the intent object
                Intent intent = new Intent(
                        getApplicationContext(),
                        SecondActivity.class
                );

                // put data1 & data2 into intent object
                intent.putExtra("first", data1);
                intent.putExtra("second", data2);

                // start second activity
                startActivity(intent);

            }
        });
    }
}
