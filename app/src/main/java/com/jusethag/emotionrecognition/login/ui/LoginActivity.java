package com.jusethag.emotionrecognition.login.ui;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.jusethag.emotionrecognition.EmotionRecognitionApp;
import com.jusethag.emotionrecognition.R;
import com.jusethag.emotionrecognition.login.LoginPresenter;
import com.jusethag.emotionrecognition.main.ui.MainListActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @Bind(R.id.login_container)
    RelativeLayout layoutContainer;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;
    @Bind(R.id.inputEmail)
    EditText inputEmail;
    @Bind(R.id.inpuPassword)
    EditText inputPassword;
    @Bind(R.id.btnSignin)
    Button btnSignin;
    @Bind(R.id.btnSignup)
    Button btnSignup;

    @Inject
    LoginPresenter loginPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);



        setupInjection();

        loginPresenter.onCreate();
        loginPresenter.logIn(null, null);

    }

    @Override
    protected void onDestroy() {
        loginPresenter.onDestroy();
        super.onDestroy();
    }

    private void setupInjection() {
        EmotionRecognitionApp app = (EmotionRecognitionApp) getApplication();
        app.getLoginComponent(this).inject(this);
    }

    @Override
    public void enableUIElements() {
        setInputs(true);
    }

    @Override
    public void disableUIElements() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void shakeEmailInput() {
        YoYo.with(Techniques.Tada).duration(700)
                .playOn(inputEmail);
    }

    @Override
    public void shakePasswordInput() {
        YoYo.with(Techniques.Tada).duration(700)
                .playOn(inputPassword);
    }

    @Override
    @OnClick(R.id.btnSignup)
    public void handleSignUp() {
        loginPresenter.signUp(inputEmail.getText().toString().trim(),
                inputPassword.getText().toString().trim());
    }

    @Override
    @OnClick(R.id.btnSignin)
    public void handleSignIn() {
        loginPresenter.logIn(inputEmail.getText().toString().trim(),
                inputPassword.getText().toString().trim());
    }

    @Override
    public void navigateToMainScreen() {
        //No history attribute on AndroidManifest
        startActivity(new Intent(this, MainListActivity.class));
    }

    @Override
    public void loginError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        inputPassword.setError(msgError);
    }

    @Override
    public void signUpSuccess() {
        Snackbar.make(layoutContainer, R.string.login_notice_message_useradded,
                Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void signUpError(String error) {
        inputPassword.setError("");
        String msgError = String.format(getString(R.string.login_error_message_signup), error);
        inputPassword.setError(msgError);
    }

    private void setInputs(boolean enabled) {
        inputEmail.setEnabled(enabled);
        inputPassword.setEnabled(enabled);
        btnSignin.setEnabled(enabled);
        btnSignup.setEnabled(enabled);
    }
}
