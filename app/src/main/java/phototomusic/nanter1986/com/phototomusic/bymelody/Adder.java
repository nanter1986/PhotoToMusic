package phototomusic.nanter1986.com.phototomusic.bymelody;

import android.util.Log;

import com.leff.midi.MidiTrack;

import java.util.ArrayList;

import phototomusic.nanter1986.com.phototomusic.ColortoMelody;
import phototomusic.nanter1986.com.phototomusic.MidiChord;
import phototomusic.nanter1986.com.phototomusic.Progressions;

/**
 * Created by nanter1986 on 31/12/2016.
 */
public class Adder {
    public static void addVerse(MidiTrack noteTrack,int channelMelody,int chordChannel,int padChannel, String[] melody, String[] rythm, int start, int transpose) {
        int v=120;
        int padVelocity=85;
        int chordVelocity=120;
        long duration=getBarDuration(melody[32]);
        int key=getSongKey(rythm[44]);
        long starts = 4*duration * start;
        int centralNote=chooseMode(melody)[0];
        int indexOfCentralNote=ScalesByMelody.scaless.indexOf(centralNote);
        double[] durationsFirst=getFirstBarDurations(rythm[0]);
        double[] durations2=getBarDurations(rythm[1]);
        double[] durations3=getBarDurations(rythm[2]);
        double[] durations4=getBarDurations(rythm[3]);
        int[] intervals0=getIntervalsForMelody(melody[0]);
        int[] intervals1=getIntervalsForMelody(melody[1]);
        int[] intervals2=getIntervalsForMelody(melody[2]);
        int[] intervals3=getIntervalsForMelody(melody[3]);

        //bar1
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, padVelocity, starts, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, padVelocity, starts, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, padVelocity, starts, duration);

        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote)+ transpose, v, starts+duration*0 , getNoteDuration(duration,durationsFirst[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[0])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,0,1) , getNoteDuration(duration,durationsFirst[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[1])+ transpose, v,getNoteStartingPoint(starts,duration,durationsFirst,1,1) , getNoteDuration(duration,durationsFirst[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[2])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,2,1) , getNoteDuration(duration,durationsFirst[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[3])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,3,1) , getNoteDuration(duration,durationsFirst[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[4])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,4,1) , getNoteDuration(duration,durationsFirst[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[5])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,5,1) , getNoteDuration(duration,durationsFirst[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[6])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,6,1) , getNoteDuration(duration,durationsFirst[7]));
        int subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote)-1;

        //bar2
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex)-12+ transpose, padVelocity, starts+duration, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+2)-12+ transpose, padVelocity, starts+duration, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+4)-12+ transpose, padVelocity, starts+duration, duration);

        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts+duration, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts+duration, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts+duration, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex)+ transpose, v, starts+duration*1 , getNoteDuration(duration,durations2[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[0])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,0,2) , getNoteDuration(duration,durations2[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[1])+ transpose, v,getNoteStartingPoint(starts,duration,durations2,1,2) , getNoteDuration(duration,durations2[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[2])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,2,2) , getNoteDuration(duration,durations2[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[3])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,3,2) , getNoteDuration(duration,durations2[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[4])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,4,2) , getNoteDuration(duration,durations2[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[5])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,5,2) , getNoteDuration(duration,durations2[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[6])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,6,2) , getNoteDuration(duration,durations2[7]));
        subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote)+1;

        //bar3
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex)-12+ transpose, padVelocity, starts+duration*2, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+2)-12+ transpose, padVelocity, starts+duration*2, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+4)-12+ transpose, padVelocity, starts+duration*2, duration);

        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts+duration*2, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts+duration*2, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts+duration*2, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex)+ transpose, v, starts+duration*2, getNoteDuration(duration,durations2[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[0])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,0,3) , getNoteDuration(duration,durations2[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[1])+ transpose, v,getNoteStartingPoint(starts,duration,durations2,1,3) , getNoteDuration(duration,durations2[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[2])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,2,3) , getNoteDuration(duration,durations2[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[3])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,3,3) , getNoteDuration(duration,durations2[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[4])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,4,3) , getNoteDuration(duration,durations2[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[5])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,5,3) , getNoteDuration(duration,durations2[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[6])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,6,3) , getNoteDuration(duration,durations2[7]));
        subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote)-2;

        //bar4
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex)-12+ transpose, padVelocity, starts+duration*3, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+2)-12+ transpose, padVelocity, starts+duration*3, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+4)-12+ transpose, padVelocity, starts+duration*3, duration);

        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts+duration*3, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts+duration*3, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts+duration*3, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex)+ transpose, v, starts+duration*3, getNoteDuration(duration,durations3[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[0])+ transpose, v, getNoteStartingPoint(starts,duration,durations4,0,4) , getNoteDuration(duration,durations4[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[1])+ transpose, v,getNoteStartingPoint(starts,duration,durations4,1,4) , getNoteDuration(duration,durations4[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[2])+ transpose, v, getNoteStartingPoint(starts,duration,durations4,2,4) , getNoteDuration(duration,durations4[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[3])+ transpose, v, getNoteStartingPoint(starts,duration,durations4,3,4) , getNoteDuration(duration,durations4[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[4])+ transpose, v, getNoteStartingPoint(starts,duration,durations4,4,4) , getNoteDuration(duration,durations4[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote-1)+ transpose, v, getNoteStartingPoint(starts,duration,durations4,5,4) , getNoteDuration(duration,durations4[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote-1)+ transpose, v, getNoteStartingPoint(starts,duration,durations4,6,4) , getNoteDuration(duration,durations4[7]));
        subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote);
















    }

    public static void addBridge(MidiTrack noteTrack,int channelMelody,int chordChannel,int padChannel, String[] melody, String[] rythm, int start, int transpose) {
        int v=120;
        int padVelocity=85;
        int chordVelocity=120;
        long duration=getBarDuration(melody[32]);
        int key=getSongKey(rythm[44]);
        long starts = 4*duration * start;
        int centralNote=chooseMode(melody)[0];
        int indexOfCentralNote=ScalesByMelody.scaless.indexOf(centralNote);
        double[] durationsFirst=getFirstBarDurations(rythm[33]);
        double[] durations2=getBarDurations(rythm[34]);
        double[] durations3=getBarDurations(rythm[35]);
        double[] durations4=getBarDurations(rythm[36]);
        int[] intervals0=getIntervalsForMelody(melody[33]);
        int[] intervals1=getIntervalsForMelody(melody[34]);
        int[] intervals2=getIntervalsForMelody(melody[35]);
        int[] intervals3=getIntervalsForMelody(melody[36]);

        //bar1
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote)+ transpose, v, starts+duration*0 , getNoteDuration(duration,durationsFirst[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[0])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,0,1) , getNoteDuration(duration,durationsFirst[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[1])+ transpose, v,getNoteStartingPoint(starts,duration,durationsFirst,1,1) , getNoteDuration(duration,durationsFirst[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[2])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,2,1) , getNoteDuration(duration,durationsFirst[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[3])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,3,1) , getNoteDuration(duration,durationsFirst[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[4])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,4,1) , getNoteDuration(duration,durationsFirst[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[5])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,5,1) , getNoteDuration(duration,durationsFirst[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[6])+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,6,1) , getNoteDuration(duration,durationsFirst[7]));
        int subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote)-1;

        //bar2
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts+duration, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts+duration, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts+duration, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex)+ transpose, v, starts+duration*1 , getNoteDuration(duration,durations2[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[0])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,0,2) , getNoteDuration(duration,durations2[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[1])+ transpose, v,getNoteStartingPoint(starts,duration,durations2,1,2) , getNoteDuration(duration,durations2[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[2])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,2,2) , getNoteDuration(duration,durations2[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[3])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,3,2) , getNoteDuration(duration,durations2[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[4])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,4,2) , getNoteDuration(duration,durations2[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[5])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,5,2) , getNoteDuration(duration,durations2[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[6])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,6,2) , getNoteDuration(duration,durations2[7]));
        subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote)+1;

        //bar3
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity,  starts+duration*2, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts+duration*2, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts+duration*2, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex)+ transpose, v, starts+duration*2, getNoteDuration(duration,durations2[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[0])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,0,3) , getNoteDuration(duration,durations2[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[1])+ transpose, v,getNoteStartingPoint(starts,duration,durations2,1,3) , getNoteDuration(duration,durations2[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[2])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,2,3) , getNoteDuration(duration,durations2[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[3])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,3,3) , getNoteDuration(duration,durations2[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[4])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,4,3) , getNoteDuration(duration,durations2[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[5])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,5,3) , getNoteDuration(duration,durations2[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[6])+ transpose, v, getNoteStartingPoint(starts,duration,durations2,6,3) , getNoteDuration(duration,durations2[7]));
        subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote)-2;

        //bar4
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts+duration*3, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity,  starts+duration*3, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity,  starts+duration*3, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex)+ transpose, v, starts+duration*3, getNoteDuration(duration,durations3[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[0])+ transpose, v, getNoteStartingPoint(starts,duration,durations4,0,4) , getNoteDuration(duration,durations4[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[1])+ transpose, v,getNoteStartingPoint(starts,duration,durations4,1,4) , getNoteDuration(duration,durations4[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[2])+ transpose, v, getNoteStartingPoint(starts,duration,durations4,2,4) , getNoteDuration(duration,durations4[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[3])+ transpose, v, getNoteStartingPoint(starts,duration,durations4,3,4) , getNoteDuration(duration,durations4[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[4])+ transpose, v, getNoteStartingPoint(starts,duration,durations4,4,4) , getNoteDuration(duration,durations4[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote-1)+ transpose, v, getNoteStartingPoint(starts,duration,durations4,5,4) , getNoteDuration(duration,durations4[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote-1)+ transpose, v, getNoteStartingPoint(starts,duration,durations4,6,4) , getNoteDuration(duration,durations4[7]));
        subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote);
















    }

    public static void addChorus(MidiTrack noteTrack,int channelMelody,int chordChannel,int padChannel, String[] melody, String[] rythm, int start, int transpose) {
        int v=120;
        int padVelocity=85;
        int chordVelocity=120;
        long duration=getBarDuration(melody[32]);
        int key=getSongKey(rythm[44]);
        long starts = 4*duration * start;
        int centralNote=chooseMode(melody)[0];
        int indexOfCentralNote=ScalesByMelody.scaless.indexOf(centralNote);
        double[] durationsFirst=getFirstBarDurations(rythm[16]);
        double[] durations2=getBarDurations(rythm[17]);
        double[] durations3=getBarDurations(rythm[18]);
        double[] durations4=getBarDurations(rythm[19]);
        int[] intervals0=getIntervalsForMelody(melody[16]);
        int[] intervals1=getIntervalsForMelody(melody[17]);
        int[] intervals2=getIntervalsForMelody(melody[18]);
        int[] intervals3=getIntervalsForMelody(melody[19]);

        //bar1
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, padVelocity, starts, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, padVelocity, starts, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, padVelocity, starts, duration);

        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote)+ 12+transpose, v, starts+duration*0 , getNoteDuration(duration,durationsFirst[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[0])+  12+transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,0,1) , getNoteDuration(duration,durationsFirst[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[1])+ 12+ transpose, v,getNoteStartingPoint(starts,duration,durationsFirst,1,1) , getNoteDuration(duration,durationsFirst[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[2])+  12+transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,2,1) , getNoteDuration(duration,durationsFirst[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[3])+ 12+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,3,1) , getNoteDuration(duration,durationsFirst[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[4])+  12+transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,4,1) , getNoteDuration(duration,durationsFirst[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[5])+  12+transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,5,1) , getNoteDuration(duration,durationsFirst[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote+intervals0[6])+ 12+ transpose, v, getNoteStartingPoint(starts,duration,durationsFirst,6,1) , getNoteDuration(duration,durationsFirst[7]));
        int subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote)-1;

        //bar2
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex)-12+ transpose, padVelocity, starts+duration, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+2)-12+ transpose, padVelocity, starts+duration, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+4)-12+ transpose, padVelocity, starts+duration, duration);

        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, duration, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, duration, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, duration, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex)+  12+transpose, v, starts+duration*1 , getNoteDuration(duration,durations2[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[0])+ 12+ transpose, v, getNoteStartingPoint(starts,duration,durations2,0,2) , getNoteDuration(duration,durations2[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[1])+  12+transpose, v,getNoteStartingPoint(starts,duration,durations2,1,2) , getNoteDuration(duration,durations2[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[2])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations2,2,2) , getNoteDuration(duration,durations2[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[3])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations2,3,2) , getNoteDuration(duration,durations2[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[4])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations2,4,2) , getNoteDuration(duration,durations2[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[5])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations2,5,2) , getNoteDuration(duration,durations2[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals1[6])+ 12+ transpose, v, getNoteStartingPoint(starts,duration,durations2,6,2) , getNoteDuration(duration,durations2[7]));
        subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote)+1;

        //bar3
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex)-12+ transpose, padVelocity, starts+duration*2, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+2)-12+ transpose, padVelocity, starts+duration*2, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+4)-12+ transpose, padVelocity, starts+duration*2, duration);

        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts+duration*2, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts+duration*2, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts+duration*2, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex)+  12+transpose, v, starts+duration*2, getNoteDuration(duration,durations2[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[0])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations2,0,3) , getNoteDuration(duration,durations2[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[1])+  12+transpose, v,getNoteStartingPoint(starts,duration,durations2,1,3) , getNoteDuration(duration,durations2[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[2])+ 12+ transpose, v, getNoteStartingPoint(starts,duration,durations2,2,3) , getNoteDuration(duration,durations2[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[3])+ 12+ transpose, v, getNoteStartingPoint(starts,duration,durations2,3,3) , getNoteDuration(duration,durations2[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[4])+ 12+ transpose, v, getNoteStartingPoint(starts,duration,durations2,4,3) , getNoteDuration(duration,durations2[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[5])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations2,5,3) , getNoteDuration(duration,durations2[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals2[6])+ 12+ transpose, v, getNoteStartingPoint(starts,duration,durations2,6,3) , getNoteDuration(duration,durations2[7]));
        subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote)-2;

        //bar4
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex)-12+ transpose, padVelocity, starts+duration*3, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+2)-12+ transpose, padVelocity, starts+duration*3, duration);
        noteTrack.insertNote(padChannel, ScalesByMelody.scaless.get(subCentralIndex+4)-12+ transpose, padVelocity, starts+duration*3, duration);

        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote)-12+ transpose, chordVelocity, starts+duration*3, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+2)-12+ transpose, chordVelocity, starts+duration*3, duration);
        noteTrack.insertNote(chordChannel, ScalesByMelody.scaless.get(indexOfCentralNote+4)-12+ transpose, chordVelocity, starts+duration*3, duration);

        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex)+ 12+ transpose, v, starts+duration*3, getNoteDuration(duration,durations3[0]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[0])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations4,0,4) , getNoteDuration(duration,durations4[1]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[1])+  12+transpose, v,getNoteStartingPoint(starts,duration,durations4,1,4) , getNoteDuration(duration,durations4[2]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[2])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations4,2,4) , getNoteDuration(duration,durations4[3]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[3])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations4,3,4) , getNoteDuration(duration,durations4[4]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(subCentralIndex+intervals3[4])+  12+transpose, v, getNoteStartingPoint(starts,duration,durations4,4,4) , getNoteDuration(duration,durations4[5]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote-1)+  12+transpose, v, getNoteStartingPoint(starts,duration,durations4,5,4) , getNoteDuration(duration,durations4[6]));
        noteTrack.insertNote(channelMelody, getNoteByIndex(indexOfCentralNote-1)+  12+transpose, v, getNoteStartingPoint(starts,duration,durations4,6,4) , getNoteDuration(duration,durations4[7]));
        subCentralIndex=ScalesByMelody.scaless.indexOf(centralNote);
















    }

    private static int getNoteByIndex(int i) {
        return ScalesByMelody.scaless.get(i);
    }

    private static long getNoteDuration(long duration, double v) {
        double d=duration*v;
        long l=(long)d;
        Log.i("duration",""+l);
        return l;
    }


    public static void addBridge(ArrayList<Integer>scale,MidiTrack noteTrack, int chordChannel, int chordVelocity, int bassChannel,
                                 int bassVelocity, int drumsChannel, Progressions pr, String[] melody, String[] rythm,
                                 int whichChord,int index, int start, int transpose){




    }


    public static void addChorus(ArrayList<Integer>scale,MidiTrack noteTrack, int chordChannel, int chordVelocity, int bassChannel,
                                 int bassVelocity, int drumsChannel, Progressions pr, String[] melody, String[] rythm,
                                 int whichChord,int index, int start, int transpose) {



    }

    public static long getBarDuration(String colorR){
        long dur=0;
        switch (colorR){
            case "white":
                dur=1000;
                break;
            case "yellow":
                dur=1100;
                break;
            case "cyan":
                dur=1250;
                break;
            case "purple":
                dur=1400;
                break;
            case "red":
                dur=1600;
                break;
            case "green":
                dur=1700;
                break;
            case "blue":
                dur=1800;
                break;
            case "black":
                dur=1900;
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

    public static double[] getBarDurations(String colorR){
        double[] durs=new double[8];
        switch (colorR){
            case "white":
                durs= new double[]{0.25, 0.125, 0.125, 0.25, 0.125, 0.125, 0.0, 0.0};
                break;
            case "yellow":
                durs= new double[]{0.4, 0.4, 0.2, 0.0, 0.0, 0.0, 0.0, 0.0};
                break;
            case "cyan":
                durs= new double[]{0.375, 0.125, 0.375, 0.125, 0.0, 0.0, 0.0, 0.0};
                break;
            case "purple":
                durs= new double[]{0.25, 0.125, 0.25, 0.125, 0.125, 0.125, 0.0, 0.0};
                break;
            case "red":
                durs= new double[]{0.5, 0.25, 0.125, 0.125, 0.0, 0.0, 0.0, 0.0};
                break;
            case "green":
                durs= new double[]{0.375, 0.250, 0.125, 0.125, 0.125, 0.0, 0.0, 0.0};
                break;
            case "blue":
                durs= new double[]{0.125, 0.500, 0.125, 0.125, 0.125, 0.0, 0.0, 0.0};
                break;
            case "black":
                durs= new double[]{0.250, 0.125, 0.125, 0.375, 0.125, 0.0, 0.0, 0.0};
                break;
        }
        return durs;
    }

    public static double[] getFirstBarDurations(String colorR){
        double[] durs=new double[8];
        switch (colorR){
            case "white":
                durs= new double[]{0.75, 0.25, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                break;
            case "yellow":
                durs= new double[]{0.4, 0.4, 0.2, 0.0, 0.0, 0.0, 0.0, 0.0};
                break;
            case "cyan":
                durs= new double[]{0.625, 0.125, 0.125, 0.125, 0.0, 0.0, 0.0, 0.0};
                break;
            case "purple":
                durs= new double[]{0.625, 0.125, 0.250, 0.0625, 0.0, 0.0, 0.0, 0.0};
                break;
            case "red":
                durs= new double[]{0.75, 0.25, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                break;
            case "green":
                durs= new double[]{0.75, 0.25, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                break;
            case "blue":
                durs= new double[]{0.75, 0.25, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
                break;
            case "black":
                durs= new double[]{0.4, 0.4, 0.2, 0.0, 0.0, 0.0, 0.0, 0.0};
                break;
        }
        return durs;
    }

    public static int[] getIntervalsForMelody(String colorM){
        int[] durs=new int[8];
        switch (colorM){
            case "white":
                durs= new int[]{1, 2, 3, 2, 1, 2, 3, 2};
                break;
            case "yellow":
                durs= new int[]{-1, -2, -3, -2, -1, -2, -3, -2};
                break;
            case "cyan":
                durs= new int[]{6, 5, 4,5, 4, 3, 4, 3, 2};
                break;
            case "purple":
                durs= new int[]{4, 5, 4,3, 2, 1, 2, 1, 0};
                break;
            case "red":
                durs= new int[]{6, 7, 6,5, 4, 5, 4, 3,4};
                break;
            case "green":
                durs= new int[]{5, -1, 0,1, 2, 3, 2, 1, 2};
                break;
            case "blue":
                durs= new int[]{5, 1, 0,1, -2, -1, 0, 1, 2};
                break;
            case "black":
                durs= new int[]{2, 0, 1,0,2, 0, 3, 0, 1, 0};
                break;
        }
        return durs;
    }

    private static int[] chooseMode(String[] sss) {
        int score1=0;
        int score2=0;

        int[] moods=new int[2];
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
            moods[0]=48;
        }else if(score1<100){
            moods[0]=50;
        }else if(score1<150){
            moods[0]=52;
        }else if(score1<200){
            moods[0]=53;
        }else if(score1<250){
            moods[0]=55;
        }else if(score1<300){
            moods[0]=57;
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
            moods[1]=60;
        }else if(score2<100){
            moods[1]=62;
        }else if(score2<150){
            moods[1]=64;
        }else if(score2<200){
            moods[1]=65;
        }else if(score2<250){
            moods[1]=67;
        }else if(score2<300){
            moods[1]=69;
        }
        return moods;
    }

    public static long getNoteStartingPoint(long starts,long duration,double[] dur,int notePositionInBar,int bar){
        double intoTheBar=0.0;
        for(int i=0;i<=notePositionInBar;i++){
            if(dur[i]==0){
                continue;
            }
            intoTheBar+=dur[i];
            Log.i("stPoint",""+intoTheBar+" "+dur[i]+"bar:"+bar);
        }
        double point=starts+duration*(bar-1)+intoTheBar*duration;
        long l=(long)point;
        Log.i("longGet",""+l+"duble:"+point);
        return l;

    }

}
