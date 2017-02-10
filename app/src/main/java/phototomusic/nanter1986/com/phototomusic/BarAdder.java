package phototomusic.nanter1986.com.phototomusic;

import android.util.Log;

import com.leff.midi.MidiTrack;

import java.util.ArrayList;

/**
 * Created by nanter1986 on 2/12/2016.
 */
public class BarAdder {
    public static void addVerse(ArrayList<Integer> scale, MidiTrack noteTrack, int chordChannel, int chordVelocity, int bassChannel,
                                int bassVelocity, int drumsChannel, Progressions pr, String[] melody, String[] rythm,
                                int whichChord, int index, int start, int transpose) {
        long duration=getBarDuration(melody[32]);
        int key=getSongKey(rythm[44]);
        int indexR;
        if(index%4==1 || index%4==2){
            indexR=0;
        }else if(index%4==3){
            indexR=12;
        }else{
            indexR=8;
        }
        long starts = duration * start;
        MidiChord chord=pr.progs1.get(whichChord);
        int firstNote=ColortoMelody.chooseFirstNote(chord,rythm[index]);

        int indexOfPrevious=scale.indexOf(firstNote);
        Log.i("first",""+chord.top+ chord.middle+ chord.root+" "+indexOfPrevious);


        ColortoMelody.ColortoPad(noteTrack,6,chord,melody,rythm,index,starts,key);

        ColortoMelody.ColortoChord(noteTrack, chordChannel, chord,melody, rythm, index, starts, key);

        noteTrack.insertNote(bassChannel,chord.root-12+key,bassVelocity,starts,duration/4);
        noteTrack.insertNote(bassChannel,chord.root-12+key,bassVelocity,starts+duration/4,duration/4);
        noteTrack.insertNote(bassChannel,chord.root-12+key,bassVelocity,starts+duration*2/4,duration/4);
        noteTrack.insertNote(bassChannel,chord.root-12+key,bassVelocity,starts+duration*3/4,duration/4);

        ColortoMelody.ColorToMelodyVerse(scale,indexOfPrevious,melody[index],rythm[indexR],noteTrack,starts,duration,key);





    }

    public static void addBridge(ArrayList<Integer>scale,MidiTrack noteTrack, int chordChannel, int chordVelocity, int bassChannel,
                                 int bassVelocity, int drumsChannel, Progressions pr, String[] melody, String[] rythm,
                                 int whichChord,int index, int start, int transpose){
        long duration=getBarDuration(melody[32]);
        int key=getSongKey(rythm[44]);
        int indexR;
        if(index%4==1 || index%4==2){
            indexR=32;
        }else if(index%4==3){
            indexR=40;
        }else{
            indexR=44;
        }
        long starts = duration * start;
        MidiChord chord=pr.progs1.get(whichChord);
        int firstNote=ColortoMelody.chooseFirstNote(chord,rythm[index]);
        Log.i("first",""+firstNote);
        int indexOfPrevious=scale.indexOf(firstNote);

        if (transpose != 0) {
            ColortoMelody.ColortoChordArpeggio(noteTrack, chordChannel, chord,melody, rythm, index, starts, key);

        } else {
            ColortoMelody.ColortoChord(noteTrack, chordChannel, chord,melody, rythm, index, starts, key);
        }

        ColortoMelody.ColorToMelodyBridge(scale,indexOfPrevious,melody[index],rythm[indexR],noteTrack,starts,duration,key);




    }


