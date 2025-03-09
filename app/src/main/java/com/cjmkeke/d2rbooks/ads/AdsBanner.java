//package com.cjmkeke.d2rbooks.ads;
//
//import android.content.Context;
//
//public class AdsBanner {
//
//    private Context context;
//    private AdView adView;
//
//    public AdsBanner(Context context) {
//        this.context = context;
//    }
//
//    public View viewAds(){
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.ads, null);
//
//        MobileAds.initialize(context, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//
//            }
//        });
//
//        adView = view.findViewById(R.id.adview);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        adView.loadAd(adRequest);
//        return view;
//    }
//
//}
