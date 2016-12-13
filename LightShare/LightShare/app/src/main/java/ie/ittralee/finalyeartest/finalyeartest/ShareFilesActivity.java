package ie.ittralee.finalyeartest.finalyeartest;


import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ipaulpro.afilechooser.utils.FileUtils;

import java.net.URLConnection;


public class ShareFilesActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "ShareFilesActivity";
    TextView mTextView = null;
    String mimeType = null;

    private static final int REQUEST_CODE = 6384; // onActivityResult request
    // code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_files);

        Button chooseFile;
        chooseFile = (Button) findViewById(R.id.chooseFileBtn);
        chooseFile.setOnClickListener(this);

        Button previewBtn;
        previewBtn = (Button) findViewById(R.id.previewBtn);
        previewBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.chooseFileBtn:
                showChooser();
                break;

            case R.id.previewBtn:
                String input = mTextView.getText().toString();
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setAction(Intent.ACTION_VIEW);



                String type = mimeType;
                Toast.makeText(ShareFilesActivity.this, "Type3: " + type, Toast.LENGTH_LONG).show();

                intent.setDataAndType(Uri.parse(input),type);
                if(type == "audio/mpeg")
                {
                    MediaPlayer mediaPlayer = MediaPlayer.create(this, Uri.parse(type));
                    mediaPlayer.start();
                }
                startActivity(intent);
                Toast.makeText(ShareFilesActivity.this, input, Toast.LENGTH_LONG).show();
                Toast.makeText(ShareFilesActivity.this, "Type1: " + mimeType, Toast.LENGTH_LONG).show();



                break;

            default:
                break;
        }

    }

    private void showChooser() {
        // Use the GET_CONTENT intent from the utility class
        Intent target = FileUtils.createGetContentIntent();
        // Create the chooser Intent
        Intent intent = Intent.createChooser(
                target, getString(R.string.chooser_title));
        try {
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            // The reason for the existence of aFileChooser
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            switch (requestCode) {
                case REQUEST_CODE:
                    // If the file selection was successful
                    if (resultCode == RESULT_OK) {
                        if (data != null) {
                            // Get the URI of the selected file
                            final Uri uri = data.getData();
                            mimeType = getContentResolver().getType(uri);
                            Toast.makeText(ShareFilesActivity.this, "Type2: " + mimeType, Toast.LENGTH_LONG).show();
                            Log.i(TAG, "Uri = " + uri.toString());
                            mTextView = (TextView) findViewById(R.id.fileNameTextView);
                            mTextView.setText(uri.toString());
                           // mimeType = getContentResolver().getType(uri);

                            mimeType = returnMimeType(uri);
                            Toast.makeText(ShareFilesActivity.this, "Check: " + mimeType, Toast.LENGTH_LONG).show();
                            try {
                                // Get the file path from the URI
                                final String path = FileUtils.getPath(this, uri);
                            } catch (Exception e) {
                                Log.e("ShareFilesActivity", "File Select Error", e);
                            }
                        }
                    }

                    break;
            }

            super.onActivityResult(requestCode, resultCode, data);
        }


    public String returnMimeType(Uri uri)
    {
        String mimeType3 = null;
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            ContentResolver cr = getApplicationContext().getContentResolver();
            mimeType3 = cr.getType(uri);
        } else {
            String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri
                    .toString());
            mimeType3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                    fileExtension.toLowerCase());
        }
        return mimeType3;
    }


}
