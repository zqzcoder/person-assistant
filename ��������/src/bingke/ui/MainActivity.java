package bingke.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	// 【开发步骤】
	// 1. 声明控件：输入用户名的EditText、输入密码的EditText、用于提交的Button
	private EditText etUsername;
	private EditText etPassword;
	private Button btnLogin;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main); // 资源索引

		
		
		
		setViews();
		setListeners();

		
//		startActivity(new Intent(MainActivity.this, MenuActivity.class));
//		Log.i("info", "info");
//		finish();
	}

	
	
	
	private void setListeners() {
		// 4.1. 创建内部类的对象，并配置给“提交按钮”
		InnerOnClickListener listener = new InnerOnClickListener();
		btnLogin.setOnClickListener(listener);
		
		// 4.2. 创建监听器对象，为2个EditText配置监听器
		InnerTextWatcher textWatcher = new InnerTextWatcher();
		etUsername.addTextChangedListener(textWatcher);
		etPassword.addTextChangedListener(textWatcher);
		
	}

	private void setViews() {
		// 2. 初始化控件：即使用findViewById()方法为各控件对象赋值
		etUsername = (EditText) findViewById(R.id.et_username);
		etPassword = (EditText) findViewById(R.id.et_password);
		btnLogin = (Button) findViewById(R.id.btn_login);
		
	}

	// 3.1. 使用成员内部类的语法，声明内部类，实现点击监听器的接口
	private class InnerOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// 【实现监听器方法】
			// 1. 获取2个EditText中输入的内容，并赋值给2个变量
			String username = etUsername.getText().toString().trim();
			String password = etPassword.getText().toString();

			// 2. |验证数据的有效性：即判断用户输入的内容是否合法
//			if (username.length() < 4 || password.length() < 4) {
//				Toast.makeText(MainActivity.this, "用户名或密码输入错误！！！",
//						Toast.LENGTH_SHORT).show();
//				return;
//			} 

			// 3. 判断用户输入的用户名和密码是否匹配admin/admin888，并使用Toast提示
			// if(username.equals("admin")) // 不推荐 // username = null; //
			// NullPointerException
			if ("admin".equals(username) && "admin888".equals(password)) {
//				Toast.makeText(MainActivity.this, "登录成功 @^_^@",
//						Toast.LENGTH_SHORT).show();
				startActivity(new Intent(MainActivity.this, MenuActivity.class));
				Log.i("info", "info");
				finish();
			} else {
				Toast.makeText(MainActivity.this, "登录失败！用户名或密码错误！！！",
						Toast.LENGTH_SHORT).show();
			}
		}


	}


	// 3.2. 声明内部类，实现监听EditText输入内容发生变化的接口
	private class InnerTextWatcher implements TextWatcher {

		@Override
		public void afterTextChanged(Editable s) {
			// 如果用户名和密码的长度都至少4个字符，则启用按钮，否则，禁用按钮

			// 1. 获取2个EditText中输入的内容，并赋值给2个变量
			String username = etUsername.getText().toString().trim();
			String password = etPassword.getText().toString();

			// 2. 验证数据的有效性：即判断用户输入的内容是否合法
			// if (username.length() < 4 || password.length() < 4) {
			// 	btnLogin.setEnabled(false);
			// } else {
			// 	btnLogin.setEnabled(true);
			// }
			btnLogin.setEnabled(username.length() >= 4 && password.length() >= 4);
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
		}

	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}



