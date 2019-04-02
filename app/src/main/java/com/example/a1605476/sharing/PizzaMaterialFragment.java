package com.example.a1605476.sharing;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by 1605476 on 15-Jan-18.
 */

public class PizzaMaterialFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView=(RecyclerView) inflater.inflate(R.layout.fragment_pizza_material,container,false);

        String[] pizzaName=new String[Pizza.pizzas.length];
        int[] pizzaImage=new int[Pizza.pizzas.length];
        String[] pizzaPrice=new String[Pizza.pizzas.length];

        for(int i=0;i<Pizza.pizzas.length;i++)
        {
            pizzaName[i]=Pizza.pizzas[i].getName();
        }

        for(int i=0;i<Pizza.pizzas.length;i++)
        {
            pizzaImage[i]=Pizza.pizzas[i].getImageResource();
        }

        for(int i=0;i<Pizza.pizzas.length;i++)
        {
            pizzaPrice[i]=Pizza.pizzas[i].getPrice();
        }

        CaptionedImagesAdapter adapter=new CaptionedImagesAdapter(pizzaName,pizzaImage,pizzaPrice);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),PizzaDetailActivity.class);
                intent.putExtra(PizzaDetailActivity.EXTRA_PIZZANO,position);
                getActivity().startActivity(intent);
            }
        });

        return recyclerView;
    }
}
