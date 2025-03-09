package com.cjmkeke.d2rbooks.settings;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cjmkeke.d2rbooks.R;
import com.cjmkeke.d2rbooks.constants.SharedValue;
import com.cjmkeke.d2rbooks.databinding.ActivityLoginPageBinding;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginPage extends Activity {

    private static final int RC_SIGN_IN = 9001;
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    private ActivityLoginPageBinding mBinding;
    private SharedPreferences fontSharedPreferences;
    private FirebaseUser firebaseUser;

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

        mBinding = ActivityLoginPageBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        // FirebaseAuth 인스턴스 초기화
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();

        // Google 로그인 옵션 구성
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.client_id)) // google-services.json의 클라이언트 ID 사용
                .requestEmail()
                .build();

        // GoogleSignInClient 초기화
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        checkLoginStatus();

        mBinding.signInButton.setOnClickListener(v -> signIn());
        mBinding.tvLogout.setOnClickListener(v -> logout());

    }

    private void logout() {
        mAuth.signOut();
        mGoogleSignInClient.signOut().addOnCompleteListener(this, task -> {
            Toast.makeText(LoginPage.this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
            checkLoginStatus();  // 로그인 상태 갱신
        });
    }

    private void checkLoginStatus() {
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null) {
            // 로그인을 했으면 로그인 타이틀을 가리고
            mBinding.tvLoginTitle.setVisibility(View.GONE);

            // 메인 텍스트에서 환영 메시지를 넣자
            mBinding.tvMainMessages.setText(R.string.login_main_messages_login);

            // 로그인을 했으면 로그인 버튼을 가림
            mBinding.signInButton.setVisibility(View.GONE);

            // 로그아웃 버튼을 활성화
            mBinding.tvLogout.setVisibility(View.VISIBLE);
            mBinding.llMainWelcome.setVisibility(View.VISIBLE);

            Uri uri = firebaseUser.getPhotoUrl();
            if (uri != null) {
                Glide.with(this).load(uri).circleCrop().into(mBinding.ivProfile);
            }

            String email = firebaseUser.getEmail();
            mBinding.tvWelcomeMessage.setText(email + " 님 환영합니다.");

        } else {
            mBinding.tvLoginTitle.setVisibility(View.VISIBLE);
            // 로그인을 하지 않았다면 로그인 버튼을 활성화
            mBinding.tvMainMessages.setText(R.string.login_main_messages_logout);
            mBinding.signInButton.setVisibility(View.VISIBLE);

            // 로그인을 해야하니까 일단 로그아웃 버튼은 활성화
            mBinding.tvLogout.setVisibility(View.GONE);
            mBinding.llMainWelcome.setVisibility(View.GONE);
        }
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Google 로그인 결과 처리
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d("GoogleSignIn", "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                Log.w("GoogleSignIn", "Google sign in failed", e);
                Toast.makeText(this, "로그인 실패: " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // 로그인 성공
                        FirebaseUser user = mAuth.getCurrentUser();
                        Log.d("GoogleSignIn", "signInWithCredential:success");
                        updateUI(user);
                        checkLoginStatus();
                    } else {
                        // 로그인 실패
                        Log.w("GoogleSignIn", "signInWithCredential:failure", task.getException());
                        Toast.makeText(this, "인증 실패", Toast.LENGTH_SHORT).show();
                        updateUI(null);
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Toast.makeText(this, "환영합니다, " + user.getDisplayName(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "로그인되지 않았습니다.", Toast.LENGTH_SHORT).show();
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