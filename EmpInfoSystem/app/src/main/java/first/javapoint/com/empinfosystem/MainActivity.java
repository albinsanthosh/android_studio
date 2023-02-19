package first.javapoint.com.empinfosystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add, remove, display;
    DataBaseHandler dataBaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = (Button)findViewById(R.id.addButton);
        remove = (Button)findViewById(R.id.removeButton);
        display = (Button)findViewById(R.id.displayButton);
        dataBaseHandler = new DataBaseHandler(
                getApplicationContext(),   // context
                "Employee",         // table name
                null,              // default cursor
                1                  // version number of database
        );

        // register add button with event listener
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataBaseHandler.addData(); //  insert one row
            }
        });

        // register remove button with event listener
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // register display button with event listener
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = dataBaseHandler.getData();
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
