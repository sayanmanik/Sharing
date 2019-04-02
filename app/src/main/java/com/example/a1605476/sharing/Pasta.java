package com.example.a1605476.sharing;

/**
 * Created by 1605476 on 16-Jan-18.
 */

public class Pasta
{
    int imageResource;
    String name;
    String price;

    public Pasta(int imageResource,String name,String price)
    {
        this.name=name;
        this.imageResource=imageResource;
        this.price=price;
    }

    public static Pasta[] pasta=
            {new Pasta (R.drawable.spaghetti,"Spaghetti Bolognese","$ 4"),new Pasta(R.drawable.lasagne,"Lasagne","$ 5")};

    public String getName() {
        return name;
    }
    public int getImage()
    {
        return imageResource;
    }
    public String getPrice()
    {
        return price;
    }

}

