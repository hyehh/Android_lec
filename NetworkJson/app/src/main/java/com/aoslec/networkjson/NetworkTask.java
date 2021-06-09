package com.aoslec.networkjson;

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
    // async 내용을 상속받을 것임
    // <Params, Progress, Result>

    // 전역변수 많이 쓰기!
    Context context = null;
    // http://102.~ :8080~ 이 주소임
    String mAddr = null;
    ProgressDialog progressDialog = null;
    // 우리가 만든 Bean
    ArrayList<JsonMember> members = null;

    public NetworkTask(Context context, String mAddr){
        // context는 activity
        // 내 context에 받아온 context 넣어준다
        this.context = context;
        // 메인 액티비티가 mAddr 를 줄 것임!
        this.mAddr = mAddr;
        this.members = new ArrayList<JsonMember>();
        // 여기까지 데이터 담을 준비 완료
    }

    // 뺑뺑이 돌리는 thread와 데이터 가져오는 thread 동시 실행하고자 함

    // 뺑뺑이 돌리는 다이얼로그 띄우는 것임
    @Override
    protected void onPreExecute() {
        // ()안에는 어디서 돌 것이냐에 들어갈 것
        progressDialog = new ProgressDialog(context);
        // 어떤 모양으로 할 것인지 결정
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Dialog");
        progressDialog.setMessage("down...");
        progressDialog.show();
    }

    // 일 끝났으면 끝났다고 이제 뺑뺑이 그만돌라고 정의하는 것
    @Override
    protected void onProgressUpdate(String... values) {
        // 바뀌는 데이터 진행 중
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        // 끝났다는 신호 줌
        super.onPostExecute(o);
        // 이제 일 끝났으니까 뺑뺑이 그만보이게 해줘라
        progressDialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        // 하다가 오류 걸리게 될 경우
        super.onCancelled();
    }

    @Override
    protected Object doInBackground(Integer... integers) { // object 안에 string, int 이런거 다 들어있음
        // 백그라운드 돌릴 때 무엇을 할 것인지 메소드
        // Integer... 이게 배열의 의미임 (데이터 1개일 때, 여러 개 일 때 등 다양하기 때문에 이렇게 요즘 적음) int[] 이거 아니고 Integer... 요즘 스타일
        StringBuffer stringBuffer = new StringBuffer();
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            // 메인에서 받은 url = mAddr
            // url은 어디로 가겠다 받겠다 까지 같이 정의해서 주기 때문에 url 타입 사용
            URL url = new URL(mAddr);
            // 연결하는 것임 (http 프로토콜로 연결한 것이다)
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            // 10초 동안 연결 시도 (무한정 연결할 수 없기 때문에 최대 시간 설정)
            httpURLConnection.setConnectTimeout(10000);

            // 연결 잘되었으면 신호를 보내줘야 함 (100- 처리 됐다 200- 끝냈~ 이런 숫자들 정의해준 것들이 있음)
            if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                // 연결됐다
                inputStream = httpURLConnection.getInputStream();
                // 데이터가 여러개 있는데 하나 씩 가져옴 -> 이걸 reader로 통해 한 번에 넣어줌
                inputStreamReader = new InputStreamReader(inputStream);
                // bufferedReader 여기에 넣어줘야 한 줄 띄기 이런 것들이 있음
                bufferedReader = new BufferedReader(inputStreamReader);

                while (true){
                    // 조건문이 없고 true면 break 꼭 해줘야 함!!!!
                    String strLine = bufferedReader.readLine();
                    if(strLine == null) break;
                    // 읽을 게 있으면 strLine 올리고 한 줄 띄기 작업할 것
                    stringBuffer.append(strLine + "\n");
                }
                // 파싱 시작 (stringBuffer를 줘야함)
                parser(stringBuffer.toString());
                // members.clear(); 여기에 쓰면 절대 안됨! 파싱 끝나고 하면 안된다!
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                // 아까 불러온 것 거꾸로 정리하면 됨!
                // 정리 안하면 json 파일 두 개면 두 번째 파일에서 첫 번째 파일도 함께 불러오게 됨
                if(bufferedReader != null) bufferedReader.close();
                if(inputStreamReader != null) inputStreamReader.close();
                if(inputStream != null) inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        // object 안에 arraylist 있기 때문에 return arraylist 사용하는 게 좋음
        return members;
    }

    private void parser(String str){
        // str에 json 파일이 있는 것임 -> 이제 파싱해주면 됨!
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = new JSONArray(jsonObject.getString("members_info"));
            // 정리해주기 (arraylist 지우려고) - 혹시 전에 있던 게 같이 보일까봐 지우고 새롭게 받으려고 만든 것임
            // 위치는 상관없으나 파싱 전에 써야함
            members.clear();

            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                String name = jsonObject1.getString("name");
                int age = jsonObject1.getInt("age");
                // JsonMember에서 만든 arraylist
                ArrayList<String> hobbies = new ArrayList<String>();
                JSONArray jsonArray1 = jsonObject1.getJSONArray("hobbies");
                for(int j=0; j<jsonArray1.length(); j++){
                    String hobby = jsonArray1.getString(j);
                    hobbies.add(hobby);
                }
                JSONObject jsonObject2 = jsonObject1.getJSONObject("info");
                int no = jsonObject2.getInt("no");
                String id = jsonObject2.getString("id");
                String pw = jsonObject2.getString("pw");

                // json에 있는 거 arraylist에 넣었음!
                JsonMember member = new JsonMember(name, age, hobbies, no, id, pw);
                members.add(member);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
