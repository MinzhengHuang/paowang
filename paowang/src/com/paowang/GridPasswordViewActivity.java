package com.paowang;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.paowang.gridpasswordview.GridPasswordView;
import com.paowang.gridpasswordview.PasswordType;


public class GridPasswordViewActivity extends Activity {
    private GridPasswordView gpvNormal;
    private GridPasswordView gpvLength;
    private GridPasswordView gpvTransformation;
    private GridPasswordView gpvPasswordType;
    private GridPasswordView gpvCustomUi;
    private GridPasswordView gpvNormalTwice;

    Spinner pswtypeSp;
    Switch pswSwitch;

    boolean isFirst = true;
    String firstPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridpassword);
        gpvNormal=(GridPasswordView)findViewById(R.id.gpv_normal);
        gpvLength=(GridPasswordView)findViewById(R.id.gpv_length);
        gpvTransformation=(GridPasswordView)findViewById(R.id.gpv_transformation);
        gpvPasswordType=(GridPasswordView)findViewById(R.id.gpv_passwordType);
        gpvCustomUi=(GridPasswordView)findViewById(R.id.gpv_customUi);
        gpvNormalTwice=(GridPasswordView)findViewById(R.id.gpv_normail_twice);
        pswtypeSp=(Spinner)findViewById(R.id.pswtype_sp);
        pswSwitch=(Switch)findViewById(R.id.psw_visibility_switcher);
        pswSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                gpvPasswordType.togglePasswordVisibility();
            }
        });
//        toolbar.setTitle(R.string.app_name);
        pswtypeSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        gpvPasswordType.setPasswordType(PasswordType.NUMBER);
                        break;

                    case 1:
                        gpvPasswordType.setPasswordType(PasswordType.TEXT);
                        break;

                    case 2:
                        gpvPasswordType.setPasswordType(PasswordType.TEXTVISIBLE);
                        break;

                    case 3:
                        gpvPasswordType.setPasswordType(PasswordType.TEXTWEB);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        onPwdChangedTest();
    }


    // Test GridPasswordView.clearPassword() in OnPasswordChangedListener.
    // Need enter the password twice and then check the password , like Alipay
    void onPwdChangedTest() {
        gpvNormalTwice.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            @Override
            public void onChanged(String psw) {
                if (psw.length() == 6 && isFirst) {
                    gpvNormalTwice.clearPassword();
                    isFirst = false;
                    firstPwd = psw;
                } else if (psw.length() == 6 && !isFirst) {
                    if (psw.equals(firstPwd)) {
                        Log.d("main", "The password is: " + psw);
                    } else {
                        Log.d("main", "password doesn't match the previous one, try again!");
                        gpvNormalTwice.clearPassword();
                        isFirst = true;
                    }
                }
            }

            @Override
            public void onMaxLength(String psw) {

            }
        });
    }

}
