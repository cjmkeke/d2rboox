package com.cjmkeke.d2rbooks.dialog;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.adapter.AdapterPrice;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityPriceShowBinding;
import com.cjmkeke.d2rbooks.model.Price;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PriceShow extends Activity {

    private static final String TAG = "PriceShow";
    private ActivityPriceShowBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private List<BarEntry> originalEntries = new ArrayList<>();
    private List<BarEntry> adjustedEntries = new ArrayList<>();
    private Intent intent;
    private String runeName;
    private RecyclerView recyclerView;
    private AdapterPrice adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Price> arrayList;
    private String yearAnDay;
    private String bottomString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.TransparentDialog);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setFinishOnTouchOutside(true);

        fontSharedPreferences = getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        adjustDialogSize();

        mBinding = ActivityPriceShowBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        intent = getIntent();
        if (intent.getStringExtra("jah") != null) {
            runeName = intent.getStringExtra("jah");
        } else if (intent.getStringExtra("ber") != null) {
            runeName = intent.getStringExtra("ber");
        } else {
            Log.w(TAG, "데이터가 없습니다.");
        }

        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference1 = firebaseDatabase.getReference();
        databaseReference1.child("price").child("settings").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                yearAnDay = snapshot.child("yearAnDays").getValue(String.class);
                bottomString = snapshot.child("bottomString").getValue(String.class);
                if (yearAnDay != null && bottomString != null) {
                    databaseReference = firebaseDatabase.getReference("price").child("rune").child("ladder").child(runeName).child(yearAnDay);
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            for (DataSnapshot snap : snapshot.getChildren()) {
                                int key = Integer.parseInt(snap.getKey());
                                int value = snap.getValue(Integer.class);
                                originalEntries.add(new BarEntry(key, value));
                            }

                            // X값을 연속적으로 변환
                            for (int i = 0; i < originalEntries.size(); i++) {
                                adjustedEntries.add(new BarEntry(i, originalEntries.get(i).getY()));
                            }

                            // BarDataSet 설정
                            BarDataSet barDataSet = new BarDataSet(adjustedEntries, bottomString);
                            barDataSet.setColors(Color.parseColor("#FFB300"));
                            barDataSet.setValueTextColor(Color.parseColor("#D4C491"));
                            barDataSet.setValueTextSize(9f);

                            BarData barData = new BarData(barDataSet);
                            barData.setBarWidth(0.5f);
                            mBinding.chart.setData(barData);

                            // 범례 설정 (Legend)
                            Legend legend = mBinding.chart.getLegend();
                            legend.setTextColor(Color.parseColor("#D4C491")); // 범례 글씨 색상 설정
                            legend.setTextSize(9f); // 글씨 크기 설정 (옵션)
                            legend.setForm(Legend.LegendForm.SQUARE); // 범례 아이콘 형태 설정

                            // X축 설정
                            XAxis xAxis = mBinding.chart.getXAxis();
                            xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                            xAxis.setDrawGridLines(false);
                            xAxis.setGranularity(1f); // 레이블 간격 설정
                            xAxis.setGranularityEnabled(true);
                            xAxis.setTextColor(Color.parseColor("#D4C491"));

                            // 커스텀 레이블
                            final String[] days = {"1", "2일", "3일", "4일", "5일", "6일", "7일", "8일", "9일", "10일", "11일",
                                    "12일", "13일", "14일", "15일", "16일", "17일", "18일", "19일", "20일", "21일", "22일",
                                    "23일", "24일", "25일", "26일", "27일", "28일", "29일", "30일", "31일"};
                            xAxis.setValueFormatter(new IndexAxisValueFormatter(days));

                            // Y축 설정
                            YAxis leftAxis = mBinding.chart.getAxisLeft();
                            leftAxis.setAxisMinimum(0f);
                            leftAxis.setDrawGridLines(false);
                            leftAxis.setTextColor(Color.parseColor("#D4C491"));

                            mBinding.chart.getAxisRight().setEnabled(false);

                            // 차트 기타 스타일 설정
                            mBinding.chart.getDescription().setEnabled(false);
                            mBinding.chart.setDrawGridBackground(false);
                            mBinding.chart.setDragEnabled(true);
                            mBinding.chart.setVisibleXRangeMaximum(10);
                            mBinding.chart.animateY(1500);
                            mBinding.chart.moveViewToX(mBinding.chart.getData().getEntryCount());
                            mBinding.chart.invalidate();

                            // 평균값 계산
                            double sum = 0;
                            for (BarEntry entry : originalEntries) {
                                sum += entry.getY();
                            }
                            double average = sum / originalEntries.size();
                            int finalAverage = (int) average;

                            if (runeName.equals("jah")) {
                                mBinding.tvAverage.setText("래더 자룬 평균 시세 : " + finalAverage + "\\ (원) ");
                            } else if (runeName.equals("ber")) {
                                mBinding.tvAverage.setText("래더 베르룬 평균 시세 : " + finalAverage + "\\ (원)");
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        String getBottomStringLength = mBinding.tvBottomLink.getText().toString();
        Log.w(TAG, getBottomStringLength);
        int call = getBottomStringLength.length();

        int subValue1 = getBottomStringLength.indexOf("디");
        String bottomString = getBottomStringLength.substring(subValue1, subValue1 + 3);

        int subValue2 = getBottomStringLength.indexOf("플");
        String bottomString2 = getBottomStringLength.substring(subValue2, subValue2 + 5);

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getBottomStringLength);
        // 클릭 가능한 span 설정
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                // A 사이트로 이동
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ddcall.net/"));
                view.getContext().startActivity(intent);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.WHITE); // 링크 색상
            }
        };

        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.playnote.co.kr/diablo/"));
                widget.getContext().startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.WHITE); // 링크 색상
            }
        };

        spannableStringBuilder.setSpan(clickableSpan1, subValue1, subValue1 +3, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(clickableSpan2, subValue2, subValue2 + 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mBinding.tvBottomLink.setText(spannableStringBuilder);
        mBinding.tvBottomLink.setMovementMethod(LinkMovementMethod.getInstance()); // 클릭 이벤트 활성화
    }

    private void adjustDialogSize() {
        // 화면 크기 가져오기
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;

        // 좌우 10dp 남기는 크기로 설정
        int marginInDp = 20;
        float density = getResources().getDisplayMetrics().density;
        int marginInPx = (int) (marginInDp * density);

        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.width = screenWidth - (2 * marginInPx); // 좌우 10dp씩 남기기
        getWindow().setAttributes(params);
    }

}