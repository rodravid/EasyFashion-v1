package com.experience.totvs.easyfashion_v1.domain.user.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.experience.totvs.easyfashion_v1.R;
import com.experience.totvs.easyfashion_v1.domain.user.User;
import com.experience.totvs.easyfashion_v1.domain.user.UserFactory;
import com.google.zxing.Result;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class UserScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;
    private UserFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_scanner);

        factory = new UserFactory();

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
//"{ "_id": 206, "age": 27, "name": "Mcmillan Yates", "gender": "male", "style": "Hippie" }";
            mScannerView.stopCamera();

            User user = factory.makeFromJsonObject(result.getText());

            Log.v("handleResult", String.format("Read from QRCode - %s", user.getName()));
            Log.v("handleResult", result.getText());

            Intent intent = new Intent();
            intent.putExtra("user", user);
            setResult(RESULT_OK, intent);
            finish();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
