package com.dheeraj.learning.datastructures.array;

import com.dheeraj.learning.utilities.StringUtil;

public class ShuffleFeatureInMusicPlayer {
    static String[] playlist = new String[10];

    public static void main(String[] args) {
        ShuffleFeatureInMusicPlayer sf = new ShuffleFeatureInMusicPlayer();
        sf.populatePlayList();
        StringUtil.displayStringArray(playlist);
        sf.shuffleAndPlay();
        StringUtil.displayStringArray(playlist);
    }

    private void populatePlayList() {
        for (int index=0;index<playlist.length;index++) {
            playlist[index] = "Song"+index;
        }
    }

    private void shuffleAndPlay() {
        for (int index = 0 ;index < playlist.length; index++) {// For iterating array and decrease the size by one every time.
            //Get random from index to playlist.length (excluding length).
            double random = Math.random();
            int randomItemIndex = index + (int)((playlist.length-index-1)*random);
            //Play the random item (Here sysout)
            System.out.println(playlist[randomItemIndex]);
            //Swap the index item with the random location item.
            String temp = playlist[index];
            playlist[index] = playlist[randomItemIndex];
            playlist[randomItemIndex] = temp;
            //**Swap without third variable.
            //a = a+b
            //b = a-b
            //a = a-b
        }
    }
}
