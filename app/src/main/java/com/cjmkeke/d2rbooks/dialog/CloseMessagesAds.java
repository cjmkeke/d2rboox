//package com.cjmkeke.d2rbooks.dialog;
//
//import android.app.Dialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//
//import com.cjmkeke.d2rbooks.R;
//import com.google.android.gms.ads.AdListener;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;
//import com.google.android.gms.ads.LoadAdError;
//import com.google.android.gms.ads.MobileAds;
//
//public class CloseMessagesAds extends Dialog {
//
//    private AdView adView;
//    private CloseDataCallBack closeDataCallBack;
//
//    public CloseMessagesAds(@NonNull Context context, CloseDataCallBack closeDataCallBack) {
//        super(context);
//        this.closeDataCallBack = closeDataCallBack;
//    }
//
//    public CloseMessagesAds(@NonNull Context context, int themeResId, CloseDataCallBack closeDataCallBack) {
//        super(context, themeResId);
//        this.closeDataCallBack = closeDataCallBack;
//    }
//
//    protected CloseMessagesAds(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener, CloseDataCallBack closeDataCallBack) {
//        super(context, cancelable, cancelListener);
//        this.closeDataCallBack = closeDataCallBack;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.item_close_message_ads);
//
//        adView = findViewById(R.id.adview);
//        TextView button = findViewById(R.id.btn_close);
//
//        // Mobile Ads SDK 초기화 (이미 초기화되었다면 중복 호출하지 않아도 됨)
//        MobileAds.initialize(getContext(), initializationStatus -> {});
//
//        // 광고 로드
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
//
//        // 광고 리스너 설정 (선택 사항)
//        adView.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                // 광고 로드 성공
//            }
//
//            @Override
//            public void onAdFailedToLoad(LoadAdError adError) {
//                // 광고 로드 실패
//            }
//
//            // 기타 리스너 메서드...
//        });
//
//        // 닫기 버튼 리스너 설정
//        if (button != null) {
//            button.setOnClickListener(v -> {
//                if (closeDataCallBack != null) {
//                    closeDataCallBack.resultDataCallBack();
//                }
//                dismiss();
//            });
//        }
//
//        // 다이얼로그 창의 좌우 및 위아래 패딩 설정
//        Window window = getWindow();
//        if (window != null) {
//            // 다이얼로그의 너비와 높이를 화면 크기에 맞게 설정
//            WindowManager.LayoutParams params = window.getAttributes();
//            params.width = WindowManager.LayoutParams.MATCH_PARENT;
//            params.height = WindowManager.LayoutParams.WRAP_CONTENT; // 높이를 필요에 따라 조정
//            window.setAttributes(params);
//
//            // 5dp를 픽셀로 변환
//            int marginInDp = 5;
//            float density = getContext().getResources().getDisplayMetrics().density;
//            int marginInPx = (int) (marginInDp * density + 0.5f);
//
//            // 패딩 적용 (좌, 상, 우, 하)
//            window.getDecorView().setPadding(marginInPx, marginInPx, marginInPx, marginInPx);
//        }
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        if (adView != null) {
//            adView.resume();
//        }
//    }
//
//    @Override
//    protected void onStop() {
//        if (adView != null) {
//            adView.pause();
//        }
//        super.onStop();
//    }
//
//    @Override
//    public void dismiss() {
//        if (adView != null) {
//            adView.destroy();
//        }
//        super.dismiss();
//    }
//}
