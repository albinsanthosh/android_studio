package first.javapoint.com.fragdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ListFrag extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // create object for the xml file, list_frag.xml
        View view = inflater.inflate(
                R.layout.list_frag,
                container,
                false
        );

        // get the object of ListView by using the obj view
        ListView listView = (ListView) view.findViewById(R.id.listView);

        // create a datasource
        String fruits[] = new String[]{
                "Apple", "Mango", "Strawberry", "Kiwi", "Mozambi", "Orange", "Banana", "Litchi"
        };

        ArrayAdapter adapter = new ArrayAdapter(
                getActivity(), // Returns the Activity this fragment is currently associated with.
                android.R.layout.simple_list_item_1,
                fruits
        );

        // set the Adapter content in ListView
        listView.setAdapter(adapter);

        // do event handling in ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView view1 = (TextView) view;
                String data = view1.getText().toString();

                // get the FragmentManager
                FragmentManager manager = getFragmentManager();

                // pass the data to the TextFrag => find the fragment, TextFrag
                TextFrag textFrag = (TextFrag) manager.findFragmentById(R.id.fragment2);

                // set the content in TextFrag
                textFrag.textView.setText(data);
            }
        });
        return view;
    }
}
