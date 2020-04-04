package com.songsparrow.notesharing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    private static String mUserID;
    private static boolean mPassFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onClickLogin(View view) {
        String curUser = ((EditText) findViewById(R.id.edt_user_email)).getText().toString();
        String curPswd = ((EditText) findViewById(R.id.edt_pswd)).getText().toString();
        if (curUser.length() == 0 || curPswd.length() == 0) {
            Toast.makeText(this, R.string.empty_user, Toast.LENGTH_SHORT).show();
            return;
        }
        getInternetPermission();
        if (checkInternetPermission()){
            login(curUser,curPswd);
        }
    }

    public void onClickFP(View view) {
        Intent intent = new Intent(this, ResetPswdActivity.class);
        startActivity(intent);
    }

    public void onClickRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void login(final String user, final String pswd){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Connection cn = null;
                Statement st = null;
                ResultSet rs = null;
                try {
                    Class.forName("com.msql.jdbc.Driver");
                    String str = "jdbc:mysql://192.168.1.104:3306/notesharing";
                    String str1 = "root";
                    String str2 = "Zrsyc2531@ZM";
                    cn = DriverManager.getConnection(str, str1, str2);
                    String sql = "select u_id from nsuser where u_pswd='"+pswd+"';";
                    st = cn.createStatement();
                    rs = st.executeQuery(sql);
                    while (rs.next()){
                        if (user.equals(rs.getString("u_id"))){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                    cn.close();
                    st.close();
                    rs.close();
                } catch (ClassNotFoundException cnfe) {
                } catch (SQLException sqle) {
                }finally {
                    cn=null;
                    st = null;
                    rs= null;
                }
            }
        }).start();
    }

    private void getInternetPermission(){
        if(!checkInternetPermission()){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},100);
        }
    }

    private boolean checkInternetPermission(){
        return ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
                == PackageManager.PERMISSION_GRANTED;
    }

}
