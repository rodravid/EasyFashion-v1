package com.experience.totvs.easyfashion_v1;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import org.json.JSONObject;

public class ProductScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_scanner);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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
//            String json = "{ \"_id\": 206, \"age\": 27, \"name\": \"Mcmillan Yates\", \"gender\": \"male\", \"email\": \"mcmillanyates@isoswitch.com\" }";
            String json = result.getText();
            JSONObject jsonParsed = new JSONObject(result.getText());

            Log.v("handleResult", json);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("Scan Result");
            alertDialogBuilder.setMessage(jsonParsed.getString("name"));
            alertDialogBuilder.create().show();

        } catch(Exception e) {
            e.printStackTrace();
        }

        mScannerView.stopCamera();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
