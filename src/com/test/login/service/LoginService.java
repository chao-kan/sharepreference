package com.test.login.service;

import java.io.IOException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LoginService
{
	/**
	 * 保存用户名和密码的业务方法
	 * @param username 
	 * @param password
	 * @return true 保存成功 false 保存失败
	 * @throws IOException 
	 */
	public static void saveUserInfo(Context context,String username, String password) throws IOException
	{
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		//得到一个sp编辑器
		Editor editor = sp.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		//类似于数据库的事物 保证数据同时提交成功。
		editor.commit();
	}
}
