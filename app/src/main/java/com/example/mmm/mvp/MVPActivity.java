package com.example.mmm.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mmm.R;
import com.example.mmm.bean.Account;
import com.example.mmm.mvc.MVCModal;
import com.example.mmm.normal.MCallBack;


public class MVPActivity extends AppCompatActivity implements View.OnClickListener, MVPActivity_Interface {
    private EditText editText;
    private Button button;
    private TextView textView;
    private MVPPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        textView = findViewById(R.id.textView);
        editText.setText("MVPActivity");
        presenter = new MVPPresenter(this);
    }

    @Override
    public void onClick(View v) {
        String userInput = getUserInput();
        presenter.getAccountData(userInput);
    }

    //获取用户输入信息
    private String getUserInput() {
        return editText.getText().toString().trim();
    }

    //展示获取信息成功界面
    @Override
    public void showSuccessPage(Account account) {
        textView.setText("用户账号：" + account.getName() + "|" + "用户等级：" + account.getLevel());
    }

    //展示获取信息失败界面
    @Override
    public void showFailPage() {
        textView.setText("获取数据失败");
    }
}
