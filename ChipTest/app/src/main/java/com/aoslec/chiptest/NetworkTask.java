package com.aoslec.chiptest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<ChipBean> chipBeans = null;
    String where = null;

    public NetworkTask(Context context, String mAddr, String where){
        this.context = context;
        this.mAddr = mAddr;
        this.chipBeans = chipBeans;
        this.chipBeans = new ArrayList<ChipBean>();
        this.where = where;
    }

    @Override
    protected void onPreExecute() {
        Log.v("Message", "onPreExecute");
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialog");
        progressDialog.setMessage("Get.....");
        progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        progressDialog.dismiss();
    }

    @Override
    protected Object doInBackground(Integer... integers) {
        Log.v("Message", "doInBackground");
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        // 입력 수정 삭제 검색했을 때 잘했는지 아닌지를 result에 받아서 처리할 것임
        String result = null;

        try {
//            mAddr = URLEncoder.encode(mAddr, "UTF-8");
            URL url = new URL(mAddr);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            Log.v("Message", "if 전  : " + httpURLConnection.getResponseCode());

            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                // 연결되었다면!!
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                Log.v("Message", "while 전");

                while (true){
                    String strLine = bufferedReader.readLine();
                    if(strLine == null) break;
                    stringBuffer.append(strLine + "\n");
                }
                Log.v("Message", "if 전");

                Log.v("Message", where);
                if (where.equals("insert")){
                    // return 값이 존재하지 않음
                    // select의 경우
                    Log.v("Message", "NetworkTask1 : " + result);
                    Log.v("Message", stringBuffer.toString());
                    result = parserAction(stringBuffer.toString());
                    Log.v("Message", "NetworkTask1 : " + result);

                }else {
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(bufferedReader != null) bufferedReader.close();
                if(inputStreamReader != null) inputStreamReader.close();
                if(inputStream != null) inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(where.equals("insert")){
            Log.v("Message", "NetworkTask3 : " + result);
            return result;
        } else {
            Log.v("Message", "NetworkTask4 : " + result);
            return result;
        }
    }

    private String parserAction(String str){
        String returnValue = null;
        Log.v("Message", "parser");
        try {
            JSONObject jsonObject = new JSONObject(str);
            returnValue = jsonObject.getString("result");
            Log.v("Message", returnValue);
            // {"result" : "ok"} 이런걸 서버에서 받아온다는 것임
        }catch (Exception e){
            e.printStackTrace();
        }
        Log.v("Message", returnValue);
        return returnValue;
    }

    private void parserSelect(String str){
        try {
            Log.v("Message", "parserSelect");
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("chips_info"));
            chipBeans.clear();

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String chipBean1 = jsonObject1.getString("chipBean1");

                ChipBean chipBean = new ChipBean(chipBean1);
                chipBeans.add(chipBean);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
