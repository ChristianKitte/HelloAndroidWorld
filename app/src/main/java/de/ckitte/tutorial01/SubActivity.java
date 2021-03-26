package de.ckitte.tutorial01;

import android.app.AlertDialog;
import android.content.DialogInterface;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
    }

    public void btnInternetPressed(View v) {
        //impliziter Intent
        Intent myIntent = new Intent(Intent.ACTION_VIEW);
        myIntent.setData(Uri.parse("http://www.ckitte.de"));
        startActivity(myIntent);
    }

    public void btnClosePressed(View v) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(SubActivity.this);
        dialog.setCancelable(false);

        dialog.setTitle(getResources().getText(R.string.appCloseTitle));
        dialog.setMessage(getResources().getText(R.string.appCloseMessage));

        dialog.setPositiveButton(getResources().getText(R.string.appRunText), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing. Positive means go on...
            }
        });

        dialog.setNegativeButton(getResources().getText(R.string.appCloseText), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Close the App. Negative means shut down...
                SubActivity.this.finish();
            }
        });

        dialog.show();
    }
}
