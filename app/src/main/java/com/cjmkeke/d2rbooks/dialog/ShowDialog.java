package com.cjmkeke.d2rbooks.dialog;

import static android.content.Context.MODE_PRIVATE;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.call.DataCallBack;
import com.cjmkeke.d2rbooks.constants.SharedValue;

public class ShowDialog {
    private SharedPreferences fontSharedPreferences;

    public void ss(Context context, String msg, DataCallBack dataCallBack) {

        fontSharedPreferences = context.getSharedPreferences(SharedValue.FONT_PREFERENCES, MODE_PRIVATE);
        String currentFont = fontSharedPreferences.getString("selectedFont", "nanum"); // 기본값은 nanum
        context.setTheme(currentFont.equals("kodia") ? R.style.kodia : R.style.nanum);

        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_reset);

        // 다이얼로그 배경을 완전 투명하게 설정
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // 다이얼로그 뒤에 있는 액티비티의 투명도(어두운 정도) 설정
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.dimAmount = 0.7f;  // 값이 0에 가까울수록 투명하고, 1에 가까울수록 어둡게 됨
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        TextView exit = dialog.findViewById(R.id.tv_exit);
        TextView ok = dialog.findViewById(R.id.tv_ok);
        TextView message = dialog.findViewById(R.id.tv_messages);
        message.setText(msg);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataCallBack.call();
                dialog.dismiss();
            }
        });

        dialog.setCancelable(false);
        dialog.show();
    }
}
