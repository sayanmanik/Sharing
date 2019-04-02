package com.example.a1605476.sharing;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderActivity extends Activity {


    TextView text;
    CheckBox check1, check2, check3, check4;
    String input;
    Button button;
    int qty, total;
    int item1, item2, item3, item4;
    int price1,price2,price3,price4;
    TextView txt1, txt2, txt3, txt4,priceText;
    ImageButton first_plus,second_plus,third_plus,fourth_plus,first_minus,second_minus,third_minus,fourth_minus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        text = findViewById(R.id.txt);
        check1 = findViewById(R.id.check1);
        check2 = findViewById(R.id.check2);
        check3 = findViewById(R.id.check3);
        check4 = findViewById(R.id.check4);
        button = findViewById(R.id.btn);

        txt1 = findViewById(R.id.first_text);
        txt2 = findViewById(R.id.second_text);
        txt3 = findViewById(R.id.third_text);
        txt4 = findViewById(R.id.fourth_text);
        priceText=findViewById(R.id.textPrice);

        first_plus=findViewById(R.id.first_plus);
        second_plus=findViewById(R.id.second_plus);
        third_plus=findViewById(R.id.third_plus);
        fourth_plus=findViewById(R.id.fourth_plus);

        first_minus=findViewById(R.id.first_minus);
        second_minus=findViewById(R.id.second_minus);
        third_minus=findViewById(R.id.third_minus);
        fourth_minus=findViewById(R.id.fourth_minus);

        if(savedInstanceState!=null)
        {
            item1 = savedInstanceState.getInt("item1");
            item2 = savedInstanceState.getInt("item2");
            item3 = savedInstanceState.getInt("item3");
            item4 = savedInstanceState.getInt("item4");

            price1=savedInstanceState.getInt("price1");
            price2=savedInstanceState.getInt("price2");
            price3=savedInstanceState.getInt("price3");
            price4=savedInstanceState.getInt("price4");
            total=savedInstanceState.getInt("total");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("item1",item1);
        outState.putInt("item2",item2);
        outState.putInt("item3",item3);
        outState.putInt("item4",item4);

        outState.putInt("price1",price1);
        outState.putInt("price2",price2);
        outState.putInt("price3",price3);
        outState.putInt("price4",price4);
        outState.putInt("total",total);
    }

    @Override
    protected void onStart() {
        super.onStart();

        first_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item1++;
                price1=item1*5;
                if(item1>0)
                check1.setChecked(true);
                txt1.setText(String.valueOf(item1));
                total=price1+price2+price3+price4;
                priceText.setText("$ "+String.valueOf(total));

            }
        });

        second_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item2++;
                price2=item2*7;
                if(item2>0)
                check2.setChecked(true);
                txt2.setText(String.valueOf(item2));
                total=price1+price2+price3+price4;
                priceText.setText("$ "+String.valueOf(total));
            }
        });


        third_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item3++;
                price3=item3*4;
                if(item3>0)
                check3.setChecked(true);
                txt3.setText(String.valueOf(item3));
                total=price1+price2+price3+price4;
                priceText.setText("$ "+String.valueOf(total));
            }
        });

        fourth_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item4++;
                price4=item4*5;
                if(item4>0)
                check4.setChecked(true);
                txt4.setText(String.valueOf(item4));
                total=price1+price2+price3+price4;
                priceText.setText("$ "+String.valueOf(total));
            }
        });

        first_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item1--;
                if(item1==0)
                {
                    check1.setChecked(false);
                }
                if(item1<0)
                {
                    item1=0;
                    Toast.makeText(OrderActivity.this,"You cannot have less than an item",Toast.LENGTH_SHORT).show();
                }
                price1=item1*5;
                txt1.setText(String.valueOf(item1));
                total=price1+price2+price3+price4;
                priceText.setText("$ "+String.valueOf(total));
            }


        });

        second_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item2--;
                if(item2==0)
                {
                    check2.setChecked(false);
                }
                if(item2<0)
                {
                    item2=0;
                    Toast.makeText(OrderActivity.this,"You cannot have less than an item",Toast.LENGTH_SHORT).show();
                }
                price2=item2*7;
                txt2.setText(String.valueOf(item2));
                total=price1+price2+price3+price4;
                priceText.setText("$ "+String.valueOf(total));
            }
        });

        third_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item3--;
                if(item3==0)
                {
                    check3.setChecked(false);
                }
                if(item3<0)
                {
                    item3=0;
                    Toast.makeText(OrderActivity.this,"You cannot have less than an item",Toast.LENGTH_SHORT).show();
                }
                price3=item3*4;
                txt3.setText(String.valueOf(item3));
                total=price1+price2+price3+price4;
                priceText.setText("$ "+String.valueOf(total));
            }
        });
        fourth_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item4--;
                if(item4==0)
                {
                    check4.setChecked(false);
                }
                if(item4<0)
                {
                    item4=0;
                    Toast.makeText(OrderActivity.this,"You cannot have less than an item",Toast.LENGTH_SHORT).show();
                }
                price4=item4*5;
                txt4.setText(String.valueOf(item4));
                total=price1+price2+price3+price4;
                priceText.setText("$ "+String.valueOf(total));
            }
        });
    }

    public void check_first(View v) {

        boolean checked = ((CheckBox) v).isChecked();

        switch (v.getId()) {
            case R.id.check1:
                if (checked) {
                    item1 = 1;
                    txt1.setText(String.valueOf(item1));
                }
                else
                {
                    item1 = 0;
                    txt1.setText(String.valueOf(item1));
                }
                break;
            case R.id.check2:
                if (checked) {
                    item2 = 1;
                    txt2.setText(String.valueOf(item2));
                }
                else
                {
                    item2 = 0;
                    txt2.setText(String.valueOf(item2));
                }
                break;
            case R.id.check3:
                if (checked)
                {
                    item3 = 1;
                    txt3.setText(String.valueOf(item3));
                }
                else
                {
                    item3 = 0;
                    txt3.setText(String.valueOf(item3));
                }
                break;
            case R.id.check4:
                if (checked)
                {
                    item4 = 1;
                    txt4.setText(String.valueOf(item4));
                }
                else
                {
                    item4 = 0;
                    txt4.setText(String.valueOf(item4));
                }
        }
    }


}