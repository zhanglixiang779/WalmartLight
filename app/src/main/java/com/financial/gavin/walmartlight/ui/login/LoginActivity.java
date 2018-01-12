package com.financial.gavin.walmartlight.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.financial.gavin.walmartlight.R;
import com.financial.gavin.walmartlight.WalmartLightApplication;
import com.financial.gavin.walmartlight.data.DataManagerInterface;
import com.financial.gavin.walmartlight.ui.base.BaseActivity;
import com.financial.gavin.walmartlight.ui.main.MainActivity;

public class LoginActivity extends BaseActivity implements LoginView,
		View.OnClickListener {
	
	private LoginPresenterInterface<LoginView> mLoginPresenter;
	EditText mUsername;
	EditText mPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		DataManagerInterface dataManager = WalmartLightApplication.getDataManager();
		mLoginPresenter = new LoginPresenter<>(dataManager);
		mLoginPresenter.onAttach(this);
		mUsername = findViewById(R.id.username_et);
		mPassword = findViewById(R.id.password_et);
		Button login = findViewById(R.id.login_btn);
		Button logout = findViewById(R.id.logout_btn);
		
		login.setOnClickListener(this);
		logout.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		int id = v.getId();
		final int loginId = R.id.login_btn;
		final int logoutId = R.id.logout_btn;
		switch (id) {
			case loginId:
				login();
				break;
			case logoutId:
				mLoginPresenter.initLogout();
		}
	}
	
	@Override
	public void login() {
		String username = mUsername.getText().toString();
		String password = mPassword.getText().toString();
		mLoginPresenter.initLogin(username, password);
	}
	
	@Override
	public void startMainActivity() {
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
}
