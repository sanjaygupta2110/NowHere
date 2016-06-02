package com.mnowhere.nowhere;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class HomeActivity extends AppCompatActivity {
    private TextView bluetoothflag1;


    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        // mBluetoothAdapter.isEnabled();
        bluetoothflag1 = (TextView)findViewById(R.id.bluetoothflag);
        bluetoothflag1.setText(Boolean.toString(mBluetoothAdapter.isEnabled()));
    }
    private java.lang.String txt;

    public void list(View v){
        pairedDevices = BA.getBondedDevices();
        //ArrayList list = new ArrayList();

        for(BluetoothDevice bt : pairedDevices) {
            txt = txt + bt.getName() + "<>";
          //  list.add(bt.getName());
        }
        //Toast.makeText(getApplicationContext(),"Showing Paired Devices",Toast.LENGTH_SHORT).show();

        //final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        //lv.setAdapter(adapter);


        bluetoothflag1.setText(txt);

    }

    public void onGridBtnClick(View v)
    {
        switch (v.getId())
        {
            case(R.id.offerBtn):
                //Toast.makeText(this, "Data Saved successfully", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(this, OffersActivity.class));
                Intent i = new Intent(getApplicationContext(),OffersActivity.class);
                startActivity(i);
                break;
            case(R.id.eventsBtn):




                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (!mBluetoothAdapter.isEnabled()) {
                    mBluetoothAdapter.enable();
                }
                //This will initiate the discovery of available devices
                mBluetoothAdapter.startDiscovery();

                // next two lines will show a prompt that bluetooth will scan for 120 secs
                Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                startActivityForResult(getVisible, 0);

                pairedDevices = mBluetoothAdapter.getBondedDevices();
                //ArrayList list = new ArrayList();

                for(BluetoothDevice bt : pairedDevices) {
                    txt = txt + bt.getName() + "<>";
                    //  list.add(bt.getName());
                }
                //Toast.makeText(getApplicationContext(),"Showing Paired Devices",Toast.LENGTH_SHORT).show();

                //final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
                //lv.setAdapter(adapter);


                bluetoothflag1.setText(txt);


                //list(v);

bluetoothflag1.setText(mBluetoothAdapter.getName());

                Intent eventsIntent = new Intent(getApplicationContext(),EventsActivity.class);
                startActivity(eventsIntent);
                break;
            case(R.id.contestsBtn):
                Intent contestsIntent = new Intent(getApplicationContext(),ContestsActivity.class);
                startActivity(contestsIntent);
                break;
            case(R.id.storesBtn):
                Intent storesIntent = new Intent(getApplicationContext(),StoresActivity.class);
                startActivity(storesIntent);
                break;
            case(R.id.entertainmentBtn):
                Intent entertainmentIntent = new Intent(getApplicationContext(),EntertainmentActivity.class);
                startActivity(entertainmentIntent);
                break;
            case(R.id.diningsBtn):
                Intent diningsIntent = new Intent(getApplicationContext(),DiningsActivity.class);
                startActivity(diningsIntent);
                break;
            case(R.id.shoppingBtn):
                Intent shoppingIntent = new Intent(getApplicationContext(),ShoppingActivity.class);
                startActivity(shoppingIntent);
                break;
            case(R.id.mapsBtn):
                Intent mapsIntent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(mapsIntent);
                break;
            case(R.id.parkingBtn):
                Intent parkingIntent = new Intent(getApplicationContext(),ParkingActivity.class);
                startActivity(parkingIntent);
                break;
            case(R.id.friendBtn):
                Intent friendIntent = new Intent(getApplicationContext(),FriendActivity.class);
                startActivity(friendIntent);
                break;
            default:
                break;
        }
    }

}
