package first.javapoint.com.switchonoffwifi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Switch aSwitch;
    WifiManager wifiManager;
    TextView textView;

    @SuppressLint("WifiManagerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = (Switch)findViewById(R.id.mySwitch);
        textView = (TextView)findViewById(R.id.textView);

        wifiManager = (WifiManager)getSystemService(WIFI_SERVICE);

        // register the switch for event handling
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // isChecked is true when button becomes OFF to ON position

                // to switch ON WiFi
                if(isChecked && !wifiManager.isWifiEnabled()){
                    wifiManager.setWifiEnabled(true);
                }

                // to switch OFF WiFi
                else if(!isChecked && wifiManager.isWifiEnabled()){
                    wifiManager.setWifiEnabled(false);
                }
            }
        });

        MyBroadCastReceiver myBroadCastReceiver = new MyBroadCastReceiver();

        // register the broadcast receiver
        registerReceiver(myBroadCastReceiver, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

    }

    class MyBroadCastReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            StringBuffer stringBuffer = new StringBuffer();
            List<ScanResult> list = wifiManager.getScanResults();
            for (ScanResult scanResult : list){
                stringBuffer.append(scanResult);
            }
            textView.setText(stringBuffer);
        }
    }
}
