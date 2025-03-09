package com.cjmkeke.d2rbooks.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;
import android.widget.ImageView;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.call.DataCallBack;

public class ShowRuneWord_XXXXXXXXXXX {

    private Intent intent;

    public void ss(Context context, String msg, DataCallBack dataCallBack) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_runeword_xxxxxxxxxxxxxx);

        // 다이얼로그 배경을 완전 투명하게 설정
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        // 다이얼로그 뒤에 있는 액티비티의 투명도(어두운 정도) 설정
        WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        params.dimAmount = 0.7f;  // 값이 0에 가까울수록 투명하고, 1에 가까울수록 어둡게 됨
        dialog.getWindow().setAttributes(params);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);


        if (intent != null) {
            String rune1 = intent.getStringExtra("rune1");
            String rune2 = intent.getStringExtra("rune2");
            String rune3 = intent.getStringExtra("rune3");
            String rune4 = intent.getStringExtra("rune4");
            String rune5 = intent.getStringExtra("rune5");
            String rune6 = intent.getStringExtra("rune6");

        }

        ImageView rune1 = dialog.findViewById(R.id.iv_rune_1);
        ImageView rune2 = dialog.findViewById(R.id.iv_rune_2);
        ImageView rune3 = dialog.findViewById(R.id.iv_rune_3);
        ImageView rune4 = dialog.findViewById(R.id.iv_rune_4);
        ImageView rune5 = dialog.findViewById(R.id.iv_rune_5);
        ImageView rune6 = dialog.findViewById(R.id.iv_rune_6);

//        TextView exit = dialog.findViewById(R.id.tv_exit);
//        TextView ok = dialog.findViewById(R.id.tv_ok);
//        TextView message = dialog.findViewById(R.id.tv_messages);
//        message.setText(msg);


        dialog.setCancelable(false);
        dialog.show();
    }
}
