package com.warmit.stoeff.warmitclient.util;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class PermissionUtils {

    public static final int INTERNET_PERMISSIONS_REQUEST_CODE = 1232;

    public static boolean checkInternerPermissions(final Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.INTERNET)) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Internet access");
                builder.setMessage("This will be used to communicate with the server");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        requestInternetPermission(activity);
                    }
                });
                builder.setCancelable(true)
                        .create()
                        .show();
            }else {
                requestInternetPermission(activity);
            }
            return false;
        }
        return true;
    }

    private static void requestInternetPermission(Activity activity) {
        ActivityCompat.requestPermissions(activity, new String[] {Manifest.permission.INTERNET}, INTERNET_PERMISSIONS_REQUEST_CODE);
    }
}
