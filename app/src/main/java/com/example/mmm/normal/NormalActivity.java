package com.example.mmm.normal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mmm.R;
import com.example.mmm.bean.Account;

import java.util.Random;

public class NormalActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = findViewById(R.id.textView);
        editText.setText("NormalActivity");
    }

    @Override
    public void onClick(View v) {
        String userInput = getUserInput();
        getAccountData(userInput, new MCallBack() {
            @Override
            public void onSuccess(Account account) {
                showSuccessPage(account);
            }

            @Override
            public void onFail() {
                showFailPage();
            }
        });
    }

    //获取用户输入信息
    private String getUserInput() {
        return editText.getText().toString().trim();
    }

    //展示获取信息成功界面
    private void showSuccessPage(Account account) {
        textView.setText("用户账号：" + account.getName() + "|" + "用户等级：" + account.getLevel());
    }

    //展示获取信息失败界面
    private void showFailPage() {
        textView.setText("获取数据失败");
    }

    //查询用户数据
    private void getAccountData(String accountName, MCallBack mCallBack) {
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess) {
            Account account = new Account();
            account.setName(accountName);
            account.setLevel(100);
            mCallBack.onSuccess(account);
        } else {
            mCallBack.onFail();
        }
    }
}
