package com.example.weather.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.weather.M002_ChiTiet;
import com.example.weather.MainActivity;
import com.example.weather.R;
import com.example.weather.entities.Weather;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class M002HumFrament extends Basefragment{
    public static final String TAG = M002HumFrament.class.getName();
    private List<Weather> weathers;
    private TextView tvTodayHum, tvTororrowHum, tvAfterTormorrowHum;
    private LinearLayout llToday, llTomo, llAfter;
    protected void initView() {
        tvTodayHum= findViewById(R.id.tv_today_hum);
        tvTororrowHum=findViewById(R.id.tv_tomorrow_hum);
        tvAfterTormorrowHum=findViewById(R.id.tv_after_tomorrow_hum);

        llAfter= findViewById(R.id.ll_hum_after);
        llToday= findViewById(R.id.ll_humToday);
        llTomo= findViewById(R.id.ll_humTomorrow);

        dataHum(city);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frg_hum;
    }


    @Override
    public void onClick(View view){
    }

    @Override
    public void backToPrevious() {

    }

    public void dataHum(String city) {
        String url = "https://wttr.in/" + city + "?format=j1";
        OkHttpClient client = new OkHttpClient();
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, Weather.class);
        final JsonAdapter<List<Weather>> jsonAdapter = moshi.adapter(usersType);
        // Tạo request lên server.
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Thực thi request.
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("Error", "Network Error");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string();
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(data);
                    String weather = jsonObject.getString("weather");
                    weathers = jsonAdapter.fromJson(weather);
                    Log.i("TAG", weathers.toString());
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvTodayHum.setText(weathers.get(0).getHourly().get(0).getHumidity()+"%");
                            tvTororrowHum.setText(weathers.get(1).getHourly().get(1).getHumidity()+"%");
                            tvAfterTormorrowHum.setText(weathers.get(2).getHourly().get(2).getHumidity()+"%");
                            llAfter.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent= new Intent();
                                    intent.putExtra("AAA", 2);
                                    intent.setClass(mContext, M002_ChiTiet.class);
                                    intent.putExtra("CITY",city);
                                    startActivity(intent);
                                }
                            });
                            llTomo.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent= new Intent();
                                    intent.putExtra("AAA", 1);
                                    intent.setClass(mContext, M002_ChiTiet.class);
                                    intent.putExtra("CITY",city);
                                    startActivity(intent);
                                }
                            });
                            llToday.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent= new Intent();
                                    intent.putExtra("AAA", 0);
                                    intent.setClass(mContext, M002_ChiTiet.class);
                                    intent.putExtra("CITY",city);
                                    startActivity(intent);
                                }
                            });
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
