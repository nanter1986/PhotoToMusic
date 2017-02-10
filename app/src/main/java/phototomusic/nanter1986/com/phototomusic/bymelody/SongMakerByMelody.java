package phototomusic.nanter1986.com.phototomusic.bymelody;

import android.os.Environment;
import android.util.Log;

import com.leff.midi.MidiFile;
import com.leff.midi.MidiTrack;
import com.leff.midi.event.ProgramChange;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import phototomusic.nanter1986.com.phototomusic.BarAdder;
import phototomusic.nanter1986.com.phototomusic.OrganGroups;
import phototomusic.nanter1986.com.phototomusic.Progressions;
import phototomusic.nanter1986.com.phototomusic.Scale;

/**
 * Created by nanter1986 on 31/12/2016.
 */
public class SongMakerByMelody {
    public static void makeFile(String name,String[] chords,String[] melody,String[] rythm,MidiTrack tT){
        ArrayList<MidiTrack> tracks = new ArrayList<>();
        MidiTrackMine noteTrack=new MidiTrackMine();



        final int chordVelocity=40;
        final int chordChannel=0;
        final int channelMelody=1;
        final int padChannel=6;

        final int bassChannel=2;
        final int bassVelocity=50;

        final int drumsVelocity=50;
        final int drumsChannel=3;


        int transposeChorus2=1;
        String[] chooser=chooseChordProgression(chords);
        Log.i("mood",chooser[0]+ " " + chooser[1]);




        //get scale
        String flavorOfChordAndScale=getFlavor(melody[60]);
        Log.i("flavorScale",flavorOfChordAndScale);
        Progressions v1=new Progressions(chooser[0],flavorOfChordAndScale);


        Progressions c1=new Progressions(chooser[1],flavorOfChordAndScale);
        ArrayList<Integer>choosenScale= Scale.getScaleFlavor(flavorOfChordAndScale);



        //CHANNEL CREATION ***************************************************************************

        int[] organs= OrganGroups.makeGroups(chords);

        ProgramChange pc = new ProgramChange(0, 1, organs[1]);
        noteTrack.insertEvent(pc);
        ProgramChange pc2 = new ProgramChange(0, 0, organs[0]);
        noteTrack.insertEvent(pc2);
        ProgramChange pc3 = new ProgramChange(0, 2, organs[2]);
        noteTrack.insertEvent(pc3);
        ProgramChange pc4 = new ProgramChange(0, 3, organs[3]);
        noteTrack.insertEvent(pc4);
        ProgramChange pc5 = new ProgramChange(0, 5, organs[4]);
        noteTrack.insertEvent(pc5);
        ProgramChange pcPad = new ProgramChange(0, 6, organs[5]);
        noteTrack.insertEvent(pcPad);

        /*ProgramChange pc=OrganSelection.highSelection(melody[0]);
        ProgramChange pc2=OrganSelection.midSelection(melody[1]);
        noteTrack.insertEvent(pc);
        noteTrack.insertEvent(pc2);*/

        //VERSE 1 *************************************************************************
        Adder.addVerse(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,0,0);
        Adder.addVerse(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,1,0);



        //BRIDGE 1 *********************************************************************************
        Adder.addBridge(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,2,0);


        //CHORUS 1 ********************************************************************************
        Adder.addChorus(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,3,0);
        Adder.addChorus(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,4,0);
        Adder.addChorus(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,5,0);
        Adder.addChorus(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,6,0);


        //VERSE 2 ***********************************************************************************
        Adder.addVerse(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,7,0);
        Adder.addVerse(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,8,0);


        //BRIDGE 2 *********************************************************************************
        Adder.addBridge(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,9,0);


        //CHORUS 2 ********************************************************************************
        Adder.addChorus(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,10,0);
        Adder.addChorus(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,11,0);
        Adder.addChorus(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,12,0);
        Adder.addChorus(noteTrack,channelMelody,chordChannel,padChannel,melody,rythm,13,0);

        //solo




        tracks.add(tT);
        tracks.add(noteTrack);

        MidiFile midii = new MidiFile(MidiFile.DEFAULT_RESOLUTION, tracks);
        String namee= Environment.getExternalStorageDirectory().getPath().toString() + "/" + name + ".mid";

        File f = new File(namee);
        try {
            midii.writeToFile(f);
            Log.i("s","written");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static String getFlavor(String s) {
        String fl="";
        switch (s){
            case "black":
                fl="harmonic";
                break;
            case "blue":
                fl="prometheus";
                break;
            case "purple":
                fl="persian";
                break;
            case "red":
                fl="persian";
                break;
            default:
                fl="western";
        }
        return fl;
    }

    public static String[] chooseChordProgression(String[] sss){
        int score1=0;
        int score2=0;

        String[] moods=new String[2];
        for(int i=0;i<4;i++){
            if(sss[i].equals("white")){
                score1+=0;
            }else if(sss[i].equals("yellow")){
                score1+=10;
            }else if(sss[i].equals("cyan")){
                score1+=20;
            }else if(sss[i].equals("green")){
                score1+=30;
            }else if(sss[i].equals("red")){
                score1+=40;
            }else if(sss[i].equals("purple")){
                score1+=50;
            }else if(sss[i].equals("blue")){
                score1+=60;
            }else if(sss[i].equals("black")){
                score1+=70;
            }
        }
        if(score1<50){
            moods[0]="happy";
        }else if(score1<100){
            moods[0]="happy";
        }else if(score1<150){
            moods[0]="popular";
        }else if(score1<200){
            moods[0]="blue";
        }else if(score1<250){
            moods[0]="dark";
        }else if(score1<300){
            moods[0]="sad";
        }


        for(int i=4;i<8;i++){
            if(sss[i].equals("white")){
                score2+=0;
            }else if(sss[i].equals("yellow")){
                score2+=10;
            }else if(sss[i].equals("cyan")){
                score2+=20;
            }else if(sss[i].equals("green")){
                score2+=30;
            }else if(sss[i].equals("red")){
                score2+=40;
            }else if(sss[i].equals("purple")){
                score2+=50;
            }else if(sss[i].equals("blue")){
                score2+=60;
            }else if(sss[i].equals("black")){
                score2+=70;
            }
        }
        if(score2<50){
            moods[1]="happy";
        }else if(score2<100){
            moods[1]="happy";
        }else if(score2<150){
            moods[1]="popular";
        }else if(score2<200){
            moods[1]="blue";
        }else if(score2<250){
            moods[1]="dark";
        }else if(score2<300){
            moods[1]="sad";
        }
        return moods;
    }
}
