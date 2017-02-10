package phototomusic.nanter1986.com.phototomusic.bymelody;

import android.util.Log;

import com.leff.midi.MidiTrack;

/**
 * Created by nanter1986 on 31/12/2016.
 */
public class MidiTrackMine extends MidiTrack{
    @Override
    public void insertNote(int channel, int pitch, int velocity, long tick, long duration) {
        if(duration==0){

        }else{
            super.insertNote(channel, pitch, velocity, tick, duration);
            Log.i("addNote","pitch:"+pitch+" "+"tick:"+tick+" "+"duration:"+duration);
        }
    }
}
