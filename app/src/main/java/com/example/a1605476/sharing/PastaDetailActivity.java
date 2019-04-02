package com.example.a1605476.sharing;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class PastaDetailActivity extends Activity {

    public static String EXTRA_PASTANO="pastaNo";

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta_detail);

       final Integer pastaNo=(Integer)getIntent().getExtras().get(EXTRA_PASTANO);
       TextView textView=findViewById(R.id.pasta_text);
       ImageView image=findViewById(R.id.pasta_image);

       String pastaName=Pasta.pasta[pastaNo].getName();
       int pastaImage=Pasta.pasta[pastaNo].getImage();

        Drawable drawable=getResources().getDrawable(pastaImage);
        image.setImageDrawable(drawable);
        image.setContentDescription(pastaName);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (pastaNo){
                    case 0:
                        Uri uri=Uri.parse("https://www.google.co.in/search?ei=HTBeWv7_O4KR8gWs9JqADw&q=spaghetti+pasta&oq=spaghetti&gs_l=psy-ab.3.5.35i39k1j0i67k1j0j0i67k1j0l6.93798.98225.0.101804.9.9.0.0.0.0.871.1977.3-2j1j0j1.4.0....0...1c.1.64.psy-ab..5.4.1976...46j0i131k1j0i46k1.0.IbllkHIBYz0");
                        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);

                    case 1:
                        Uri uri1=Uri.parse("https://www.google.co.in/search?ei=6S9eWvrzOoS28QX3t5iYCw&q=lasagne&oq=lasagne&gs_l=psy-ab.3...47935.50058.0.50322.7.7.0.0.0.0.885.885.6-1.1.0....0...1c.1.64.psy-ab..6.1.884...0j35i39k1j0i67k1j0i20i263k1j0i131k1.0.9GvL_B-wpmI");
                        Intent intent1=new Intent(Intent.ACTION_VIEW,uri1);
                        startActivity(intent1);
                }
            }
        });

        textView.setText(pastaName);
       }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        /*TextView textView=findViewById(R.id.pizza_text);
        CharSequence pizzaName=textView.getText();

        MenuItem item=findViewById(R.id.action_share);
        shareActionProvider=(ShareActionProvider) item.getActionProvider();
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,EXTRA_PASTANO);
        intent.setType("text/plain");
        shareActionProvider.setShareIntent(intent);*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId())
       {
           case R.id.action_share:
               Intent intent=new Intent(this,OrderActivity.class);
               startActivity(intent);
               return  true;

           case R.id.create_order:
               Intent intent1=new Intent(this,OrderActivity.class);
               startActivity(intent1);

           default:
               return super.onOptionsItemSelected(item);
       }
    }
}