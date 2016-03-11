package com.test.login.service;

import java.io.IOException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LoginService
{
	/**
	 * �����û����������ҵ�񷽷�
	 * @param username 
	 * @param password
	 * @return true ����ɹ� false ����ʧ��
	 * @throws IOException 
	 */
	public static void saveUserInfo(Context context,String username, String password) throws IOException
	{
		SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		//�õ�һ��sp�༭��
		Editor editor = sp.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		//���������ݿ������ ��֤����ͬʱ�ύ�ɹ���
		editor.commit();
	}
}
