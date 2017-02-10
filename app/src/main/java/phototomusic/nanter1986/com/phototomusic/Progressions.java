package phototomusic.nanter1986.com.phototomusic;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by nanter1986 on 8/12/2016.
 */
public class Progressions {
    public ArrayList<MidiChord>progs1;


    public Progressions(String typeChord,String flavor){


        MidiChord c=MidiChord.chordMake("c",2,flavor);
        MidiChord g=MidiChord.chordMake("g",2,flavor);
        MidiChord a=MidiChord.chordMake("a",2,flavor);
        MidiChord f=MidiChord.chordMake("f",2,flavor);
        MidiChord d=MidiChord.chordMake("d",2,flavor);
        MidiChord e=MidiChord.chordMake("e",2,flavor);
        MidiChord b=MidiChord.chordMake("b",2,flavor);

        progs1=new ArrayList<>();
        switch (typeChord){
            case "popular":
                progs1.add(c);
                progs1.add(a);
                progs1.add(d);
                progs1.add(g);
                break;
            case "dark":
                progs1.add(e);
                progs1.add(a);
                progs1.add(d);
                progs1.add(b);
                break;
            case "happy":
                progs1.add(c);
                progs1.add(c);
                progs1.add(f);
                progs1.add(g);
                break;
            case "sad":
                progs1.add(a);
                progs1.add(e);
                progs1.add(d);
                progs1.add(g);
                break;
            case "wow":
                progs1.add(a);
                progs1.add(c);
                progs1.add(f);
                progs1.add(g);
                break;
            case "red":
                progs1.add(a);
                progs1.add(c);
                progs1.add(d);
                progs1.add(g);
                break;
            case "blue":
                progs1.add(b);
                progs1.add(e);
                progs1.add(f);
                progs1.add(g);
                break;
        }


    }

    public MidiChord getChord(int index){
        MidiChord chord=progs1.get(index%4);
        Log.i("chordname",""+index%4);
        return chord;
    }
}
