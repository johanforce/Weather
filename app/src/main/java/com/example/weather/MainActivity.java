package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weather.entities.CurrentCondition;
import com.example.weather.entities.Root;
import com.example.weather.entities.Weather;
import com.example.weather.fragment.Basefragment;
import com.example.weather.fragment.M001TempFragment;
import com.example.weather.fragment.M002HumFrament;
import com.example.weather.fragment.M003WindFragment;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnMainCallback {
    public static final String TAG = MainActivity.class.getName();
    ImageView ivHum, ivWind, ivTemp;
    TextView tvCity, tvDate, tvTemp, tvStatus, tvBuoi;
    private List<CurrentCondition> currentConditions;
    private static final int LV_HUM_0=0;
    private static final int LV_HUM_1=1;
    private static final int LV_TEMP_0=0;
    private static final int LV_TEMP_1=1;
    private static final int LV_WIND_0=0;
    private static final int LV_WIND_1=1;
    private String currentTag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        dataWeather(tvCity.getText().toString());
    }

    private void initView() {
        ivHum=findViewById(R.id.iv_hum);
        ivHum.setOnClickListener(this);
        ivTemp=findViewById(R.id.iv_temp);
        ivTemp.setOnClickListener(this);
        ivWind=findViewById(R.id.iv_wind);
        ivWind.setOnClickListener(this);

        ivTemp.setImageLevel(LV_TEMP_1);

        tvCity=findViewById(R.id.tv_city);
        tvCity.setOnClickListener(this);
        showFrg(TAG, M001TempFragment.TAG,tvCity.getText().toString(),false);
        tvBuoi=findViewById(R.id.tv_buoi);
        tvDate=findViewById(R.id.tv_date);
        tvTemp=findViewById(R.id.tv_temperature);
        tvStatus=findViewById(R.id.tv_Status);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.tv_city){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            View view = getLayoutInflater().inflate(R.layout.item_city, null);
            dialog.setView(view);
            dialog.setTitle("Thành phố");

            dialog.setMessage("Xin moi ban nhap thành phố:");
            dialog.setPositiveButton("Luu", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    EditText editText = view.findViewById(R.id.et_ten);
                    tvCity.setText(editText.getText());
                    dataWeather(tvCity.getText().toString());
                    showFrg(TAG, M001TempFragment.TAG,tvCity.getText().toString(),false);
                    ivTemp.setImageLevel(1);
                    ivHum.setImageLevel(0);
                    ivWind.setImageLevel(0);
                }
            });
            dialog.setNegativeButton("Huy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog alert = dialog.create();
            alert.getWindow().setBackgroundDrawableResource(R.drawable.alert);
            alert.show();
        }
        if(v.getId()==R.id.iv_hum){
                ivHum.setImageLevel(LV_HUM_1);
                ivWind.setImageLevel(LV_WIND_0);
                ivTemp.setImageLevel(LV_TEMP_0);
            showFrg(TAG, M002HumFrament.TAG,tvCity.getText().toString(),false);
        }
        if(v.getId()==R.id.iv_temp){
            ivHum.setImageLevel(LV_HUM_0);
            ivTemp.setImageLevel(LV_TEMP_1);
            ivWind.setImageLevel(LV_WIND_0);
            showFrg(TAG, M001TempFragment.TAG,tvCity.getText().toString(),false);
        }
        if(v.getId()==R.id.iv_wind){
            ivHum.setImageLevel(LV_HUM_0);
            ivTemp.setImageLevel(LV_TEMP_0);
            ivWind.setImageLevel(LV_WIND_1);
            showFrg(TAG, M003WindFragment.TAG,tvCity.getText().toString(),false);
        }
    }


    @Override
    public void showFrg(String sourceTag, String tag, boolean isMoveBack) {
        showFrg(sourceTag, tag,null,isMoveBack);
    }

    @Override
    public void showFrg(String sourceTag, String tag, Object data,boolean isMoveBack) {
        showFrg(sourceTag, tag,null,isMoveBack);
    }

    public void showFrg(String sourceTag,String tag,String city,  boolean isMoveBack) {
        try {
            //tao doi tuong moi gan thuoc tinh cho no, khong can phai goi
            Class<?> clazz = Class.forName(tag);
            Constructor<?> constructor = clazz.getConstructor();
            Basefragment frg = (Basefragment) constructor.newInstance();
            frg.setCallBack(this);
            frg.setSourceTag(sourceTag);
            frg.setCity(city);
            FragmentTransaction ts = getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.ll_forecast, frg, tag);
            currentTag= tag;
            if (isMoveBack) {
                ts.addToBackStack(null);
            }
            ts.commit();
        }catch (Exception e){
            e.printStackTrace();
        }
//        if (tag.equals(M001HomeFragment.TAG)) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.ln_main, m001Homefrg, tag)
//                    .commit();
//
//        } else if (tag.equals(M002ListFrament.TAG)) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.ln_main, m002Homefrg, tag)
//                    .commit();
//        }
    }

    @Override
    public void closeApp() {
        finish();
    }

    @Override
    public void onBackPressed() {
        Basefragment frg= (Basefragment) getSupportFragmentManager().findFragmentByTag(currentTag);
        frg.backToPrevious();
    }

    public void dataWeather(String city){
        tvCity.setText(city);
        String url="https://wttr.in/"+city+"?format=j1";
        OkHttpClient client = new OkHttpClient();
        Moshi moshi = new Moshi.Builder().build();
        Type usersType = Types.newParameterizedType(List.class, CurrentCondition.class);
        final JsonAdapter<List<CurrentCondition>> jsonAdapter = moshi.adapter(usersType);
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
                JSONObject jsonObject= null;
                try {
                    jsonObject = new JSONObject(data);
                    Log.i("TAG", data);
                    String current_condition = jsonObject.getString("current_condition");
                    currentConditions= jsonAdapter.fromJson(current_condition);
                    Log.i("TAG", currentConditions.toString());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvDate.setText(currentConditions.get(0).getLocalObsDateTime());
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Partly cloudy")) {
                                tvStatus.setText("Có mây");
                            }
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("OverCast")) {
                                tvStatus.setText("Âm u");
                            }
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Cloudy")) {
                                tvStatus.setText("Nhiều mây");
                            }
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Light rain shower")) {
                                tvStatus.setText("Nhiều mây");
                            }
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Mưa rào nhẹ")) {
                                tvStatus.setText("Nhiều mây");
                            }
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Patchy rain possible")) {
                                tvStatus.setText("Mưa rải rác");
                            } if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Light drizzle")) {
                                tvStatus.setText("Mưa phùn nhẹ");
                            }
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Moderate rain")) {
                                tvStatus.setText("Mưa vừa");
                            }
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Light rain")) {
                                tvStatus.setText("Mưa nhỏ");
                            }
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Sunny")) {
                                tvStatus.setText("Trời nắng");
                            }
                            if(currentConditions.get(0).getWeatherDesc().get(0).getValue().equals("Clear")) {
                                tvStatus.setText("Trong xanh");
                            }


                            tvTemp.setText(currentConditions.get(0).getTemp_C()+"°C");
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}