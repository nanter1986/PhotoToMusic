package phototomusic.nanter1986.com.phototomusic;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.leff.midi.MidiFile;
import com.leff.midi.MidiTrack;
import com.leff.midi.event.ProgramChange;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LearningActivity extends Activity {

    Button happy;
    Button sad;
    Button epic;
    Button horror;
    Button loving;
    Button exit;
    MediaPlayer mp;

    TelephonyManager tm;
    CallStateListener csl=new CallStateListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);

        happy=(Button)findViewById(R.id.happy);
        sad=(Button)findViewById(R.id.sad);
        epic=(Button)findViewById(R.id.epic);
        horror=(Button)findViewById(R.id.horror);
        loving=(Button)findViewById(R.id.loving);
        exit=(Button)findViewById(R.id.exit);

        tm=(TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(csl,PhoneStateListener.LISTEN_CALL_STATE);

        setListeners();
    }

    private void setListeners() {
        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        epic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        horror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        loving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void makeNextSong(){
        ArrayList<MidiTrack> tracks = new ArrayList<>();
        MidiTrack noteTrack=new MidiTrack();

        MidiTrack tt=Tempomaker.tempomake(4,4);
        noteTrack.insertEvent(new ProgramChange(0,0, ProgramChange.MidiProgram.ACOUSTIC_GUITAR_NYLON.programNumber()));

        for(int i=0;i<17;i++){
            Random r=new Random();
            int pitch=r.nextInt(12)+60;
            noteTrack.insertNote(0, pitch , 120, i*200, 200);
        }

        tracks.add(tt);
        tracks.add(noteTrack);

        MidiFile midii = new MidiFile(MidiFile.DEFAULT_RESOLUTION, tracks);
        String namee= Environment.getExternalStorageDirectory().getPath().toString() + "/" + "theMelody" + ".mid";

        File f = new File(namee);
        try {
            midii.writeToFile(f);
            Log.i("s","written");
        } catch (IOException e) {
            e.printStackTrace();
        }


        mp.setLooping(true);
        mp=MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath().toString()+ "/theMelody.mid"));

        mp.start();
    }

    public static String giveRandomStringColor(){
        Random r=new Random();
        int selector=r.nextInt(8);
        String s="";
        if(selector==0){
            s="white";
        }else if(selector==1){
            s="yellow";
        }else if(selector==2){
            s="cyan";
        }else if(selector==3){
            s="green";
        }else if(selector==4){
            s="red";
        }else if(selector==5){
            s="blue";
        }else if(selector==6){
            s="purple";
        }else if(selector==7){
            s="black";
        }
        return s;
    }

    public class CallStateListener extends PhoneStateListener {
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch(state){
                case TelephonyManager.CALL_STATE_RINGING:
                    if(mp==null){

                    }else{
                        mp.stop();
                        Log.i("stopMP","stopped, you are awesome");
                    }
            }
        }
    }
}
