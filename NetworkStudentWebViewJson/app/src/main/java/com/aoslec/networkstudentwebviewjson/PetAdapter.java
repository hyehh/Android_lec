package com.aoslec.networkstudentwebviewjson;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.ViewHolder> {

    private Context mContext = null;
    private int layout = 0;
    private ArrayList<Pets> pets = null;
    private LayoutInflater inflater = null;

    public PetAdapter(Context mContext, int layout, ArrayList<Pets> pets) {
        this.mContext = mContext;
        this.layout = layout;
        this.pets = pets;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public WebView webView;
        public TextView tv_name, tv_age, tv_gender;

        public ViewHolder(View petView){
            super(petView);
            webView = petView.findViewById(R.id.webview);
            tv_name = petView.findViewById(R.id.tv_name);
            tv_age = petView.findViewById(R.id.tv_age);
            tv_gender = petView.findViewById(R.id.tv_gender);

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(false);

            petView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(petView, pets.get(position).getName() + " is Clicked!", Snackbar.LENGTH_SHORT).setAction("", null).show();
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("Message","hihi");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_web_view, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PetAdapter.ViewHolder holder, int position) {
        Log.v("Message","hihi");
        holder.webView.loadData(htmlData(pets.get(position).getImages()), "text/html", "UTF-8");
        holder.tv_name.setText("Name : " + pets.get(position).getName());
        holder.tv_age.setText("Age : " + pets.get(position).getAge());
        holder.tv_gender.setText("Gender : " + pets.get(position).getGender());
    }

    @Override
    public int getItemCount() {
        Log.v("Message", String.valueOf(pets.size()));
        return pets.size();
    }

    public String htmlData(String location){
        String htmlData = "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>Insert title here</title>\n" +
                "</head>\n" +
                "<body>\n <img src=\"http://192.168.0.2:8080/test/" +location+ "\" width =\"auto\" height=\"120%\"> </body>\n" +
                "</html>";
        return htmlData;
    }

}
