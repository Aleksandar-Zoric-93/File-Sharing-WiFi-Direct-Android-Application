package ie.ittralee.finalyeartest.finalyeartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String log;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* DBHandler db = new DBHandler(this);

        // Inserting Shop/Rows - Used for testing purposes.
        Log.d("Insert: ", "Inserting ..");
        db.addShop(new Shop("Dockers", " 475 Brannan St #330, San Francisco, CA 94107, United States"));
        db.addShop(new Shop("Dunkin Donuts", "White Plains, NY 10601"));
        db.addShop(new Shop("Pizza Porlar", "North West Avenue, Boston , USA"));
        db.addShop(new Shop("Town Bakers", "Beverly Hills, CA 90210, USA"));

        // Reading all shops
        Log.d("Reading: ", "Reading all shops..");
        List<Shop> shops = db.getAllShops();

        for (Shop shop : shops) {
             log = "Id: " + shop.getId() + " ,Name: " + shop.getName() + " ,Address: " + shop.getAddress();
            // Writing shops  to log
            Log.d("Shop: : ", log);
        }

        //Toast.makeText(MainActivity.this, log, Toast.LENGTH_LONG).show();*/




        //Button Creation/Instantiation
        instantiateButtons();

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.optionsBtn:
                Intent optionsIntent =new Intent(getApplicationContext(),OptionsActivity.class);
                startActivity(optionsIntent);
                break;

            case R.id.messageBtn:
               // Toast.makeText(MainActivity.this, "YOUR MESSAGE", Toast.LENGTH_LONG).show();
                break;

            case R.id.myFilesBtn:
                Intent myFilesIntent =new Intent(getApplicationContext(),MyFilesActivity.class);
                startActivity(myFilesIntent);
                break;

            case R.id.connectbtn:
                Intent wifiDirectIntent =new Intent(getApplicationContext(),WiFiDirectActivity.class);
                startActivity(wifiDirectIntent);
                break;

            default:
                break;
        }
    }

    public void instantiateButtons()
    {
        Button optionsBtn;
        optionsBtn = (Button) findViewById(R.id.optionsBtn);
        optionsBtn.setOnClickListener(this);

        Button messageFileBtn;
        messageFileBtn = (Button) findViewById(R.id.messageBtn);
        messageFileBtn.setOnClickListener(this);

        Button myFilesBtn;
        myFilesBtn = (Button) findViewById(R.id.myFilesBtn);
        myFilesBtn.setOnClickListener(this);

        Button connectBtn;
        connectBtn = (Button) findViewById(R.id.connectbtn);
        connectBtn.setOnClickListener(this);
    }
}


/***************************************************************************************
 *    Title: aFileChooser
 *    Author: Paul Burke
 *    Date: 13 December 2016
 *    Availability: https://github.com/iPaulPro/aFileChooser
 *
 ***************************************************************************************/
