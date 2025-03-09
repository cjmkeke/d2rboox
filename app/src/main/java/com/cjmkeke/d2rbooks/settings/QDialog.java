package com.cjmkeke.d2rbooks.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityQDialogBinding;


public class QDialog extends AppCompatActivity {

    private static final String TAG = "QDialog";
    private static final String TERROR_ZONE_MESSAGES = "테러존은 디아블로2 레저렉션에 새롭게 적용된 컨텐츠 입니다. " +
            "\n테러존에서는 몬스터의 레벨 상승 효과 및 유니크 참(파괴참)을 획득할수 있습니다." +
            "\n" +
            "\n일반 몬스터 레벨 +2" +
            "\n챔피언 몬스터 레벨 +4" +
            "\n유니크 몬스터 레벨 +5" +
            "\n" +
            "\n테러존의 레벨은 몬스터 레벨 96을 넘어서지 않으며, 테러존에서는 파괴참을 획득할수 있는데, 부패의 분열, 불길의 분열, 뼈의 분쇄, " +
            "천상의 틈, 추위의 파열, 칠흑의 천공을 획득할수 있습니다. 이걸 줄여서 사람들은 파괴참이라고 합니다."+
            "\n" +
            "\n" +
            "싱글 테러존은 시간대가 고정되어 있지만, 베틀넷에서는 시간대가 항상 바뀌기 때문에 사용자가 원하는 테러존을 알람하면" +
            "쉽게 레벨업을 할 수 있습니다.";

    private static final String UBER_DIA_MESSAGES = "우버 디아블로는 조던링(요르단의 반지)를 상점에 하여 일정 조건이 되면 나타나는 디아블로의 컨텐츠입니다." +
            "\n일정 조건이 되면 채팅창에 \"디아블로가 성역을 침공했습니다!\" 라는 메시지가 나오고 첫 마주치는 슈퍼 유니크 몬스터가 디아블로로 변하게 됩니다." +
            "\n이 디아블로를 처치하면 애니참(애니힐러스) 스몰참을 획득 할 수 있습니다.";

    private static final String UBER_DIA_MESSAGE_2 =
                    "(변동) 모든 능력치 +10~20" +
                    "\n(변동) 모든 저항 +10~20" +
                    "\n(변동) 경험치 획득량 +5~10%" +
                    "\n20,20,10 일경우 최상급" +
                    "\n\n우버 디아블로는 많은 유튜버들이 이벤트를 하고 있으며. 최상급 옵션인 경우 높은 가격대가 형성 하고 있으니 기회를 놓치지 마세요!";
    
    private Intent intent;
    private ActivityQDialogBinding mBinding;
    private SharedPreferences fontSharedPreferences;

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

        mBinding = ActivityQDialogBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        intent = getIntent();
        mBinding.ivExample.setVisibility(View.GONE);
        mBinding.tvQuestion2.setVisibility(View.GONE);
        if (intent != null) {
            String terror = intent.getStringExtra("terror");
            String uber = intent.getStringExtra("uber_dia");

            if (terror != null) {
                Log.w(TAG, String.valueOf(terror.length()));
                int uniqueTextStart = TERROR_ZONE_MESSAGES.indexOf("일반 몬스터");
                int uniqueTextEnd = TERROR_ZONE_MESSAGES.lastIndexOf("+5");

                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(TERROR_ZONE_MESSAGES);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#FFB300")), uniqueTextStart, uniqueTextEnd + 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                int i = getResources().getIdentifier("back_terror_zone", "drawable", getPackageName());
                mBinding.tvTitleBg.setBackgroundResource(i);
                mBinding.tvQuestion.setText(spannableStringBuilder);
            }

            if (uber != null) {
                mBinding.ivExample.setVisibility(View.VISIBLE);
                mBinding.tvQuestion2.setVisibility(View.VISIBLE);

                // 배경 이미지 설정
                int i = getResources().getIdentifier("back_uber", "drawable", getPackageName());

                // 색상 변경 범위 계산
                int uberChangeStart = UBER_DIA_MESSAGE_2.indexOf("(변동)");
                int uberChangeEnd = UBER_DIA_MESSAGE_2.lastIndexOf("10%");
                int indexPerfectOptionStart = UBER_DIA_MESSAGE_2.indexOf("20,");
                int indexPerfectOptionEnd = UBER_DIA_MESSAGE_2.indexOf("최상급");

                // 디버깅 로그 출력
                Log.w(TAG, "uberChangeStart: " + uberChangeStart + ", uberChangeEnd: " + uberChangeEnd);
                Log.w(TAG, "indexPerfectOptionStart: " + indexPerfectOptionStart + ", indexPerfectOptionEnd: " + indexPerfectOptionEnd);

                // SpannableStringBuilder 생성 및 색상 적용
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(UBER_DIA_MESSAGE_2);

                // (변동) ~ 10% 부분 색상 변경 (예: 노란색)
                if (uberChangeStart != -1 && uberChangeEnd != -1) {
                    spannableStringBuilder.setSpan(
                            new ForegroundColorSpan(Color.parseColor("#FFB300")),
                            uberChangeStart,
                            uberChangeEnd + 3, // "10%" 포함
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                }

                // "20," ~ "최상급" 부분 색상 변경 (예: 오렌지색)
                if (indexPerfectOptionStart != -1 && indexPerfectOptionEnd != -1) {
                    spannableStringBuilder.setSpan(
                            new ForegroundColorSpan(Color.parseColor("#FF4500")),
                            indexPerfectOptionStart,
                            indexPerfectOptionEnd + "최상급".length(),
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                }

                // UI 업데이트
                mBinding.tvTitleBg.setBackgroundResource(i);
                mBinding.tvQuestion.setText(UBER_DIA_MESSAGES);
                mBinding.tvQuestion2.setText(spannableStringBuilder);
            }

        } else {
            finish();
        }
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