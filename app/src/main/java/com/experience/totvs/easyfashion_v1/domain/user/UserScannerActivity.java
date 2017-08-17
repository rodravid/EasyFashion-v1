package com.experience.totvs.easyfashion_v1.domain.user;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.experience.totvs.easyfashion_v1.R;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class UserScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private UserFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_scanner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        factory = new UserFactory();
    }

    public void onClick(View v) {
        mScannerView = new ZXingScannerView(this);
        setContentView(mScannerView);
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void handleResult(Result result) {
        try {
//"{ \"_id\": 206, \"age\": 27, \"name\": \"Mcmillan Yates\", \"gender\": \"male\", \"style\": \"Hippie\" }";
            User user = factory.makeFromJsonObject(result.getText());

            Log.v("handleResult", String.format("Read from QRCode - %s", user.getName()));

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Scan Result");
            alertDialogBuilder.setMessage(user.getName());
            alertDialogBuilder.create().show();

        } catch(Exception e) {
            e.printStackTrace();
        }

        mScannerView.stopCamera();
        setContentView(R.layout.activity_product_scanner);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
