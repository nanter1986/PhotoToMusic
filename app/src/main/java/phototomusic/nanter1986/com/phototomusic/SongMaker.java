package phototomusic.nanter1986.com.phototomusic;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.leff.midi.MidiFile;
import com.leff.midi.MidiTrack;
import com.leff.midi.event.NoteOff;
import com.leff.midi.event.NoteOn;
import com.leff.midi.event.ProgramChange;
import com.leff.midi.event.meta.Tempo;
import com.leff.midi.event.meta.TimeSignature;

/**
 * Created by nanter1986 on 16/11/2016.
 */
public class SongMaker {

    public static void makeFile(String name,String[] chords,String[] melody,String[] rythm,MidiTrack tT){
        ArrayList<MidiTrack> tracks = new ArrayList<>();
        MidiTrack noteTrack=new MidiTrack();



        final int chordVelocity=40;
        final int chordChannel=0;

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
        ArrayList<Integer>choosenScale=Scale.getScaleFlavor(flavorOfChordAndScale);



        //CHANNEL CREATION ***************************************************************************

        int[] organs=OrganGroups.makeGroups(chords);

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
       BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,0,0,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,8,1,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,0,2,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,7,3,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,3,1,4,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,3,6,5,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,0,0,6,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,0,5,7,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,0,8,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,8,9,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,0,10,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,7,11,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,3,1,12,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,3,6,13,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,0,0,14,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,0,5,15,0);


        //BRIDGE 1 *********************************************************************************
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,1,32,16,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,1,34,17,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,2,32,18,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,2,35,19,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,3,33,20,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,3,36,21,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,0,32,22,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,0,38,23,0);

        //CHORUS 1 ********************************************************************************
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,1,16,24,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,1,26,25,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,16,26,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,25,27,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,17,28,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,24,29,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,16,30,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,23,31,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,1,16,32,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,1,26,33,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,16,34,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,25,35,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,1,36,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,24,37,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,16,38,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,23,39,0);

        //VERSE 2 ***********************************************************************************
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,0,40,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,8,41,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,0,42,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,7,43,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,3,1,44,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,3,6,45,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,0,0,46,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,0,5,47,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,0,48,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,8,49,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,0,50,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,7,51,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,3,1,52,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,3,6,53,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,0,0,54,0);
        BarAdder.addVerse(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,0,5,55,0);


        //BRIDGE 2 *********************************************************************************
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,1,32,56,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,1,34,57,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,2,32,58,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,2,35,59,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,3,33,60,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,3,36,61,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,0,32,62,0);
        BarAdder.addBridge(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1, melody,rythm,0,38,63,0);

        //CHORUS 2 ********************************************************************************
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,1,16,64,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,1,26,65,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,16,66,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,25,67,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,17,68,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,24,69,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,16,70,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,23,71,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,1,16,72,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,1,26,73,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,16,74,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,24,75,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,17,76,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,25,77,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,16,78,0);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,23,79,0);

        //solo
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,16,80,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,26,81,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,16,82,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,25,83,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,17,84,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,24,85,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,16,86,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,0,23,87,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,16,88,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,1,26,89,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                v1,melody,rythm,2,16,90,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,2,25,91,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,17,92,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,3,16,93,transposeChorus2);
        BarAdder.addChorus(choosenScale,noteTrack,chordChannel,chordVelocity,bassChannel,bassVelocity,drumsChannel,
                c1,melody,rythm,0,24,94,transposeChorus2);



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
        String fl="western";
        /*switch (s){
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
        }*/
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
