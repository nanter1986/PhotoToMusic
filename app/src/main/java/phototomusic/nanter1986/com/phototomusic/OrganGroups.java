package phototomusic.nanter1986.com.phototomusic;

import android.util.Log;

import com.leff.midi.event.ProgramChange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by nanter1986 on 5/12/2016.
 */
public class OrganGroups {
    public static int[] makeGroups(String[] chords){
          final int[] groupStrings={ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber(),
                ProgramChange.MidiProgram.ACOUSTIC_GRAND_PIANO.programNumber(),
                ProgramChange.MidiProgram.ELECTRIC_BASS_FINGER.programNumber(),
                ProgramChange.MidiProgram.TIMPANI.programNumber(),
                ProgramChange.MidiProgram.ACOUSTIC_GRAND_PIANO.programNumber(),
                ProgramChange.MidiProgram.PAD_4_CHOIR.programNumber()};


        final int[] groupTecnho={ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber(),
                ProgramChange.MidiProgram.STRING_ENSEMBLE_1.programNumber(),
                ProgramChange.MidiProgram.ELECTRIC_BASS_FINGER.programNumber(),
                ProgramChange.MidiProgram.SYNTH_DRUM.programNumber(),
                ProgramChange.MidiProgram.STRING_ENSEMBLE_1.programNumber(),
                ProgramChange.MidiProgram.PAD_4_CHOIR.programNumber()};

        final int[] groupGuitar={ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber(),
                ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber(),
                ProgramChange.MidiProgram.ELECTRIC_BASS_FINGER.programNumber(),
                ProgramChange.MidiProgram.TIMPANI.programNumber(),
                ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber(),
                ProgramChange.MidiProgram.PAD_4_CHOIR.programNumber()};


        final int[] groupMetal={ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber(),
                ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber(),
                ProgramChange.MidiProgram.ELECTRIC_BASS_FINGER.programNumber(),
                ProgramChange.MidiProgram.TIMPANI.programNumber(),
                ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber(),
                ProgramChange.MidiProgram.PAD_4_CHOIR.programNumber()};

        int wy=0;
        int cg=0;
        int rb=0;
        int bb=0;

        for(int i=0;i<chords.length;i++){
            if(chords[i].equals("white") || chords[i].equals("yellow")){
                wy++;
            }else if(chords[i].equals("cyan") || chords[i].equals("green")){
                cg++;
            }else if(chords[i].equals("red") || chords[i].equals("blue")){
                rb++;
            }else{
                bb++;
            }
        }
        Combos whiteYellow=new Combos("wy",wy);
        Combos cyanGreen=new Combos("cg",cg);
        Combos redBlue=new Combos("rb",rb);
        Combos blueBlack=new Combos("bb",bb);
        ArrayList<Combos>count=new ArrayList<>();
        count.add(whiteYellow);
        count.add(cyanGreen);
        count.add(redBlue);
        count.add(blueBlack);

        Collections.sort(count, new Comparator<Combos>() {
            @Override
            public int compare(Combos o1, Combos o2) {
                if(o1.score==o2.score){
                    return 0;
                }else if(o1.score>o2.score){
                    return -1;
                }else{
                    return 1;
                }

            }
        });
        for(Combos c:count){
            Log.i("combo",c.name);
        }

        if(count.get(0).name.equals("wy")){
            return groupGuitar;
        }else if((count.get(0).name.equals("cg"))){
            return groupMetal;
        }else if((count.get(0).name.equals("rb"))){
            return groupStrings;
        }else{
            return groupTecnho;
        }
        //return groupMetal;

    }

    public static class Combos{
        String name;
        int score;
        public Combos(String n,int s){
            name=n;
            score=s;
        }
    }

}
