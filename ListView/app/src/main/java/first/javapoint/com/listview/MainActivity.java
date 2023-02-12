package first.javapoint.com.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the listview
        listView = (ListView) findViewById(R.id.listView);

        // create the resource
        String fruits[] = {
                "Apple",
                "Mango",
                "Orange",
                "PineApple",
                "Kiwi",
                "Grapes",
                "Mozambi"
        };

        // create ArrayAdapter object params(context, where we want  to put, input resource)
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
          this, // context
                // android.R.layout.simple_list_item_1,    // data is inserted into textview
                R.layout.myview,
                fruits  // input resource
        );
        listView.setAdapter(arrayAdapter);

        // register the listview with eventlistener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent, // listview
                    View view,              // textview
                    int position,           // position of textview
                    long rowId              // for arrayadapter both position and row id are same
            ) {
                TextView textView = (TextView)view;
                String name = textView.getText().toString();
                Toast.makeText(
                        getApplicationContext(),
                        name + " is in position: " + position,
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
