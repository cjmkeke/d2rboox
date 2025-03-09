package com.cjmkeke.d2rbooks.itemdatabase;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.FragmentHoradricCubeDatabaseBinding;

public class HoradricCubeDatabase extends Fragment {

    private static final String TAG = "HoradricCubeDatabase";
    private FragmentHoradricCubeDatabaseBinding mBinding;
    private SharedPreferences fontSharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fontSharedPreferences = getContext().getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        getContext().setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);
        mBinding = FragmentHoradricCubeDatabaseBinding.inflate(inflater, container, false);

        mBinding.wvHoradricCube.getSettings().setJavaScriptEnabled(true);
        mBinding.wvHoradricCube.loadUrl("file:///android_asset/www/index.html");
        mBinding.wvHoradricCube.addJavascriptInterface(new WebAppInterface(), "Android");

        return mBinding.getRoot();
    }
    // JavaScript 인터페이스 클래스
    public class WebAppInterface {
        @JavascriptInterface
        public void showToast(String message) {
            // Toast 메시지 표시
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}