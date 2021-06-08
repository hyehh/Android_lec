package com.aoslec.datajson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "Status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parser();
    }

    private void parser(){
        // jsonex 를 가져오기 (파일에서 불러오기 때문에 필요/서버에서 불러오면 불필요함)
        Log.v(TAG, "parser()");
        InputStream inputStream = getResources().openRawResource(R.raw.jsonex);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 데이터는 지금 bufferedReader에 있다

        // arraylist 같은 것 (데이터 쌓으려고 함)
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line);
            }
            Log.v(TAG, "StringBuffer : " + stringBuffer.toString());

            // 여기서부터 정말 제이슨 시작 (파싱 시작)
            // 제이슨파일 하나 생성
            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            // members_info로 가서 세트씩 하나 묶어 처리함
            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));
            for (int i=0; i<jsonArray.length(); i++){
                // 반복하면서 출력하겠다
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String name = jsonObject1.getString("name");
                Log.v(TAG, "name : " + name);
                int age = jsonObject1.getInt("age");
                Log.v(TAG, "age : " + age);
                JSONArray jsonArray1 = jsonObject1.getJSONArray("hobbies");
                for(int j=0; j <jsonArray1.length(); j++){
                    String hobby = jsonArray1.getString(j);
                    Log.v(TAG, "hobby : " + hobby);
                }
                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                int no = jsonObject2.getInt("no");
                Log.v(TAG, "no : " + no);
                String id = jsonObject2.getString("id");
                Log.v(TAG, "id : " + id);
                String pw = jsonObject2.getString("pw");
                Log.v(TAG, "pw : " + pw);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                // 우리가 썼기 때문에 not null -> 그래서 닫아주는 거다
                if(inputStream != null) inputStream.close();
                if(inputStreamReader != null) inputStreamReader.close();
                if(bufferedReader != null) bufferedReader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}