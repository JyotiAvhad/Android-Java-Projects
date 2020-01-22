package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    Button btn_zero, btn_one, btn_two, btn_three, btn_four, btn_five, btn_six, btn_seven, btn_eight, btn_nine;
    Button btnadd, btnsub, btnmul, btndiv, btnpercent, btnbackspace, btndot, btnequal, btnclear;

    EditText etshow;

    float vOne, vTwo;

    boolean mAdd, mSub, mMul, mDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etshow = (EditText) findViewById(R.id.et_view);

        btn_zero = (Button) findViewById(R.id.btn_0);
        btn_one = (Button) findViewById(R.id.btn_1);
        btn_two = (Button) findViewById(R.id.btn_2);
        btn_three = (Button) findViewById(R.id.btn_3);
        btn_four = (Button) findViewById(R.id.btn_4);
        btn_five = (Button) findViewById(R.id.btn_5);
        btn_six = (Button) findViewById(R.id.btn_6);
        btn_seven = (Button) findViewById(R.id.btn_7);
        btn_eight = (Button) findViewById(R.id.btn_8);
        btn_nine = (Button) findViewById(R.id.btn_9);

        btnadd = (Button) findViewById(R.id.btn_add);
        btnsub = (Button) findViewById(R.id.btn_sub);
        btnmul = (Button) findViewById(R.id.btn_mul);
        btndiv = (Button) findViewById(R.id.btn_div);
        btndot = (Button) findViewById(R.id.btn_point);
        btnpercent = (Button) findViewById(R.id.btn_percent);
        btnequal = (Button) findViewById(R.id.btn_eql);
        btnbackspace = (Button) findViewById(R.id.btn_backspace);
        btnclear = (Button) findViewById(R.id.btn_c);

        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "0");
            }
        });

        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "1");
            }
        });

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "2");
            }
        });

        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "3");
            }
        });

        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "4");
            }
        });

        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "5");
            }
        });

        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "6");
            }
        });

        btn_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "7");
            }
        });

        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "8");
            }
        });

        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + "9");
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etshow.setText(etshow.getText() + ".");
            }
        });

        btnbackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // etshow.setText(etshow.getText()+" ");
                etshow.setText(" ");
            }
        });

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etshow == null) {
                    etshow.setText("");
                } else {
                    vOne = Float.parseFloat(etshow.getText() + "");
                    mAdd = true;
                    etshow.setText(null);
                }
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etshow == null) {
                    etshow.setText("");
                } else {
                    vOne = Float.parseFloat(etshow.getText() + "");
                    mSub = true;
                    etshow.setText(null);
                }
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etshow == null) {
                    etshow.setText("");
                } else {
                    vOne = Float.parseFloat(etshow.getText() + "");
                    mMul = true;
                    etshow.setText(null);
                }
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etshow == null) {
                    etshow.setText("");
                } else {
                    vOne = Float.parseFloat(etshow.getText() + "");
                    mDiv = true;
                    etshow.setText(null);
                }
            }
        });

        btnpercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vOne = Float.parseFloat(etshow.getText() + "");
                mDiv = true;
                etshow.setText(null);
            }
        });


        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vTwo = Float.parseFloat(etshow.getText() + "");

                if (mAdd == true) {
                    etshow.setText(vOne + vTwo + "");
                    mAdd = false;
                }

                if (mSub == true) {
                    etshow.setText(vOne - vTwo + "");
                    mSub = false;
                }

                if (mMul == true) {
                    etshow.setText(vOne * vTwo + "");
                    mMul = false;
                }

                if (mDiv == true) {
                    etshow.setText(vOne / vTwo + "");
                    mDiv = false;
                }
            }
        });

    }
}
