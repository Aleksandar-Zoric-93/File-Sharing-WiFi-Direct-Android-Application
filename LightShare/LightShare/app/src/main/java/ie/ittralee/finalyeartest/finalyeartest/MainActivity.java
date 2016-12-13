package ie.ittralee.finalyeartest.finalyeartest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        // Inserting Shop/Rows
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

        //Button Creation/Instantiation
        instantiateButtons();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.shareFilesBtn:
                Intent intent =new Intent(getApplicationContext(),ShareFilesActivity.class);
                startActivity(intent);
                break;

            case R.id.messageBtn:
                Toast.makeText(MainActivity.this, "YOUR MESSAGE", Toast.LENGTH_LONG).show();
                break;

            case R.id.myFilesBtn:
                // do your code
                break;

            case R.id.connectbtn:
                // do your code
                break;

            default:
                break;
        }
    }

    public void instantiateButtons()
    {
        Button shareFilesBtn;
        shareFilesBtn = (Button) findViewById(R.id.shareFilesBtn);
        shareFilesBtn.setOnClickListener(this);

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
