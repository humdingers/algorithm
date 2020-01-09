package com.unisound.algorithm;

import java.util.Arrays;
import java.util.Random;

public class Shuffle
{
    public static void shuffleCard(int[] cards)
    {
        if (cards == null || cards.length == 0)
            return;

        Random rand = new Random();
        for (int i = 0; i < cards.length; i++) {
            int k = rand.nextInt(i + 1); // 0~i (inclusive)
            System.out.print(k);
            int temp = cards[i];
            cards[i] = cards[k];
            cards[k] = temp;
        }
    }

    public static void main(String[] args)
    {
        int[] cards = new int[] {2, 4, 1, 5};
        shuffleCard(cards);
        System.out.print(Arrays.toString(cards));

    }

}
