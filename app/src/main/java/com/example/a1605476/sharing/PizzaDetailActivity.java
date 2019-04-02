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

public class PizzaDetailActivity extends Activity {

    public static String EXTRA_PIZZANO="pizzano";
    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        getActionBar().setHomeButtonEnabled(true);

        final Integer pizzaInt=(Integer) getIntent().getExtras().get(EXTRA_PIZZANO);

        String pizzaName=Pizza.pizzas[pizzaInt].getName();
        int pizzaImage=Pizza.pizzas[pizzaInt].getImageResource();

        ImageView imageView=findViewById(R.id.pizza_image);
        Drawable drawable=getResources().getDrawable(pizzaImage);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(pizzaName);
        TextView textView=findViewById(R.id.pizza_text);
        textView.setText(pizzaName);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (pizzaInt)
                {
                    case 0:
                        Uri uri1=Uri.parse("https://www.google.co.in/search?ei=Bi5eWuOIDcr98QWFrYSQBw&q=diavolo+pizza&oq=diavolo+&gs_l=psy-ab.3.0.35i39k1j0l9.91916.94922.0.95985.8.8.0.0.0.0.1055.2499.5-1j1j1.3.0....0...1c.1.64.psy-ab..5.3.2496...0i67k1j0i131k1j0i46i67k1j46i67k1.0.lYUHOMCDs0Q");
                        Intent intent1=new Intent(Intent.ACTION_VIEW,uri1);
                        startActivity(intent1);
                        case 1:
                        Uri uri2=Uri.parse("https://www.google.co.in/search?q=funghi+pizza&oq=funghi+&aqs=chrome.1.69i57j0l5.3512j0j1&sourceid=chrome&ie=UTF-8");
                        Intent intent2=new Intent(Intent.ACTION_VIEW,uri2);
                        startActivity(intent2);


                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        TextView textView=findViewById(R.id.pizza_text);
        CharSequence pizzaName=textView.getText();
        MenuItem menuItem=menu.findItem(R.id.action_share);
        shareActionProvider=(ShareActionProvider)menuItem.getActionProvider();
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,EXTRA_PIZZANO);
        intent.setType("text/plain");
        shareActionProvider.setShareIntent(intent);
        return  true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_share:
                Intent intent=new Intent(this,OrderActivity.class);
                startActivity(intent);
                return true;

            case R.id.create_order:
                Intent intent1=new Intent(this,OrderActivity.class);
                startActivity(intent1);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}