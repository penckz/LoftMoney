package com.penny.loftmoney.screens.additem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.penny.loftmoney.R;
import com.penny.loftmoney.screens.main.adapter.ChargesModel;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);


        final EditText textName = findViewById(R.id.addTextName);
        final EditText textValue = findViewById(R.id.addTextValue);
        Button btnEnter = findViewById(R.id.btnTextEnter);


        btnEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(textName.getText()) && TextUtils.isEmpty(textValue.getText())) {
                    return;
                }

                ChargesModel chargesModel = new ChargesModel(textValue.getText().toString() + " P",
                        textName.getText().toString());


                Intent intent = new Intent();
                intent.putExtra(ChargesModel.KEY_NAME, chargesModel);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
