package com.aoslec.imagedownload;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkTask extends AsyncTask<Integer, String, Integer> {

    final static String TAG = "NetworkTask";
    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    String devicePath;
    ImageView imageView;

    public NetworkTask(Context c, ImageView iv, String s) {
        this.context = c;
        this.imageView = iv;
        this.mAddr = s;
    }

    @Override
    protected void onPreExecute() {
        Log.v(TAG, "onPreExecute()");
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialogue");
        progressDialog.setMessage("down ....");
        progressDialog.show();
    }

    @Override
    protected Integer doInBackground(Integer... params) {
        Log.v(TAG, "doInBackground()");

        int index = mAddr.lastIndexOf("/");
        String imgName = mAddr.substring(index + 1);
        Log.v(TAG, "urlAddress : " + mAddr);
        Log.v(TAG, "index : " + index);
        Log.v(TAG, "image name : " + imgName);

        devicePath = Environment.getDataDirectory().getAbsolutePath() + "/data/com.aoslec.imagedownload/files/" + imgName;
        Log.v(TAG, "device path : " + devicePath);

        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            URL url = new URL(mAddr);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);

            int len = httpURLConnection.getContentLength();
            byte[] bs = new byte[len];

            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputStream = httpURLConnection.getInputStream();
                fileOutputStream = context.openFileOutput(imgName, 0);

                while (true){
                    int i = inputStream.read(bs);
                    if(i < 0) break;
                    fileOutputStream.write(bs, 0, i);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(inputStream != null) inputStream.close();
                if(fileOutputStream != null) fileOutputStream.close();

            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        Log.v(TAG, "onProgressUpdate()");
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPostExecute(Integer integer) {
        Log.v(TAG, "onPostExecute()");
        Bitmap bitmap = BitmapFactory.decodeFile(devicePath);
        imageView.setImageBitmap(bitmap);
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        Log.v(TAG,"onCancelled()");
        super.onCancelled();
    }

}
