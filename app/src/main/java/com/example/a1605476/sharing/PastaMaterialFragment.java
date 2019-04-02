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

import static com.example.a1605476.sharing.PastaDetailActivity.EXTRA_PASTANO;

/**
 * Created by 1605476 on 16-Jan-18.
 */

public class PastaMaterialFragment extends Fragment
{
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        RecyclerView recyclerView=(RecyclerView) inflater.inflate(R.layout.fragment_pasta_material,container,false);

        String[] pastaName=new String[Pasta.pasta.length];
        int[] pastaImage=new int[Pasta.pasta.length];
        String[] pastaPrice=new String[Pasta.pasta.length];

        for(int i=0;i<Pasta.pasta.length;i++)
        {
            pastaName[i]=Pasta.pasta[i].getName();
        }

        for(int i=0;i<Pasta.pasta.length;i++)
        {
            pastaImage[i]=Pasta.pasta[i].getImage();
        }

        for(int i=0;i<Pasta.pasta.length;i++)
        {
            pastaPrice[i]=Pasta.pasta[i].getPrice();
        }

        CaptionedImagesAdapter adapter=new CaptionedImagesAdapter(pastaName,pastaImage,pastaPrice);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter.setListener(new CaptionedImagesAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(),PastaDetailActivity.class);
                intent.putExtra(EXTRA_PASTANO,position);
                getActivity().startActivity(intent);
            }
        });
        return recyclerView;
    }
}