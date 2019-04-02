package com.example.a1605476.sharing;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import static com.example.a1605476.sharing.PastaDetailActivity.EXTRA_PASTANO;
import static com.example.a1605476.sharing.PizzaDetailActivity.EXTRA_PIZZANO;

/**
 * Created by 1605476 on 20-Dec-17.
 */

public class TopFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        NestedScrollView layout=(NestedScrollView) inflater.inflate(R.layout.fragment_top,container,false);

        RecyclerView recyclerView=layout.findViewById(R.id.pizza_recycler);
        RecyclerView recyclerView1=layout.findViewById(R.id.pasta_recycler);
        String[] pizzaName=new String[2];
        int [] pizzaImage=new int[2];
        String[] pizzaPrice=new String[2];

        String[] pastaName=new String[2];
        int [] pastaImage=new int[2];
        String[] pastaPrice=new String[2];

        for(int i=0;i<2;i++)
        {
            pizzaName[i]=Pizza.pizzas[i].getName();
        }

        for(int i=0;i<2;i++)
        {
            pizzaImage[i]=Pizza.pizzas[i].getImageResource();
        }

        for(int i=0;i<Pizza.pizzas.length;i++)
        {
            pizzaPrice[i]=Pizza.pizzas[i].getPrice();
        }

        for(int i=0;i<2;i++)
        {
            pastaName[i]=Pasta.pasta[i].getName();
        }

        for(int i=0;i<2;i++)
        {
            pastaImage[i]=Pasta.pasta[i].getImage();
        }

        for(int i=0;i<Pasta.pasta.length;i++)
        {
            pastaPrice[i]=Pasta.pasta[i].getPrice();
        }

        CaptionedImagesAdapter adapter=new CaptionedImagesAdapter(pizzaName,pizzaImage,pizzaPrice);
        recyclerView.setAdapter(adapter);

        CaptionedImagesAdapter adapter1=new CaptionedImagesAdapter(pastaName,pastaImage,pastaPrice);
        recyclerView1.setAdapter(adapter1);

        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);

        GridLayoutManager layoutManager1=new GridLayoutManager(getActivity(),2);
        recyclerView1.setLayoutManager(layoutManager1);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),PizzaDetailActivity.class);
                intent.putExtra(EXTRA_PIZZANO,position);
                getActivity().startActivity(intent);
            }
        });

        adapter1.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),PastaDetailActivity.class);
                intent.putExtra(EXTRA_PASTANO,position);
                getActivity().startActivity(intent);
            }
        });

        return layout;
    }
}
