package com.warmit.stoeff.warmitclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IdActivity extends AppCompatActivity {

    private EditText etTermaId;
    private Button btnSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id);
        initComponents();
        setComponentListeners();
    }

    private void initComponents() {
        etTermaId = (EditText) findViewById(R.id.et_termal_head_id);
        btnSearch = (Button) findViewById(R.id.btn_search);
    }

    private void setComponentListeners() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String termalId = etTermaId.getText().toString();
                //here is your input
            }
        });
    }
}
