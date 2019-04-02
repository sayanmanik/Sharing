package com.example.a1605476.sharing;

/**
 * Created by 1605476 on 01-Jan-18.
 */

public class Pizza
{
    int imageResource;
    String name;
    String price;

    public Pizza(String name,int imageResource,String price)
    {
        this.name=name;
        this.imageResource=imageResource;
        this.price=price;
    }

   public static final Pizza[]pizzas=
            {new Pizza("Diavolo",R.drawable.diavolo,"$ 5"),new Pizza("Funghi",R.drawable.funghi,"$ 7")};

    public int getImageResource()
    {
        return imageResource;
    }

    public String getName()
    {
        return name;
    }

    public String getPrice()
    {
        return price;
    }
}