package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.weather.entities.CurrentCondition;
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

public class M002_ChiTiet extends AppCompatActivity {
    TextView tvFog,tvOverCast, tvRain, tvThunder, tvSunShine, tvWindy, tvSunset, tvSunrise, tvMoonSet, tvMoonrise, tvMoonIllu, tvVisibility, tvUV;
    TextView tvHum1,tvHum2,tvHum3,tvHum4,tvHum5,tvHum6,tvHum7,tvHum8;
    TextView tvTepm1,tvTepm2,tvTepm3,tvTepm4,tvTepm5,tvTepm6,tvTepm7,tvTepm8;
    int day;
    private List<Weather> weathers;
    private List<CurrentCondition> currentConditions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m002);

        initView();
        Intent intent= getIntent();
        String city= (String) intent.getSerializableExtra("CITY");
        data(city);
    }

    private void initView() {
        Intent intent= getIntent();
        day= (int) intent.getSerializableExtra("AAA");
        tvRain=findViewById(R.id.tv_chace_rain);
        tvOverCast=findViewById(R.id.tv_chace_overCast);
        tvThunder=findViewById(R.id.tv_chace_thunder);
        tvWindy=findViewById(R.id.tv_chace_windy);
        tvSunShine=findViewById(R.id.tv_chace_sunshine);
        tvUV= findViewById(R.id.tv_uvIndex);
        tvVisibility=findViewById(R.id.tv_visibility);
        tvSunset=findViewById(R.id.tv_time_sunset);
        tvSunrise=findViewById(R.id.tv_time_sunrise);
        tvMoonrise=findViewById(R.id.tv_time_moonrise);
        tvMoonSet=findViewById(R.id.tv_time_moonset);
        tvMoonIllu=findViewById(R.id.tv_moon_illumination);
        tvFog=findViewById(R.id.tv_chace_fog);
        tvHum1=findViewById(R.id.tv_hum1);
        tvHum2=findViewById(R.id.tv_hum2);
        tvHum3=findViewById(R.id.tv_hum3);
        tvHum4=findViewById(R.id.tv_hum4);
        tvHum5=findViewById(R.id.tv_hum5);
        tvHum6=findViewById(R.id.tv_hum6);
        tvHum7=findViewById(R.id.tv_hum7);
        tvHum8=findViewById(R.id.tv_hum8);
        tvTepm1= findViewById(R.id.tv_temp1);
        tvTepm2= findViewById(R.id.tv_temp2);
        tvTepm3= findViewById(R.id.tv_temp3);
        tvTepm4= findViewById(R.id.tv_temp4);
        tvTepm5= findViewById(R.id.tv_temp5);
        tvTepm6= findViewById(R.id.tv_temp6);
        tvTepm7= findViewById(R.id.tv_temp7);
        tvTepm8= findViewById(R.id.tv_temp8);
    }

    private void data(String city){
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
                    Log.i("TAG2", weathers.toString());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvFog.setText(weathers.get(day).getHourly().get(0).getChanceoffog() + "%");
                            tvRain.setText(weathers.get(day).getHourly().get(0).getChanceofrain() + "%");
                            tvSunShine.setText(weathers.get(day).getHourly().get(0).getChanceofsunshine() + "%");
                            tvOverCast.setText(weathers.get(day).getHourly().get(0).getChanceofovercast() + "%");
                            tvThunder.setText(weathers.get(day).getHourly().get(0).getChanceofthunder() + "%");
                            tvWindy.setText(weathers.get(day).getHourly().get(0).getChanceofwindy() + "%");
                            tvUV.setText(weathers.get(day).getHourly().get(5).getUvIndex());
                            tvVisibility.setText(weathers.get(day).getHourly().get(0).getVisibility());

                            tvSunrise.setText(weathers.get(day).getAstronomy().get(0).getSunrise());
                            tvSunset.setText(weathers.get(day).getAstronomy().get(0).getSunset());
                            tvMoonSet.setText(weathers.get(day).getAstronomy().get(0).getMoonset());
                            tvMoonrise.setText(weathers.get(day).getAstronomy().get(0).getMoonrise());
                            tvMoonIllu.setText(weathers.get(day).getAstronomy().get(0).getMoon_illumination()+"%");
                            tvHum1.setText(weathers.get(day).getHourly().get(0).getHumidity()+"%");
                            tvHum2.setText(weathers.get(day).getHourly().get(1).getHumidity()+"%");
                            tvHum3.setText(weathers.get(day).getHourly().get(2).getHumidity()+"%");
                            tvHum4.setText(weathers.get(day).getHourly().get(3).getHumidity()+"%");
                            tvHum5.setText(weathers.get(day).getHourly().get(4).getHumidity()+"%");
                            tvHum6.setText(weathers.get(day).getHourly().get(5).getHumidity()+"%");
                            tvHum7.setText(weathers.get(day).getHourly().get(6).getHumidity()+"%");
                            tvHum8.setText(weathers.get(day).getHourly().get(7).getHumidity()+"%");
                            tvTepm1.setText(weathers.get(day).getHourly().get(0).getTempC()+"°C");
                            tvTepm2.setText(weathers.get(day).getHourly().get(1).getTempC()+"°C");
                            tvTepm3.setText(weathers.get(day).getHourly().get(2).getTempC()+"°C");
                            tvTepm4.setText(weathers.get(day).getHourly().get(3).getTempC()+"°C");
                            tvTepm5.setText(weathers.get(day).getHourly().get(4).getTempC()+"°C");
                            tvTepm6.setText(weathers.get(day).getHourly().get(5).getTempC()+"°C");
                            tvTepm7.setText(weathers.get(day).getHourly().get(6).getTempC()+"°C");
                            tvTepm8.setText(weathers.get(day).getHourly().get(7).getTempC()+"°C");
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}