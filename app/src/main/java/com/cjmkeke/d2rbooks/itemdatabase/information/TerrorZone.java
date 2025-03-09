package com.cjmkeke.d2rbooks.itemdatabase.information;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.databinding.FragmentTerrorZoneBinding;
import com.cjmkeke.d2rbooks.service.background.constants.TerrorZoneConstantsKor;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TerrorZone extends Fragment {

    private static final String TAG = "TerrorZone";
    private FragmentTerrorZoneBinding mBinding;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private static final String API_KEY = "https://d2emu.com/api/v1/tz";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentTerrorZoneBinding.inflate(inflater, container, false);
        getTerrorZone();
        mBinding.tvRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "테러존을 새로고침하였습니다.", Toast.LENGTH_SHORT).show();
                getTerrorZone();
            }
        });
        return mBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding = null;
    }

    private void getTerrorZone() {
        try {
            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase.getReference("terror_zone");

            // Firebase Crashlytics 테스트 예외
            FirebaseCrashlytics.getInstance().log("TerrorZone fragment started");
            FirebaseCrashlytics.getInstance().setCustomKey("Fragment", "TerrorZone");

            // 데이터 초기화
            Map<String, String> terrorZoneMap = new HashMap<>();
            terrorZoneMap.put("2", TerrorZoneConstantsKor.ACT1_1);
            terrorZoneMap.put("3", TerrorZoneConstantsKor.ACT1_2);
            terrorZoneMap.put("17", TerrorZoneConstantsKor.ACT1_3);
            terrorZoneMap.put("4", TerrorZoneConstantsKor.ACT1_4);
            terrorZoneMap.put("38", TerrorZoneConstantsKor.ACT1_5);
            terrorZoneMap.put("5", TerrorZoneConstantsKor.ACT1_6);
            terrorZoneMap.put("6", TerrorZoneConstantsKor.ACT1_7);
            terrorZoneMap.put("20", TerrorZoneConstantsKor.ACT1_8);
            terrorZoneMap.put("12", TerrorZoneConstantsKor.ACT1_9);
            terrorZoneMap.put("28", TerrorZoneConstantsKor.ACT1_10);
            terrorZoneMap.put("33", TerrorZoneConstantsKor.ACT1_11);
            terrorZoneMap.put("39", TerrorZoneConstantsKor.ACT1_12);
            terrorZoneMap.put("47", TerrorZoneConstantsKor.ACT2_1);
            terrorZoneMap.put("41", TerrorZoneConstantsKor.ACT2_2);
            terrorZoneMap.put("42", TerrorZoneConstantsKor.ACT2_3);
            terrorZoneMap.put("43", TerrorZoneConstantsKor.ACT2_4);
            terrorZoneMap.put("44", TerrorZoneConstantsKor.ACT2_5);
            terrorZoneMap.put("65", TerrorZoneConstantsKor.ACT2_6);
            terrorZoneMap.put("74", TerrorZoneConstantsKor.ACT2_7);
            terrorZoneMap.put("66", TerrorZoneConstantsKor.ACT2_8);
            terrorZoneMap.put("76", TerrorZoneConstantsKor.ACT3_1);
            terrorZoneMap.put("77", TerrorZoneConstantsKor.ACT3_2);
            terrorZoneMap.put("78", TerrorZoneConstantsKor.ACT3_3);
            terrorZoneMap.put("80", TerrorZoneConstantsKor.ACT3_4);
            terrorZoneMap.put("83", TerrorZoneConstantsKor.ACT3_5);
            terrorZoneMap.put("100", TerrorZoneConstantsKor.ACT3_6);
            terrorZoneMap.put("104", TerrorZoneConstantsKor.ACT4_1);
            terrorZoneMap.put("106", TerrorZoneConstantsKor.ACT4_2);
            terrorZoneMap.put("108", TerrorZoneConstantsKor.ACT4_3);
            terrorZoneMap.put("110", TerrorZoneConstantsKor.ACT5_1);
            terrorZoneMap.put("112", TerrorZoneConstantsKor.ACT5_2);
            terrorZoneMap.put("113", TerrorZoneConstantsKor.ACT5_3);
            terrorZoneMap.put("115", TerrorZoneConstantsKor.ACT5_4);
            terrorZoneMap.put("121", TerrorZoneConstantsKor.ACT5_5);
            terrorZoneMap.put("118", TerrorZoneConstantsKor.ACT5_6);
            terrorZoneMap.put("128", TerrorZoneConstantsKor.ACT5_7);
            terrorZoneMap.put("ERROR", TerrorZoneConstantsKor.ERROR_MESSAGE_1);
            terrorZoneMap.put("EMPTY", TerrorZoneConstantsKor.ERROR_MESSAGE_EMPTY);

            // Map 초기화
            Map<String, Pair<View, View>> viewMap = new HashMap<>();
            viewMap.put("2", new Pair<>(mBinding.act11, mBinding.act11Recommend));
            viewMap.put("3", new Pair<>(mBinding.act12, mBinding.act12Recommend));
            viewMap.put("17", new Pair<>(mBinding.act13, mBinding.act13Recommend));
            viewMap.put("4", new Pair<>(mBinding.act14, mBinding.act14Recommend));
            viewMap.put("38", new Pair<>(mBinding.act15, mBinding.act15Recommend));
            viewMap.put("5", new Pair<>(mBinding.act16, mBinding.act16Recommend));
            viewMap.put("6", new Pair<>(mBinding.act17, mBinding.act17Recommend));
            viewMap.put("20", new Pair<>(mBinding.act18, mBinding.act18Recommend));
            viewMap.put("12", new Pair<>(mBinding.act19, mBinding.act19Recommend));
            viewMap.put("28", new Pair<>(mBinding.act110, mBinding.act110Recommend));
            viewMap.put("33", new Pair<>(mBinding.act111, mBinding.act111Recommend));
            viewMap.put("39", new Pair<>(mBinding.act112, mBinding.act112Recommend));
            viewMap.put("47", new Pair<>(mBinding.act21, mBinding.act21Recommend));
            viewMap.put("41", new Pair<>(mBinding.act22, mBinding.act22Recommend));
            viewMap.put("42", new Pair<>(mBinding.act23, mBinding.act23Recommend));
            viewMap.put("43", new Pair<>(mBinding.act24, mBinding.act24Recommend));
            viewMap.put("44", new Pair<>(mBinding.act25, mBinding.act25Recommend));
            viewMap.put("65", new Pair<>(mBinding.act26, mBinding.act26Recommend));
            viewMap.put("74", new Pair<>(mBinding.act27, mBinding.act27Recommend));
            viewMap.put("66", new Pair<>(mBinding.act28, mBinding.act28Recommend));
            viewMap.put("76", new Pair<>(mBinding.act31, mBinding.act31Recommend));
            viewMap.put("77", new Pair<>(mBinding.act32, mBinding.act32Recommend));
            viewMap.put("78", new Pair<>(mBinding.act33, mBinding.act33Recommend));
            viewMap.put("80", new Pair<>(mBinding.act34, mBinding.act34Recommend));
            viewMap.put("83", new Pair<>(mBinding.act35, mBinding.act35Recommend));
            viewMap.put("100", new Pair<>(mBinding.act36, mBinding.act36Recommend));
            viewMap.put("104", new Pair<>(mBinding.act41, mBinding.act41Recommend));
            viewMap.put("106", new Pair<>(mBinding.act42, mBinding.act42Recommend));
            viewMap.put("108", new Pair<>(mBinding.act43, mBinding.act43Recommend));
            viewMap.put("110", new Pair<>(mBinding.act51, mBinding.act51Recommend));
            viewMap.put("112", new Pair<>(mBinding.act52, mBinding.act52Recommend));
            viewMap.put("113", new Pair<>(mBinding.act53, mBinding.act53Recommend));
            viewMap.put("115", new Pair<>(mBinding.act54, mBinding.act54Recommend));
            viewMap.put("121", new Pair<>(mBinding.act55, mBinding.act55Recommend));
            viewMap.put("118", new Pair<>(mBinding.act56, mBinding.act56Recommend));
            viewMap.put("128", new Pair<>(mBinding.act57, mBinding.act57Recommend));

            Drawable res1 = ContextCompat.getDrawable(getContext(), R.drawable.dw_message);
            Drawable res2 = ContextCompat.getDrawable(getContext(), R.drawable.dw_soket);

            mBinding.tvD2emu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://d2emu.com"));
                    startActivity(intent);
                }
            });


            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(API_KEY)
                    .addHeader("x-emu-username", "hello_84582")
                    .addHeader("x-emu-token", "d4571711a24bbce2")
                    .build();

            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.e(TAG, e.toString());
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    Handler uiHandler = new Handler(Looper.getMainLooper());
                    if (response.isSuccessful()) {
                        String responseBody = response.body().string();
                        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
                        Log.w(TAG, responseBody);

                        if (jsonObject.has("ERROR")) {
                            String errorMessage = jsonObject.get("ERROR").getAsString();
                            uiHandler.post(() -> {
                                mBinding.tvTodayTerrorZone.setText(terrorZoneMap.get("ERROR"));
                                mBinding.tvNextTerrorZone.setText(terrorZoneMap.get("ERROR"));
                                mBinding.tvTodayTerrorZone.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                                    }
                                });

                                mBinding.tvNextTerrorZone.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                                    }
                                });
                            });
                        }

                        if (jsonObject.has("current")) {
                            JsonArray currentArray = jsonObject.getAsJsonArray("current");
                            if (currentArray.size() == 0){
                                uiHandler.post(() -> mBinding.tvTodayTerrorZone.setText(terrorZoneMap.get("EMPTY")));
                            } else {
                                for (int i = 0; i < currentArray.size(); i++) {
                                    String value = currentArray.get(i).getAsString();
                                    if (terrorZoneMap.containsKey(value)) {

                                        if (mBinding == null) {
                                            return;
                                        }

                                        // UI 변경 작업을 메인 스레드에서 실행
                                        uiHandler.post(() -> {
                                            mBinding.tvTodayTerrorZone.setText(terrorZoneMap.get(value));

                                            if (viewMap.containsKey(value)) {
                                                Pair<View, View> views = viewMap.get(value);
                                                if (views != null) {
                                                    if (views.first instanceof TextView) {
                                                        TextView textView = (TextView) views.first;
                                                        textView.setBackground(res1);
                                                        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icons_terror_on_size, 0, 0, 0);
                                                    } else {
                                                        views.first.setBackground(res1);
                                                    }

                                                    if (views.second instanceof TextView) {
                                                        TextView recommendView = (TextView) views.second;
                                                        recommendView.setBackground(res1);
                                                    } else {
                                                        views.second.setBackground(res1);
                                                    }
                                                }
                                            } else {
                                                Log.w(TAG, "Unknown value: " + value);
                                            }
                                        });
                                    }
                                }
                            }


                        }

                        if (jsonObject.has("next")) {
                            JsonArray nextArray = jsonObject.getAsJsonArray("next");
                            if (nextArray.size() == 0) {
                                uiHandler.post(() -> mBinding.tvNextTerrorZone.setText(terrorZoneMap.get("EMPTY")));
                            } else {
                                for (int i = 0; i < nextArray.size(); i++) {
                                    String value = nextArray.get(i).getAsString();
                                    if (terrorZoneMap.containsKey(value)) {
                                        uiHandler.post(() -> {
                                            mBinding.tvNextTerrorZone.setText(terrorZoneMap.get(value));
                                            if (viewMap.containsKey(value)) {
                                                Pair<View, View> views = viewMap.get(value);
                                                if (views != null) {
                                                    if (views.first instanceof TextView) {
                                                        TextView textView = (TextView) views.first;
                                                        textView.setBackground(res2);
                                                        textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icons_next_size, 0, 0, 0);
                                                    } else {
                                                        views.first.setBackground(res2);
                                                    }

                                                    if (views.second instanceof TextView) {
                                                        TextView recommendView = (TextView) views.second;
                                                        recommendView.setBackground(res2);
                                                    } else {
                                                        views.second.setBackground(res2);
                                                    }
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        }

                    }
                }
            });
        } catch (Exception e) {
            FirebaseCrashlytics.getInstance().recordException(e);
            Log.e(TAG, "Unhandled exception in TerrorZone", e);
        }
    }


}
