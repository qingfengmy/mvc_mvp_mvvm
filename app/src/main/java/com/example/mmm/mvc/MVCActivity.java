package com.example.mmm.mvc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mmm.R;
import com.example.mmm.bean.Account;
import com.example.mmm.normal.MCallBack;


public class MVCActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private Button button;
    private TextView textView;
    private MVCModal mvcModal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = findViewById(R.id.textView);
        editText.setText("MVCActivity");

        mvcModal = new MVCModal();
    }

    @Override
    public void onClick(View v) {
        String userInput = getUserInput();
        mvcModal.getAccountData(userInput, new MCallBack() {
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
}
