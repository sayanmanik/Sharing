package com.example.a1605476.sharing;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;

public class MainActivity extends Activity
{
    private String[] titles;
    private ListView drawerList;
    private DrawerLayout drawerLayout;
    private ShareActionProvider shareActionProvider;
    private ActionBarDrawerToggle drawerToggle;
    private int current_position;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        current_position = 0;
        titles=getResources().getStringArray(R.array.titles);
        drawerList=(ListView)findViewById(R.id.drawer);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        drawerList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_activated_1,titles));

        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open_drawer,R.string.close_drawer)
        {
            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        if(savedInstanceState!=null)
        {
            current_position =savedInstanceState.getInt("position");
            selectActionBarTitle(current_position);
        }
        else
        {
          selectItem(0);
        }
        drawerLayout.setDrawerListener(drawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener()
        {
            @Override
            public void onBackStackChanged()
            {
                FragmentManager fragMan=getFragmentManager();
                Fragment fragment=fragMan.findFragmentByTag("visible_fragment");
                if(fragment instanceof TopFragment)
                {
                    current_position=0;
                }
                if(fragment instanceof PizzaMaterialFragment)
                {
                    current_position=1;
                }
                if(fragment instanceof  PastaMaterialFragment)
                {
                    current_position=2;
                }

                selectActionBarTitle(current_position);
                drawerList.setItemChecked(current_position,true);
            }
        });
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean isdrawerOpen=drawerLayout.isDrawerOpen(drawerList);
        menu.findItem(R.id.action_share).setVisible(!isdrawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    private class DrawerItemClickListener implements  AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position)
    {
        Fragment fragment=new Fragment();

        current_position=position;
        switch (position)
        {
            case 0:
                fragment=new TopFragment();
                break;
            case 1:
                fragment=new PizzaMaterialFragment();
                break;
            case 2:
                fragment=new PastaMaterialFragment();
                break;



        }

        android.app.FragmentTransaction ft=getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment,"visible_fragment");
        ft.addToBackStack(null);
        ft.setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        selectActionBarTitle(current_position);
        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("position",current_position);
    }

    private void selectActionBarTitle(int position)
    {
        String title;
        if(position==0)
            title=getResources().getString(R.string.app_name);
        else
        {
            title=titles[position];
        }
        getActionBar().setTitle(title);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem item=menu.findItem(R.id.action_share);
        shareActionProvider=(ShareActionProvider) item.getActionProvider();
        setIntent("this is a text");
        return super.onCreateOptionsMenu(menu);
    }

    private void setIntent(String str)
    {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,str);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {

        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        switch (item.getItemId())
        {
        case R.id.create_order:
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
            return true;
        case R.id.settings:
            return true;
        default:
            return super.onOptionsItemSelected(item);
         }
    }
}