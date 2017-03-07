package phototomusic.nanter1986.com.phototomusic;

import android.util.Log;

import com.leff.midi.MidiTrack;

import java.util.ArrayList;

/**
 * Created by nanter1986 on 28/11/2016.
 */
public class ColortoMelody {
    final static int channelMelody = 1;
    final static int channelMelodyHigh = 5;

    public static int ColorToMelodyVerse(ArrayList<Integer>scale,int previous, String colorM, String colorR, MidiTrack noteTrack, long when, long duration, int transpose) {
        int v = 120;
        int indexPrevious = previous;
        int newIndex = 0;
        int whenInt=(int)(when/duration);
        int modifier=whenInt%4;
        Log.i("modulusVerse", whenInt+ " = " +modifier );
        if (modifier == 0) {
            switch (colorM) {
                case "white":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration);

                    break;
                case "yellow":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when , duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 2 / 4, duration / 2);
                    break;
                case "cyan":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when+ duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "green":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 1 / 4 , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    break;
                case "red":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+3) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "blue":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "purple":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "black":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when, duration);


                    break;
            }
        } else {
            switch (colorM) {
                case "white":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration);

                    break;
                case "yellow":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when , duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 2 / 4, duration / 2);
                    break;
                case "cyan":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when+ duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "green":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 1 / 4 , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    break;
                case "red":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+3) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "blue":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "purple":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "black":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when, duration);


                    break;
            }
        }
        Log.i("readIndex",""+newIndex);
        return newIndex;
    }

    public static int ColorToMelodyBridge(ArrayList<Integer>scale,int previous, String colorM, String colorR, MidiTrack noteTrack, long when, long duration, int transpose) {
        int v = 120;
        int indexPrevious = previous;
        int newIndex = 0;
        Log.i("index", "i" + indexPrevious);
        int whenInt=(int)(when/duration);
        int modifier=whenInt%4;

        if (modifier == 0) {
            switch (colorM) {
                case "white":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration);

                    break;
                case "yellow":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 1 / 4, duration / 2);
                    break;
                case "cyan":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 1 / 4, duration / 2);
                    break;
                case "green":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when  , duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 1 / 4, duration / 2);
                    break;
                case "red":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when  , duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 1 / 4, duration / 2);
                    break;
                case "blue":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when  , duration / 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 1 / 8, duration / 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 2 / 8, duration* 3/ 4);
                    break;
                case "purple":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when  , duration / 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 1 / 8, duration / 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 2 / 8, duration* 3/ 4);
                    break;
                case "black":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration);


                    break;
            }
        } else {
            switch (colorM) {
                case "white":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration / 2);
                    break;
                case "yellow":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "cyan":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "green":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration *3/ 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 3 / 4, duration * 1 / 4);
                    break;
                case "red":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration *3/4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 3 / 4, duration * 1 / 4);
                    break;
                case "blue":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 2 / 4, duration * 3 / 4);
                    break;
                case "purple":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 2 / 4, duration * 3 / 4);
                    break;
                case "black":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when, duration/2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when+duration/2, duration/2);
                    break;
            }
        }

        Log.i("readIndex",""+newIndex);

        return newIndex;
    }


    public static int ColorToMelodyChorus(ArrayList<Integer>scale,int previous, String colorM, String colorR, MidiTrack noteTrack, long when, long duration, int transpose) {
        int v = 120;

        int indexPrevious = previous;
        int newIndex = indexPrevious;
        Log.i("index", "i" + indexPrevious);
        int whenInt=(int)(when/duration);
        int modifier=whenInt%4;

        if(when/duration==94){
            Log.i("finishing","finish");
            newIndex = indexPrevious;
            noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when, duration);
            noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when, duration);
        }else if (modifier == 0) {
            switch (colorM) {
                case "white":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when, duration);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when, duration);

                    break;
                case "yellow":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when , duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 2 / 4, duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when , duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 24 + transpose, v, when + duration * 2 / 4, duration / 2);
                    break;
                case "cyan":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when+ duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when+ duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "green":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when + duration * 1 / 4 , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+3) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when + duration * 1 / 4 , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    break;
                case "red":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+3) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "blue":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "purple":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "black":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when, duration);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when, duration);


                    break;
            }
        } else {

            switch (colorM) {
                case "white":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when, duration);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when, duration);

                    break;
                case "yellow":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when , duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 2 / 4, duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when , duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 24 + transpose, v, when + duration * 2 / 4, duration / 2);
                    break;
                case "cyan":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when+ duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when+ duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "green":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 12 + transpose, v, when + duration * 1 / 4 , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+3) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when + duration * 1 / 4 , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    break;
                case "red":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+3) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "blue":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when  , duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "purple":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 12 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 12 + transpose, v, when + duration * 3 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex) + 24 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "black":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 12 + transpose, v, when, duration);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex+1) + 24 + transpose, v, when, duration);


                    break;
            }
        }
        Log.i("readIndex",""+newIndex);



        return newIndex;
    }


    public static int ColorToMelodyChorusHigh(ArrayList<Integer>scale,int previous, String colorM, String colorR, MidiTrack noteTrack, long when, long duration, int transpose) {
        int v = 120;

        int indexPrevious = previous;
        int newIndex = indexPrevious;
        Log.i("index", "i" + indexPrevious);
        int whenInt=(int)(when/duration);
        int modifier=whenInt%4;



        if(when/duration==94){
            newIndex = indexPrevious;
            noteTrack.insertNote(channelMelody, scale.get(newIndex+2) + 24 + transpose, v, when, duration);
        }else if (modifier == 0) {
            switch (colorM) {
                case "white":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration);

                    break;
                case "yellow":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when , duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-3) + 24 + transpose, v, when + duration * 2 / 4, duration / 2);
                    break;
                case "cyan":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration *3/ 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-3) + 24 + transpose, v, when + duration * 1 / 4, duration / 4);
                    break;
                case "green":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when  , duration *3/ 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when + duration * 3 / 4, duration *1/ 4);
                    break;
                case "red":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when  , duration *2/ 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-3) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-4) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "blue":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when  , duration *3/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 24 + transpose, v, when + duration * 3 / 8, duration*3 / 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2-4) + 24 + transpose, v, when + duration * 6 / 8, duration* 2/ 8);
                    break;
                case "purple":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-1) + 24 + transpose, v, when  , duration *3/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-3) + 24 + transpose, v, when + duration * 3 / 8, duration *3/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-4) + 24 + transpose, v, when + duration * 6 / 8, duration* 2/ 8);
                    break;
                case "black":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration);


                    break;
            }
        } else {

            switch (colorM) {
                case "white":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-3) + 24 + transpose, v, when + duration * 2 / 4, duration / 2);

                    break;
                case "yellow":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration / 2);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-3) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex -4) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "cyan":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration *3/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 4) + 24 + transpose, v, when + duration * 3 / 8, duration *1/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex -3) + 24 + transpose, v, when + duration * 4 / 8, duration *3/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex -4) + 24 + transpose, v, when + duration * 7 / 8, duration *1/ 8);
                    break;
                case "green":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration * 3 / 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 3) + 24 + transpose, v, when + duration * 3 / 8, duration *3/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-4) + 24 + transpose, v, when + duration * 6 / 8, duration *2/ 8);
                    break;
                case "red":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration * 3 / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 3) + 24 + transpose, v, when + duration * 6 / 8, duration / 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 2 + transpose, v, when + duration * 7 / 8, duration / 8);
                    break;
                case "blue":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 3) + 24 + transpose, v, when + duration * 1 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex -4) + 24 + transpose, v, when + duration * 2 / 4, duration / 4);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 5) + 24 + transpose, v, when + duration * 3 / 4, duration / 4);
                    break;
                case "purple":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration *6/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 3) + 24 + transpose, v, when + duration * 2 / 4, duration *1/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 4) + 24 + transpose, v, when + duration * 3 / 4, duration *1/ 8);
                    break;
                case "black":
                    newIndex = indexPrevious;
                    noteTrack.insertNote(channelMelody, scale.get(newIndex-2) + 24 + transpose, v, when, duration *3/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 3) + 24 + transpose, v, when + duration *3/ 8, duration*1 / 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex -2) + 24 + transpose, v, when + duration *4/ 8, duration *3/ 8);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 5) + 24 + transpose, v, when + duration *14/ 16, duration *1/ 16);
                    noteTrack.insertNote(channelMelody, scale.get(newIndex - 4) + 24 + transpose, v, when + duration *15/ 16, duration *1/ 16);

                    break;
            }
        }
        Log.i("readIndex",""+newIndex);



        return newIndex;


    }


    public static void ColortoDrums(int note, String colorR, MidiTrack noteTrack, long when, long duration, int drumChannel) {
        switch (colorR) {
            case "white":
                noteTrack.insertNote(drumChannel, note, 0, when, duration);
                break;
            case "yellow":
                noteTrack.insertNote(drumChannel, note, 0, when, duration);
                break;
            case "cyan":
                noteTrack.insertNote(drumChannel, note, 0, when, duration);
                break;
            case "purple":
                noteTrack.insertNote(drumChannel, note, 120, when, duration);
                break;
            case "red":
                noteTrack.insertNote(drumChannel, note, 120, when, duration);
                break;
            case "green":
                noteTrack.insertNote(drumChannel, note, 0, when, duration);
                break;
            case "blue":
                noteTrack.insertNote(drumChannel, note, 120, when, duration);
                break;
            case "black":
                noteTrack.insertNote(drumChannel, note, 120, when, duration);
                break;
        }

    }

    public static void ColortoChord(MidiTrack noteTrack, int chordChannel, MidiChord ch, String[] melody, String[] rythm,
                                    int index, long start, int transpose) {
        long duration = BarAdder.getBarDuration(melody[32]);
        int v1 = 120;


        noteTrack.insertNote(chordChannel, ch.root + transpose, v1, start, duration);
        noteTrack.insertNote(chordChannel, ch.middle + transpose, v1, start, duration);
        noteTrack.insertNote(chordChannel, ch.top + transpose, v1, start, duration);


    }

    public static void ColortoChordArpeggio(MidiTrack noteTrack, int chordChannel, MidiChord ch, String[] melody, String[] rythm,
                                            int index, long start, int transpose) {
        long duration = BarAdder.getBarDuration(melody[32]);
        //int arpeggioVelocity=35;

        int v1 = 120;
        int v2 = 40;
        int v3 = 40;
        int v4 = 40;

        noteTrack.insertNote(chordChannel, ch.root + transpose, v1, start, duration);
        noteTrack.insertNote(chordChannel, ch.middle + transpose, v1, start, duration);
        noteTrack.insertNote(chordChannel, ch.top + transpose, v1, start, duration);


    }

    public static void ColortoPad(MidiTrack noteTrack, int padChannel, MidiChord ch, String[] melody, String[] rythm,
                                  int index, long start, int transpose) {
        long duration = BarAdder.getBarDuration(melody[32]);
        int padVelocity = 80;
        noteTrack.insertNote(padChannel, ch.root + transpose, padVelocity, start, duration);
        noteTrack.insertNote(padChannel, ch.middle + transpose, padVelocity, start, duration);
        noteTrack.insertNote(padChannel, ch.top + transpose, padVelocity, start, duration);

    }

    public static int chooseFirstNote(MidiChord ch, String s) {
        if (s.equals("white") || s.equals("yellow")) {

            return ch.top+12;
        } else if (s.equals("cyan") || s.equals("green")) {
            return ch.root+12;
        } else {
            return ch.middle+12;
        }
    }


}
