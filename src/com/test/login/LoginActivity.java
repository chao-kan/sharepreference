package com.test.login;

import java.io.IOException;

import com.test.login.service.LoginService;
import com.test.sharedpreference.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
//import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	private static final String TAG = "LoginActivity";
	private EditText et_username;
	private EditText et_password;
	private CheckBox cb;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
       et_username = (EditText)findViewById(R.id.et_username);
       et_password =(EditText)findViewById(R.id.et_password);
       cb = (CheckBox)findViewById(R.id.cb_remember_pwd);
       
       SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
       String username = sp.getString("username", "");
       et_username.setText(username);
       String password = sp.getString("password", "");
       et_password.setText(password);
    }

    /**
     * ��¼
     * @param view
     * @throws IOException 
     */
    public void login(View view) throws IOException
    {
    	String username = et_username.getText().toString().trim();
    	String password = et_password.getText().toString().trim();
    	
    	if(TextUtils.isEmpty(username)||TextUtils.isEmpty(username))
    	{
    		Toast.makeText(this,"�û��������벻��Ϊ��", Toast.LENGTH_SHORT).show();
    	}
    	else
    	{
    		if(cb.isChecked())
    		{
    			//�����û�������
    			Log.i(TAG,"��Ҫ�����û���������");
    		    LoginService.saveUserInfo(this,username, password);

    			Toast.makeText(this, "�����û���Ϣ�ɹ�", Toast.LENGTH_SHORT).show();//��������.show()��ô��������ʾ���������û���Ϣ�ɹ���
    		}
    		//������Ϣ������������������֤�Ƿ���ȷ��
    		if("username".equals(username) && "123456".equals(password))
    		{
    			Toast.makeText(this,"��¼�ɹ�", Toast.LENGTH_SHORT).show();
    		}
    		else
    		{
    			Toast.makeText(this,"��¼ʧ�ܣ��û������������", Toast.LENGTH_SHORT).show();
    		}
    	}
    }
    
}
