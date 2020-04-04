package com.bs.droidaction;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText topIeText;
    private TextView topTextView;
    private Button topClearButton;
    private CheckBox topCheckbox;
    private SeekBar skb;
    private TextView skbTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topIeText = findViewById(R.id.topIeText);
        topTextView = findViewById(R.id.topTextView);
        topClearButton = findViewById(R.id.topClearButton);
        topCheckbox = findViewById(R.id.checkBox);

        topClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topIeText.setText("");
                topTextView.setText("");
            }
        });

        topIeText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (topCheckbox.isChecked()) {
                    topTextView.setText(s.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        topCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                   @Override
                                                   public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if (isChecked) {
                   topTextView.setText(topIeText.getText().toString());
               } else {
                   topTextView.setText("");
               }
               }
           }
        );

        skb = findViewById(R.id.seekBar);
        skbTextview = findViewById(R.id.seekbarTextView);
        skb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skbTextview.setText(progress + "");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
