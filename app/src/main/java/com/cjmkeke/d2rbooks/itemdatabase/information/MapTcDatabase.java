package com.cjmkeke.d2rbooks.itemdatabase.information;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.databinding.FragmentMapTcDatabaseBinding;

public class MapTcDatabase extends Fragment {

    private final String TAG = "MapTcDatabase";
    private FragmentMapTcDatabaseBinding mBinding;
    private boolean isNightmare = true;
    private boolean isHell = false;
    private boolean isNightmareAct1 = true;
    private boolean isNightmareAct2 = false;
    private boolean isNightmareAct3 = false;
    private boolean isNightmareAct4 = false;
    private boolean isNightmareAct5 = false;
    private boolean isHellAct1 = true;
    private boolean isHellAct2 = false;
    private boolean isHellAct3 = false;
    private boolean isHellAct4 = false;
    private boolean isHellAct5 = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentMapTcDatabaseBinding.inflate(inflater, container, false);

        final int actSelectResId = getResources().getIdentifier("dw_act_select", "drawable", getActivity().getPackageName());
        final int actNoneResId = getResources().getIdentifier("dw_normal", "drawable", getActivity().getPackageName());
        final int act1BackgroundId = getResources().getIdentifier("background_act1", "drawable", getActivity().getPackageName());
        final int act2BackgroundId = getResources().getIdentifier("background_act2", "drawable", getActivity().getPackageName());
        final int act3BackgroundId = getResources().getIdentifier("background_act3", "drawable", getActivity().getPackageName());
        final int act4BackgroundId = getResources().getIdentifier("background_act4", "drawable", getActivity().getPackageName());
        final int act5BackgroundId = getResources().getIdentifier("background_act5", "drawable", getActivity().getPackageName());

        final int noneResDefaultId = getResources().getIdentifier("dw_uber_title", "drawable", getActivity().getPackageName());
        final int selectResId = getResources().getIdentifier("dw_message", "drawable", getActivity().getPackageName());
        final String selectResColor = "#7E1D1D";
        final String noneResColor = "#D4C491";

        mBinding.tvTabNightmare.setBackgroundResource(selectResId);
        mBinding.tvAct1.setBackgroundResource(actSelectResId);

//        View view = LayoutInflater.from(getContext()).inflate(R.layout.map_tc_act1_nightmare, container, false);
//        TextView linkTo = view.findViewById(R.id.tv_act1_nightmare);
//        linkTo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.w(TAG, "123123");
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.chaoscube.co.kr/"));
//                startActivity(intent);
//            }
//        });

        setViewChange("map_tc_act1_nightmare", R.id.tv_act1_nightmare);

        mBinding.tvTabNightmare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSwitch(true, false);
                Log.w(TAG, "isNightmareAct1 : " + isNightmareAct1);
                Log.w(TAG, "isNightmareAct2 : " + isNightmareAct2);
                Log.w(TAG, "isNightmareAct3 : " + isNightmareAct3);
                Log.w(TAG, "isNightmareAct4 : " + isNightmareAct4);
                Log.w(TAG, "isNightmareAct5 : " + isNightmareAct5);
                Log.w(TAG, "isNightmare : " + isNightmare);
                Log.w(TAG, "isHell : " + isHell);
                mBinding.tvTabNightmare.setBackgroundResource(selectResId);
                mBinding.tvTabNightmare.setTextColor(Color.parseColor(noneResColor));
                mBinding.tvTabHell.setBackgroundResource(noneResDefaultId);
                mBinding.tvTabHell.setTextColor(Color.BLACK);

