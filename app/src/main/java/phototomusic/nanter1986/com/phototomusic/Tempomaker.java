package phototomusic.nanter1986.com.phototomusic;

import com.leff.midi.MidiTrack;
import com.leff.midi.event.meta.Tempo;
import com.leff.midi.event.meta.TimeSignature;

/**
 * Created by nanter1986 on 16/11/2016.
 */
public class Tempomaker {
    public static MidiTrack tempomake(int i,int j){
        MidiTrack tempoTrack = new MidiTrack();
        TimeSignature ts = new TimeSignature();

        ts.setTimeSignature(i, j, TimeSignature.DEFAULT_METER, TimeSignature.DEFAULT_DIVISION);

        Tempo tempo = new Tempo();
        tempo.setBpm(100);

        tempoTrack.insertEvent(ts);
        tempoTrack.insertEvent(tempo);

        return tempoTrack;

    }
}
