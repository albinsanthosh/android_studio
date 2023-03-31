package first.javapoint.com.switchonoffbluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button onButton;
    Button offButton;
    Button listButton;
    TextView textView;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onButton = (Button)findViewById(R.id.button);
        offButton = (Button)findViewById(R.id.button2);
        listButton = (Button)findViewById(R.id.button3);
        textView = (TextView)findViewById(R.id.textView);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter(); // to get default bluetoothAdapter

        // to switch on bluetooth
        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!bluetoothAdapter.isEnabled()){
                    Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivity(intent);
                }
            }
        });

        // to switch off bluetooth
        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetoothAdapter.isEnabled()){
                    bluetoothAdapter.disable();
                }
            }
        });

        // list out the paired/bonded devices
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bluetoothAdapter.isEnabled()){
                   Set<BluetoothDevice> set = bluetoothAdapter.getBondedDevices();
                   for(BluetoothDevice bluetoothDevice: set){
                       textView.append(bluetoothDevice.getName() + ", " + bluetoothDevice); // output: paired device name, address
                   }
                }
            }
        });
    }
}
