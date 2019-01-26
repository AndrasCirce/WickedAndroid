package com.example.android.scanner1;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

import static android.content.ContentValues.TAG;

public class SimpleScannerActivity extends Activity implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;
    private TextView Final;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        //Intent intent = new Intent(this, MainActivity.class);
        //startActivity(intent);
       // Log.v(TAG, rawResult.getContents()); // Prints scan results
       // Log.v(TAG, rawResult.getBarcodeFormat().getName()); // Prints the scan format (qrcode, pdf417 etc.)

        // If you would like to resume scanning, call this method below:
       // mScannerView.resumeCameraPreview(this);

        //-----------------------------------------------------------------------------------------

        final String code = rawResult.getContents();
        final String format = rawResult.getBarcodeFormat().getName();
        final String fullMessage = "Contiene: "+code+", en formato: "+format;

        try{
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
            r.play();
        } catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage());
        }
        showMessageDialog(fullMessage);
    }


    public void showMessageDialog(String message){
       // DialogFragment fragment = MessageDialogFragment.newInstance("scan Results", message, this);
        // fragment.show(getSupportFragmentManager(), "");
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    //@Override
    public void onDialogPositiveClick(DialogFragment dialog){
        mScannerView.resumeCameraPreview(this);
    }
}

