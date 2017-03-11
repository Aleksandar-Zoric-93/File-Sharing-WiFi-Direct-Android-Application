package ie.ittralee.finalyeartest.finalyeartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Aleks on 16/02/2017.
 */

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options_main);

        Button settingsBtn;
        settingsBtn = (Button) findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(this);

        Button aboutBtn;
        aboutBtn = (Button) findViewById(R.id.aboutBtn);
        aboutBtn.setOnClickListener(this);
    }

    public void setDeviceName(String devName) {


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.settingsBtn:
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
                break;

            case R.id.aboutBtn:
                Toast.makeText(OptionsActivity.this, "YOUR MESSAGE", Toast.LENGTH_LONG).show();

            default:
                break;
        }
    }
}