    public static void addChorus(ArrayList<Integer>scale,MidiTrack noteTrack, int chordChannel, int chordVelocity, int bassChannel,
                                 int bassVelocity, int drumsChannel, Progressions pr, String[] melody, String[] rythm,
                                 int whichChord,int index, int start, int transpose) {
        long duration=getBarDuration(melody[32]);
        int key=getSongKey(rythm[44])+transpose;
        int indexR;
        if(index%4==1 || index%4==2){
            indexR=16;
        }else if(index%4==3){
            indexR=24;
        }else{
            indexR=28;
        }
        long starts = duration * start;
        MidiChord chord=pr.progs1.get(whichChord);
        int firstNote=ColortoMelody.chooseFirstNote(chord,rythm[index]);
        Log.i("first",""+firstNote);
        int indexOfPrevious=scale.indexOf(firstNote);

        ColortoMelody.ColortoPad(noteTrack,6,chord,melody,rythm,index,starts,key);


        if (transpose != 0) {
            ColortoMelody.ColortoChordArpeggio(noteTrack, chordChannel, chord,melody, rythm, index, starts, key);

        } else {
            ColortoMelody.ColortoChord(noteTrack, chordChannel, chord,melody, rythm, index, starts, key);
        }

        noteTrack.insertNote(bassChannel,chord.root-12+key,bassVelocity,starts,duration/4);
        noteTrack.insertNote(bassChannel,chord.middle-12+key,bassVelocity,starts+duration/4,duration/4);
        noteTrack.insertNote(bassChannel,chord.root-12+key,bassVelocity,starts+duration*2/4,duration/4);
        noteTrack.insertNote(bassChannel,chord.top-12+key,bassVelocity,starts+duration*3/4,duration/4);

        ColortoMelody.ColorToMelodyChorus(scale,indexOfPrevious,melody[index],rythm[indexR],noteTrack,starts,duration,key);

       // ColortoMelody.ColorToMelodyChorusHigh(scale,indexOfPrevious,melody[index],rythm[indexR],noteTrack,starts,duration,key);





    }

    public static void addChorusFinishing(ArrayList<Integer>scale,MidiTrack noteTrack, int chordChannel, int chordVelocity, int bassChannel,
                                 int bassVelocity, int drumsChannel, Progressions pr, String[] melody, String[] rythm,
                                 int whichChord,int index, int start, int transpose) {
        long duration=getBarDuration(melody[32]);
        int key=getSongKey(rythm[44])+transpose;
        int indexR;
        if(index%4==1 || index%4==2){
            indexR=16;
        }else if(index%4==3){
            indexR=24;
        }else{
            indexR=28;
        }
        long starts = duration * start;
        MidiChord chord=pr.progs1.get(whichChord);
        int firstNote=ColortoMelody.chooseFirstNote(chord,rythm[index]);
        Log.i("first",""+firstNote);
        int indexOfPrevious=scale.indexOf(firstNote);

        ColortoMelody.ColortoPad(noteTrack,6,chord,melody,rythm,index,starts,key);


        if (transpose != 0) {
            ColortoMelody.ColortoChordArpeggio(noteTrack, chordChannel, chord,melody, rythm, index, starts, key);

        } else {
            ColortoMelody.ColortoChord(noteTrack, chordChannel, chord,melody, rythm, index, starts, key);
        }

        noteTrack.insertNote(bassChannel,chord.root-12+key,bassVelocity,starts,duration/4);
        noteTrack.insertNote(bassChannel,chord.middle-12+key,bassVelocity,starts+duration/4,duration/4);
        noteTrack.insertNote(bassChannel,chord.root-12+key,bassVelocity,starts+duration*2/4,duration/4);
        noteTrack.insertNote(bassChannel,chord.top-12+key,bassVelocity,starts+duration*3/4,duration/4);


        int indexF=scale.indexOf(firstNote);
        noteTrack.insertNote(1,scale.get(indexF-2)+12,120,starts,duration/2);

        noteTrack.insertNote(1,scale.get(indexF)+24,120,starts,duration/2);




    }

    public static long getBarDuration(String colorR){
        long dur=0;
        switch (colorR){
            case "white":
                dur=500;
                break;
            case "yellow":
                dur=580;
                break;
            case "cyan":
                dur=650;
                break;
            case "purple":
                dur=720;
                break;
            case "red":
                dur=800;
                break;
            case "green":
                dur=870;
                break;
            case "blue":
                dur=940;
                break;
            case "black":
                dur=1000;
                break;
        }
        return dur;
    }

    public static int getSongKey(String colorR){
        int key=0;
        switch (colorR){
            case "white":
                key=2;
                break;
            case "yellow":
                key=4;
                break;
            case "cyan":
                key=5;
                break;
            case "purple":
                key=7;
                break;
            case "red":
                key=-1;
                break;
            case "green":
                key=-3;
                break;
            case "blue":
                key=-5;
                break;
            case "black":
                key=1;
                break;
        }
        return key;
    }
}
