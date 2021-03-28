package com.bs.droidaction;

import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText topIeText;
    private TextView topTextView;
    private Button topClearButton;
    private CheckBox showTextCheckbox;
    private TextView showTextOnDelay;
    private SeekBar skb;
    private TextView skbTextview;
    private Switch starSwitch;
    private ImageView starImageView;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topIeText = findViewById(R.id.editTextBox);
        topTextView = findViewById(R.id.nameTextView);
        topClearButton = findViewById(R.id.clearButton);
        showTextCheckbox = findViewById(R.id.showTextCheckBox);
        showTextOnDelay = findViewById(R.id.showTextOnDelay);

        showTextOnDelay.setText(String.valueOf(0));

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
                if (showTextCheckbox.isChecked()) {
                    topTextView.setText(s.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        showTextCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                   @Override
                                                   public void onCheckedChanged(CompoundButton buttonView, final boolean isChecked) {
               if (isChecked) {
                   Runnable r = new Runnable() {
                       public void run() {
                           topTextView.setVisibility(View.VISIBLE);
                           topTextView.setText(topIeText.getText().toString());
                       }
                   };
                   handler.postDelayed(r, Integer.parseInt(showTextOnDelay.getText().toString()));
               } else {
                   topTextView.setVisibility(View.GONE);
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



        starSwitch = (Switch) findViewById(R.id.starSwitch);
        starImageView = (ImageView) findViewById(R.id.starImageView);
        starSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    starImageView.setImageResource(android.R.drawable.btn_star_big_on);
                }
                else{
                    starImageView.setImageResource(android.R.drawable.btn_star_big_off);
                }
            }
        });
    }
}
