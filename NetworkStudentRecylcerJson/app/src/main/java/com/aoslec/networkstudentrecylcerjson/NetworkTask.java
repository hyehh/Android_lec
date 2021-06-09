package com.aoslec.networkstudentrecylcerjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class NetworkTask extends AsyncTask<Integer, String, Object> {

    // 전역변수 선언
    Context context = null;
    String mAddr = null;
    ProgressDialog progressDialog = null;
    ArrayList<Students> students = null;

    public NetworkTask(Context context, String mAddr){
        this.context = context;
        this.mAddr = mAddr;
        this.students = new ArrayList<Students>();
    }

    // progressdialog 시작
    @Override
    protected void onPreExecute() { // progressdialog 모양 만들어 주기
        progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialog");
        progressDialog.setMessage("로딩 중입니다!");
        progressDialog.show();
    }

    @Override
    protected void onProgressUpdate(String... values) { // 바뀌는 데이터 진행중일 때 메소드
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) { // 데이터 업데이트 끝났다고 알려줌
        super.onPostExecute(o);
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() { // 오류 났을 때
        super.onCancelled();
    }

    // 데이터 가져오기 작업 시작
    @Override
    protected Object doInBackground(Integer... integers) {

        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {

            // url 설정 (어디로 가겠다 받겠다 정의해주기 위해 사용)
            URL url = new URL(mAddr);
            // http 프로토콜 연결
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // 최대 연결 시간 설정 (10초 이상 지나면 오류로 판단해 중지)
            httpURLConnection.setConnectTimeout(10000);

            // 연결 성공 시 신호 보내주기
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputStream = httpURLConnection.getInputStream();
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true){
                    String strLine = bufferedReader.readLine();
                    if(strLine == null) break; // 읽을 게 없으면 나와라
                    stringBuffer.append(strLine + "\n"); // "\n" 크게 상관은 없는데 그냥 쓰자
                }
                // 파싱 시작
                parser(stringBuffer.toString());
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
        // parser에서 가져옴
        return students;
    }

    private void parser(String str){
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("students_info"));

            students.clear();

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String code = jsonObject1.getString("code");
                String name = jsonObject1.getString("name");
                String dept = jsonObject1.getString("dept");
                String phone = jsonObject1.getString("phone");

                Students student = new Students(code, name, dept, phone);
                students.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
