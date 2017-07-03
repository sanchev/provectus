package com.sanchev.provectus;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;

class InternetConnectionChecker extends AsyncTask {

    private Context context;

    InternetConnectionChecker(Context context) {
        this.context = context;
    }

    private boolean isConnectedToInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Network[] activeNetworks = connectivityManager.getAllNetworks();
            for (Network n : activeNetworks) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(n);
                if (networkInfo.isConnected())
                    return true;
            }
        } else {
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null)
                for (NetworkInfo networkInfo : allNetworkInfo)
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
        }
        return false;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        while (!isConnectedToInternet()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ((StartActivity) context).internetIsOk();
        return null;
    }
}