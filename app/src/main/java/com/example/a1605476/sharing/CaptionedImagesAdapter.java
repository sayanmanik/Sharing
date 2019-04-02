package com.example.a1605476.sharing;

import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 1605476 on 15-Jan-18.
 */

public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>
{
    private String[] captions;
    private int[] imageIds;
    private String[]priceIds;
    private Listener listener;

    public static interface Listener
    {
        public void onClick(int position);
    }

    public void setListener(Listener listener)
    {
        this.listener=listener;
    }

    public CaptionedImagesAdapter (String[] captions,int[] imageIds,String[] price)
    {
        this.captions=captions;
        this.imageIds=imageIds;
        this.priceIds=price;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        CardView cardView;
        public ViewHolder(CardView itemView)
        {
            super(itemView);
            cardView=itemView;
        }
    }

    @Override
    public CaptionedImagesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        CardView cv=(CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_captioned_image,parent,false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CaptionedImagesAdapter.ViewHolder holder,final int position)
    {
        CardView cardView=holder.cardView;
        ImageView imageView=(ImageView)cardView.findViewById(R.id.info_image);
        Drawable drawable=cardView.getResources().getDrawable(imageIds[position]);
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(captions[position]);
        TextView textView1=cardView.findViewById(R.id.info_text);
        textView1.setText(captions[position]);
        TextView textView2=cardView.findViewById(R.id.price_text);
        textView2.setText(priceIds[position]);

        cardView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                listener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return captions.length;
    }
}
