package com.cjmkeke.d2rbooks.itemdatabase.information;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentUberBinding;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Uber extends Fragment {

    private final String TAG = "Uber";
    private SharedPreferences fontSharedPreferences;
    private FragmentUberBinding mBinding;
    private final String ASIA_LADDER_SOFTCORE_MESSAGE = "아시아 래더 소프트코어 우버 디아 현황\n";
    private final String ASIA_LADDER_HARDCORE_MESSAGE = "아시아 래더 하드코어 우버 디아 현황\n";
    private final String ASIA_NONE_LADDER_SOFTCORE_MESSAGE = "아시아 NONE - 래더 소프트코어 우버 디아 현황\n";
    private final String ASIA_NONE_LADDER_HARDCORE_MESSAGE = "아시아 NONE - 래더 하드코어 우버 디아 현황\n";

    private final String AMERICA_LADDER_SOFTCORE_MESSAGE = "아메리카 래더 소프트코어 우버 디아 현황\n";
    private final String AMERICA_LADDER_HARDCORE_MESSAGE = "아메리카 래더 하드코어 우버 디아 현황\n";
    private final String AMERICA_NONE_LADDER_SOFTCORE_MESSAGE = "아메리카 NONE - 래더 소프트코어 우버 디아 현황\n";
    private final String AMERICA_NONE_LADDER_HARDCORE_MESSAGE = "아메리카 NONE - 래더 하드코어 우버 디아 현황\n";

    private final String EUROPE_LADDER_SOFTCORE_MESSAGE = "유럽 래더 소프트코어 우버 디아 현황\n";
    private final String EUROPE_LADDER_HARDCORE_MESSAGE = "유럽 래더 하드코어 우버 디아 현황\n";
    private final String EUROPE_NONE_LADDER_SOFTCORE_MESSAGE = "유럽 NONE - 래더 소프트코어 우버 디아 현황\n";
    private final String EUROPE_NONE_LADDER_HARDCORE_MESSAGE = "유럽 NONE - 래더 하드코어 우버 디아 현황\n";


    private int[] progressValue = new int[6];
    private final String ApiUrl = "https://d2emu.com/api/v1/dclone";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentUberBinding.inflate(inflater, container, false);

        getUber();
        
        mBinding.tvRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "우버 디아블로를 새로고침하였습니다.", Toast.LENGTH_SHORT).show();
                getUber();
            }
        });
        
        mBinding.tvD2emu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://d2emu.com"));
                startActivity(intent);
            }
        });


        return mBinding.getRoot();

    }

    private void setProgressValue(int arrValue, String dw_name, String to_message, String type, TextView textView, TextView message) {

        if (getContext() == null){
            return;
        }

        if (arrValue == 1) {
            String str = to_message;
            SpannableStringBuilder spannableStringBuilder1 = new SpannableStringBuilder(type);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB300")), 0, str.length(), 0);
            spannableStringBuilder1.append(spannableStringBuilder);
            int dw = getResources().getIdentifier(dw_name, "drawable", getContext().getPackageName());
            textView.setBackgroundResource(dw);
            message.setText(spannableStringBuilder1);
        }
    }
    
    private void getUber(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(ApiUrl)
                .addHeader("x-emu-username", "hello_84582")
                .addHeader("x-emu-token", "d4571711a24bbce2")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String responseData = response.body().string();
                // JSON 문자열을 JsonObject로 파싱
                Log.w(TAG, responseData);

                JsonObject jsonObject = JsonParser.parseString(responseData).getAsJsonObject();

                // krLadderHardcore
                if (jsonObject.has("krLadderHardcore")) {
                    JsonObject krLadderHardcore = jsonObject.getAsJsonObject("krLadderHardcore"); // "euLadder" 하위 객체 가져오기
                    if (krLadderHardcore.has("status")) {
                        if ("0".equals(krLadderHardcore.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore01, mBinding.tvAsiaLadderHardcoreMessage);
                        } else if ("1".equals(krLadderHardcore.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore01, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore02, mBinding.tvAsiaLadderHardcoreMessage);
                        } else if ("2".equals(krLadderHardcore.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore01, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore02, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore03, mBinding.tvAsiaLadderHardcoreMessage);
                        } else if ("3".equals(krLadderHardcore.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore01, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore02, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore03, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore04, mBinding.tvAsiaLadderHardcoreMessage);
                        } else if ("4".equals(krLadderHardcore.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore01, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore02, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore03, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore04, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore05, mBinding.tvAsiaLadderHardcoreMessage);
                        } else if ("5".equals(krLadderHardcore.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore01, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore02, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore03, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore04, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore05, mBinding.tvAsiaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", ASIA_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaLadderHardcore06, mBinding.tvAsiaLadderHardcoreMessage);
                        }
                    }
                }

                // "krLadder" 키가 존재하는지 확인
                if (jsonObject.has("krLadder")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("krLadder"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft01, mBinding.tvAsiaLadderSoftMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft01, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft02, mBinding.tvAsiaLadderSoftMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft01, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft02, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft03, mBinding.tvAsiaLadderSoftMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft01, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft02, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft03, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft04, mBinding.tvAsiaLadderSoftMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft01, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft02, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft03, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft04, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft05, mBinding.tvAsiaLadderSoftMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft01, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft02, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft03, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft04, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft05, mBinding.tvAsiaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", ASIA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaLadderSoft06, mBinding.tvAsiaLadderSoftMessage);
                        }
                    }
                }

                // "krNonLadder" 키가 존재하는지 확인
                if (jsonObject.has("krNonLadder")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("krNonLadder"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft01, mBinding.tvAsiaNoneLadderSoftMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft01, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft02, mBinding.tvAsiaNoneLadderSoftMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft01, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft02, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft03, mBinding.tvAsiaNoneLadderSoftMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft01, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft02, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft03, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft04, mBinding.tvAsiaNoneLadderSoftMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft01, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft02, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft03, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft04, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft05, mBinding.tvAsiaNoneLadderSoftMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft01, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft02, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft03, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft04, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft05, mBinding.tvAsiaNoneLadderSoftMessage);
                            setProgressValue(0, "dw_uber_6", "디아블로가 성역을 침공했습니다!", ASIA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderSoft06, mBinding.tvAsiaNoneLadderSoftMessage);
                        }
                    }
                }

                // "krNonLadderHardcore" 키가 존재하는지 확인
                if (jsonObject.has("krNonLadderHardcore")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("krNonLadderHardcore"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore01, mBinding.tvAsiaNoneLadderHardcoreMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore01, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore02, mBinding.tvAsiaNoneLadderHardcoreMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore01, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore02, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore03, mBinding.tvAsiaNoneLadderHardcoreMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore01, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore02, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore03, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore04, mBinding.tvAsiaNoneLadderHardcoreMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore01, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore02, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore03, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore04, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore05, mBinding.tvAsiaNoneLadderHardcoreMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore01, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore02, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore03, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore04, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore05, mBinding.tvAsiaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", ASIA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore06, mBinding.tvAsiaNoneLadderHardcoreMessage);
                        }
                    }
                }

                // "usLadder" 키가 존재하는지 확인
                if (jsonObject.has("usLadder")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("usLadder"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft01, mBinding.tvAmericaLadderSoftMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft01, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft02, mBinding.tvAmericaLadderSoftMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft01, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft02, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft03, mBinding.tvAmericaLadderSoftMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft01, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft02, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft03, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft04, mBinding.tvAmericaLadderSoftMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft01, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft02, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft03, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft04, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft05, mBinding.tvAmericaLadderSoftMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAsiaNoneLadderHardcore01, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft02, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft03, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft04, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft05, mBinding.tvAmericaLadderSoftMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", AMERICA_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaLadderSoft06, mBinding.tvAmericaLadderSoftMessage);
                        }
                    }
                }

                if (jsonObject.has("usNonLadder")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("usNonLadder"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft01, mBinding.tvAmericaNoneLadderSoftMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft01, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft02, mBinding.tvAmericaNoneLadderSoftMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft01, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft02, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft03, mBinding.tvAmericaNoneLadderSoftMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft01, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft02, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft03, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft04, mBinding.tvAmericaNoneLadderSoftMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft01, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft02, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft03, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft04, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft05, mBinding.tvAmericaNoneLadderSoftMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft01, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft02, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft03, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft04, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft05, mBinding.tvAmericaNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", AMERICA_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvAmericaNoneLadderSoft06, mBinding.tvAmericaNoneLadderSoftMessage);
                        }
                    }
                }

                if (jsonObject.has("usLadderHardcore")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("usLadderHardcore"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore01, mBinding.tvAmericaLadderHardcoreMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore01, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore02, mBinding.tvAmericaLadderHardcoreMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore01, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore02, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore03, mBinding.tvAmericaLadderHardcoreMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore01, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore02, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore03, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore04, mBinding.tvAmericaLadderHardcoreMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore01, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore02, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore03, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore04, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore05, mBinding.tvAmericaLadderHardcoreMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore01, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore02, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore03, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore04, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore05, mBinding.tvAmericaLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", AMERICA_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaLadderHardcore06, mBinding.tvAmericaLadderHardcoreMessage);
                        }
                    }
                }

                if (jsonObject.has("usNonLadderHardcore")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("usNonLadderHardcore"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,        mBinding.tvAmericaNoneLadderHardcore01, mBinding.tvAmericaNoneLadderHardcoreMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,        mBinding.tvAmericaNoneLadderHardcore01, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,              mBinding.tvAmericaNoneLadderHardcore02, mBinding.tvAmericaNoneLadderHardcoreMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,        mBinding.tvAmericaNoneLadderHardcore01, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,              mBinding.tvAmericaNoneLadderHardcore02, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,    mBinding.tvAmericaNoneLadderHardcore03, mBinding.tvAmericaNoneLadderHardcoreMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,        mBinding.tvAmericaNoneLadderHardcore01, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,              mBinding.tvAmericaNoneLadderHardcore02, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,    mBinding.tvAmericaNoneLadderHardcore03, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,           mBinding.tvAmericaNoneLadderHardcore04, mBinding.tvAmericaNoneLadderHardcoreMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,     mBinding.tvAmericaNoneLadderHardcore01, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,           mBinding.tvAmericaNoneLadderHardcore02, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaNoneLadderHardcore03, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,         mBinding.tvAmericaNoneLadderHardcore04, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,       mBinding.tvAmericaNoneLadderHardcore05, mBinding.tvAmericaNoneLadderHardcoreMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,     mBinding.tvAmericaNoneLadderHardcore01, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,           mBinding.tvAmericaNoneLadderHardcore02, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvAmericaNoneLadderHardcore03, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,         mBinding.tvAmericaNoneLadderHardcore04, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,       mBinding.tvAmericaNoneLadderHardcore05, mBinding.tvAmericaNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", AMERICA_NONE_LADDER_HARDCORE_MESSAGE,       mBinding.tvAmericaNoneLadderHardcore06, mBinding.tvAmericaNoneLadderHardcoreMessage);
                        }
                    }
                }

                // 유럽 euLadder
                if (jsonObject.has("euLadder")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("euLadder"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,        mBinding.tvEuropeLadderSoft01, mBinding.tvEuropeLadderSoftMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,        mBinding.tvEuropeLadderSoft01, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,              mBinding.tvEuropeLadderSoft02, mBinding.tvEuropeLadderSoftMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,        mBinding.tvEuropeLadderSoft01, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,              mBinding.tvEuropeLadderSoft02, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,    mBinding.tvEuropeLadderSoft03, mBinding.tvEuropeLadderSoftMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,        mBinding.tvEuropeLadderSoft01, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,              mBinding.tvEuropeLadderSoft02, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,    mBinding.tvEuropeLadderSoft03, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,           mBinding.tvEuropeLadderSoft04, mBinding.tvEuropeLadderSoftMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,     mBinding.tvEuropeLadderSoft01, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,           mBinding.tvEuropeLadderSoft02, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_LADDER_SOFTCORE_MESSAGE, mBinding.tvEuropeLadderSoft03, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,         mBinding.tvEuropeLadderSoft04, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,       mBinding.tvEuropeLadderSoft05, mBinding.tvEuropeLadderSoftMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,     mBinding.tvEuropeLadderSoft01, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,           mBinding.tvEuropeLadderSoft02, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_LADDER_SOFTCORE_MESSAGE, mBinding.tvEuropeLadderSoft03, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,         mBinding.tvEuropeLadderSoft04, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", EUROPE_LADDER_SOFTCORE_MESSAGE,       mBinding.tvEuropeLadderSoft05, mBinding.tvEuropeLadderSoftMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", EUROPE_LADDER_SOFTCORE_MESSAGE,       mBinding.tvEuropeLadderSoft06, mBinding.tvEuropeLadderSoftMessage);
                        }
                    }
                }

                if (jsonObject.has("euNonLadder")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("euNonLadder"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,        mBinding.tvEuropeNoneLadderSoft01, mBinding.tvEuropeNoneLadderSoftMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,        mBinding.tvEuropeNoneLadderSoft01, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,              mBinding.tvEuropeNoneLadderSoft02, mBinding.tvEuropeNoneLadderSoftMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,        mBinding.tvEuropeNoneLadderSoft01, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,              mBinding.tvEuropeNoneLadderSoft02, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,    mBinding.tvEuropeNoneLadderSoft03, mBinding.tvEuropeNoneLadderSoftMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,        mBinding.tvEuropeNoneLadderSoft01, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,              mBinding.tvEuropeNoneLadderSoft02, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,    mBinding.tvEuropeNoneLadderSoft03, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,           mBinding.tvEuropeNoneLadderSoft04, mBinding.tvEuropeNoneLadderSoftMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,     mBinding.tvEuropeNoneLadderSoft01, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,           mBinding.tvEuropeNoneLadderSoft02, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvEuropeNoneLadderSoft03, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,         mBinding.tvEuropeNoneLadderSoft04, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,       mBinding.tvEuropeNoneLadderSoft05, mBinding.tvEuropeNoneLadderSoftMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,     mBinding.tvEuropeNoneLadderSoft01, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,           mBinding.tvEuropeNoneLadderSoft02, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE, mBinding.tvEuropeNoneLadderSoft03, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,         mBinding.tvEuropeNoneLadderSoft04, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,       mBinding.tvEuropeNoneLadderSoft05, mBinding.tvEuropeNoneLadderSoftMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", EUROPE_NONE_LADDER_SOFTCORE_MESSAGE,       mBinding.tvEuropeNoneLadderSoft06, mBinding.tvEuropeNoneLadderSoftMessage);
                        }
                    }
                }

                if (jsonObject.has("euLadderHardcore")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("euLadderHardcore"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_HARDCORE_MESSAGE,        mBinding.tvEuropeLadderHardcore01, mBinding.tvEuropeLadderHardcoreMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_HARDCORE_MESSAGE,        mBinding.tvEuropeLadderHardcore01, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_HARDCORE_MESSAGE,              mBinding.tvEuropeLadderHardcore02, mBinding.tvEuropeLadderHardcoreMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_HARDCORE_MESSAGE,        mBinding.tvEuropeLadderHardcore01, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_HARDCORE_MESSAGE,              mBinding.tvEuropeLadderHardcore02, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_LADDER_HARDCORE_MESSAGE,    mBinding.tvEuropeLadderHardcore03, mBinding.tvEuropeLadderHardcoreMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_HARDCORE_MESSAGE,        mBinding.tvEuropeLadderHardcore01, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_HARDCORE_MESSAGE,              mBinding.tvEuropeLadderHardcore02, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_LADDER_HARDCORE_MESSAGE,    mBinding.tvEuropeLadderHardcore03, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_LADDER_HARDCORE_MESSAGE,           mBinding.tvEuropeLadderHardcore04, mBinding.tvEuropeLadderHardcoreMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_HARDCORE_MESSAGE,     mBinding.tvEuropeLadderHardcore01, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_HARDCORE_MESSAGE,           mBinding.tvEuropeLadderHardcore02, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_LADDER_HARDCORE_MESSAGE, mBinding.tvEuropeLadderHardcore03, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_LADDER_HARDCORE_MESSAGE,         mBinding.tvEuropeLadderHardcore04, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", EUROPE_LADDER_HARDCORE_MESSAGE,       mBinding.tvEuropeLadderHardcore05, mBinding.tvEuropeLadderHardcoreMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_LADDER_HARDCORE_MESSAGE,     mBinding.tvEuropeLadderHardcore01, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_LADDER_HARDCORE_MESSAGE,           mBinding.tvEuropeLadderHardcore02, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_LADDER_HARDCORE_MESSAGE, mBinding.tvEuropeLadderHardcore03, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_LADDER_HARDCORE_MESSAGE,         mBinding.tvEuropeLadderHardcore04, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", EUROPE_LADDER_HARDCORE_MESSAGE,       mBinding.tvEuropeLadderHardcore05, mBinding.tvEuropeLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", EUROPE_LADDER_HARDCORE_MESSAGE,       mBinding.tvEuropeLadderHardcore06, mBinding.tvEuropeLadderHardcoreMessage);
                        }
                    }
                }

                if (jsonObject.has("euNonLadderHardcore")) {
                    JsonObject krLadder = jsonObject.getAsJsonObject("euNonLadderHardcore"); // "euLadder" 하위 객체 가져오기
                    if (krLadder.has("status")) {
                        if ("0".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,        mBinding.tvEuropeNoneLadderHardcore01, mBinding.tvEuropeNoneLadderHardcoreMessage);
                        } else if ("1".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,        mBinding.tvEuropeNoneLadderHardcore01, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,              mBinding.tvEuropeNoneLadderHardcore02, mBinding.tvEuropeNoneLadderHardcoreMessage);
                        } else if ("2".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,        mBinding.tvEuropeNoneLadderHardcore01, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,              mBinding.tvEuropeNoneLadderHardcore02, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,    mBinding.tvEuropeNoneLadderHardcore03, mBinding.tvEuropeNoneLadderHardcoreMessage);
                        } else if ("3".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,        mBinding.tvEuropeNoneLadderHardcore01, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,              mBinding.tvEuropeNoneLadderHardcore02, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,    mBinding.tvEuropeNoneLadderHardcore03, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,           mBinding.tvEuropeNoneLadderHardcore04, mBinding.tvEuropeNoneLadderHardcoreMessage);
                        } else if ("4".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,     mBinding.tvEuropeNoneLadderHardcore01, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,           mBinding.tvEuropeNoneLadderHardcore02, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvEuropeNoneLadderHardcore03, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,         mBinding.tvEuropeNoneLadderHardcore04, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,       mBinding.tvEuropeNoneLadderHardcore05, mBinding.tvEuropeNoneLadderHardcoreMessage);
                        } else if ("5".equals(krLadder.get("status").getAsString())) {
                            setProgressValue(1, "dw_uber_1", "성역에 공포의 응시가 느껴집니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,     mBinding.tvEuropeNoneLadderHardcore01, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_2", "성역에 공포가 다가옵니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,           mBinding.tvEuropeNoneLadderHardcore02, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_3", "성역 안에 공포가 형성되기 시작합니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE, mBinding.tvEuropeNoneLadderHardcore03, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_4", "성역 곳곳에 공포가 퍼집니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,         mBinding.tvEuropeNoneLadderHardcore04, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_5", "성역에 공포가 풀려나려 합니다.", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,       mBinding.tvEuropeNoneLadderHardcore05, mBinding.tvEuropeNoneLadderHardcoreMessage);
                            setProgressValue(1, "dw_uber_6", "디아블로가 성역을 침공했습니다!", EUROPE_NONE_LADDER_HARDCORE_MESSAGE,       mBinding.tvEuropeNoneLadderHardcore06, mBinding.tvEuropeNoneLadderHardcoreMessage);
                        }
                    }
                }

            }
        });
    }
    
}