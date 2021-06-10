package com.aoslec.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MemberInfo extends SQLiteOpenHelper {

    public MemberInfo(Context context){
        // 화면이 여기에 없기에 메인에서 불러써야 하기에 context 필요
        super(context, "MemberInfo.db", null, 1);
        // MemberInfo.db - db 이름, 1 - version
    }

    // 앱을 새로 설치하거나 버전이 업로드 되지 않은 경우 onCreate나 onUpgrade 메소드 사용 안됨
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 처음에 앱을 설치할 때 메소드 실행 (이후 실행 안됨)
        String query = "CREATE TABLE member(id INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, userid TEXT, passwd INTEGER);";
        // varchar없이 text 사용
        db.execSQL(query); // 쿼리를 실행해라!
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 앱 버전이 업로드 되거나 다시 앱을 설치하는 경우 실행
        String query = "DROP TABLE IF EXISTS member";
        db.execSQL(query);
        onCreate(db); // 그렇기 때문에 백업이 안됨 (지우고 다시 설치하면 다 지워짐)
    }
}
