package first.javapoint.com.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the Button object
        Button button = (Button) findViewById(R.id.button);

        // get the LayoutInflator obj => to instantiate xml file -> view objects
        LayoutInflater layoutInflater = getLayoutInflater();
        final View customView = layoutInflater.inflate(
                R.layout.custom, //what to inflate
                (ViewGroup) findViewById(R.id.customId) // where to inflate
        );

        // register the button for event handling
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create a Toast object
                Toast toast = new Toast(getApplicationContext());
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(customView); // yet to coded
                toast.show();
            }
        });
    }
}
