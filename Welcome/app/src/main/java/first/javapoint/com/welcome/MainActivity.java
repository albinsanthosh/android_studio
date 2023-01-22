package first.javapoint.com.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // For fullscreen & no title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        // For fullscreen & no title bar end

        setContentView(R.layout.activity_main);

        // get the EditText
        editText = (EditText)findViewById(R.id.editText2);
        //get the button object
        button = (Button)findViewById(R.id.button2);
        // register the button with event listener
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
