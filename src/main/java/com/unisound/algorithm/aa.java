package com.unisound.algorithm;

public class aa
{

    public static void main(String[] args)
    {
        Object object = new Object()
        {
            public boolean equals(Object obj)
            {
                return true;
            }
        };
        System.out.println(object.equals("hello"));

        int k = 5;

        while (k-- > 0) {
            System.out.println(k);
        }

    }

}