                if (isNightmare && isNightmareAct1) {
                    setViewChange(v, "map_tc_act1_nightmare", R.id.tv_act1_nightmare);
                }
                if (isNightmare && isNightmareAct2) {
                    setViewChange(v, "map_tc_act2_nightmare", R.id.tv_act2_nightmare);
                }
                if (isNightmare && isNightmareAct3) {
                    setViewChange(v, "map_tc_act3_nightmare", R.id.tv_act3_nightmare);
                }
                if (isNightmare && isNightmareAct4) {
                    setViewChange(v, "map_tc_act4_nightmare", R.id.tv_act4_nightmare);
                }
                if (isNightmare && isNightmareAct5) {
                    setViewChange(v, "map_tc_act5_nightmare", R.id.tv_act5_nightmare);
                }
            }
        });


        mBinding.tvTabHell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTabSwitch(false, true);
                Log.w(TAG, "isHellAct1 : " + isHellAct1);
                Log.w(TAG, "isHellAct2 : " + isHellAct2);
                Log.w(TAG, "isHellAct3 : " + isHellAct3);
                Log.w(TAG, "isHellAct4 : " + isHellAct4);
                Log.w(TAG, "isHellAct5 : " + isHellAct5);
                Log.w(TAG, "isNightmare : " + isNightmare);
                Log.w(TAG, "isHell : " + isHell);
                mBinding.tvTabNightmare.setBackgroundResource(noneResDefaultId);
                mBinding.tvTabNightmare.setTextColor(Color.BLACK);
                mBinding.tvTabHell.setBackgroundResource(selectResId);
                mBinding.tvTabHell.setTextColor(Color.parseColor(noneResColor));

                if (isHell && isHellAct1) {
                    setViewChange(v, "map_tc_act1_hell", R.id.tv_act1_hell);
                }
                if (isHell && isHellAct2) {
                    setViewChange(v, "map_tc_act2_hell", R.id.tv_act2_hell);
                }
                if (isHell && isHellAct3) {
                    setViewChange(v, "map_tc_act3_hell", R.id.tv_act3_hell);
                }
                if (isHell && isHellAct4) {
                    setViewChange(v, "map_tc_act4_hell", R.id.tv_act4_hell);
                }
                if (isHell && isHellAct5) {
                    setViewChange(v, "map_tc_act5_hell", R.id.tv_act5_hell);
                }

            }
        });

        mBinding.tvAct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isActNightmareLevel(true, false, false, false, false);
                isActHellLevel(true, false, false, false, false);
                if (isNightmare) {
                    setViewChange(v, "map_tc_act1_nightmare", R.id.tv_act1_nightmare);
                } else if (isHell) {
                    setViewChange(v, "map_tc_act1_hell", R.id.tv_act1_hell);
                }

                mBinding.flMapTcBackground.setBackgroundResource(act1BackgroundId);
                mBinding.tvAct1.setBackgroundResource(actSelectResId);
                mBinding.tvAct2.setBackgroundResource(actNoneResId);
                mBinding.tvAct3.setBackgroundResource(actNoneResId);
                mBinding.tvAct4.setBackgroundResource(actNoneResId);
                mBinding.tvAct5.setBackgroundResource(actNoneResId);
            }
        });

        mBinding.tvAct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isActNightmareLevel(false, true, false, false, false);
                isActHellLevel(false, true, false, false, false);
                if (isNightmare) {
                    setViewChange(v, "map_tc_act2_nightmare", R.id.tv_act2_nightmare);
                } else if (isHell) {
                    setViewChange(v, "map_tc_act2_hell", R.id.tv_act2_hell);
                }

                mBinding.flMapTcBackground.setBackgroundResource(act2BackgroundId);
                mBinding.tvAct1.setBackgroundResource(actNoneResId);
                mBinding.tvAct2.setBackgroundResource(actSelectResId);
                mBinding.tvAct3.setBackgroundResource(actNoneResId);
                mBinding.tvAct4.setBackgroundResource(actNoneResId);
                mBinding.tvAct5.setBackgroundResource(actNoneResId);
            }
        });

        mBinding.tvAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isActNightmareLevel(false, false, true, false, false);
                isActHellLevel(false, false, true, false, false);
                if (isNightmare) {
                    setViewChange(v, "map_tc_act3_nightmare", R.id.tv_act3_nightmare);
                } else if (isHell) {
                    setViewChange(v, "map_tc_act3_hell", R.id.tv_act3_hell);
                }

                mBinding.flMapTcBackground.setBackgroundResource(act3BackgroundId);
                mBinding.tvAct1.setBackgroundResource(actNoneResId);
                mBinding.tvAct2.setBackgroundResource(actNoneResId);
                mBinding.tvAct3.setBackgroundResource(actSelectResId);
                mBinding.tvAct4.setBackgroundResource(actNoneResId);
                mBinding.tvAct5.setBackgroundResource(actNoneResId);
            }
        });

        mBinding.tvAct4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isActNightmareLevel(false, false, false, true, false);
                isActHellLevel(false, false, false, true, false);
                if (isNightmare) {
                    setViewChange(v, "map_tc_act4_nightmare", R.id.tv_act4_nightmare);
                } else if (isHell) {
                    setViewChange(v, "map_tc_act4_hell", R.id.tv_act4_hell);
                }

                mBinding.flMapTcBackground.setBackgroundResource(act4BackgroundId);
                mBinding.tvAct1.setBackgroundResource(actNoneResId);
                mBinding.tvAct2.setBackgroundResource(actNoneResId);
                mBinding.tvAct3.setBackgroundResource(actNoneResId);
                mBinding.tvAct4.setBackgroundResource(actSelectResId);
                mBinding.tvAct5.setBackgroundResource(actNoneResId);
            }
        });

        mBinding.tvAct5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isActHellLevel(false, false, false, false, true);
                isActNightmareLevel(false, false, false, false, true);
                if (isNightmare) {
                    setViewChange(v, "map_tc_act5_nightmare", R.id.tv_act5_nightmare);
                } else if (isHell) {
                    setViewChange(v, "map_tc_act5_hell", R.id.tv_act5_hell);
                }

                mBinding.flMapTcBackground.setBackgroundResource(act5BackgroundId);
                mBinding.tvAct1.setBackgroundResource(actNoneResId);
                mBinding.tvAct2.setBackgroundResource(actNoneResId);
                mBinding.tvAct3.setBackgroundResource(actNoneResId);
                mBinding.tvAct4.setBackgroundResource(actNoneResId);
                mBinding.tvAct5.setBackgroundResource(actSelectResId);
            }
        });

        return mBinding.getRoot();
    }

    private void setViewChange(String layout, int findViewById) {
        int layoutId = getResources().getIdentifier(layout, "layout", getActivity().getPackageName());
        View view = LayoutInflater.from(getContext()).inflate(layoutId, null);
        mBinding.flMapTcFragment.removeAllViews(); // 기존 레이아웃 제거
        mBinding.flMapTcFragment.addView(view); // 새로운 레이아웃 추가
        TextView titleLink = view.findViewById(findViewById);
        titleLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.chaoscube.co.kr/"));
                startActivity(intent);
            }
        });
    }

    private void setViewChange(View v, String layout, int findViewById) {
        int layoutId = getResources().getIdentifier(layout, "layout", getActivity().getPackageName());
        View view = LayoutInflater.from(v.getContext()).inflate(layoutId, null);
        mBinding.flMapTcFragment.removeAllViews(); // 기존 레이아웃 제거
        mBinding.flMapTcFragment.addView(view); // 새로운 레이아웃 추가
        TextView titleLink = view.findViewById(findViewById);
        titleLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.chaoscube.co.kr/"));
                startActivity(intent);
            }
        });
    }

    private void isActNightmareLevel(boolean a, boolean b, boolean c, boolean d, boolean e) {
        isNightmareAct1 = a;
        isNightmareAct2 = b;
        isNightmareAct3 = c;
        isNightmareAct4 = d;
        isNightmareAct5 = e;
    }

    private void isActHellLevel(boolean a, boolean b, boolean c, boolean d, boolean e) {
        isHellAct1 = a;
        isHellAct2 = b;
        isHellAct3 = c;
        isHellAct4 = d;
        isHellAct5 = e;
    }

    private void setTabSwitch(boolean a, boolean b) {
        isNightmare = a;
        isHell = b;
    }
}