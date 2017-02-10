package phototomusic.nanter1986.com.phototomusic;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.ImageView;

import com.leff.midi.MidiTrack;

import java.util.Random;

import phototomusic.nanter1986.com.phototomusic.bymelody.SongMakerByMelody;

public class MelodyMainActivity extends Activity {

    Button choose;
    ImageView picD;
    Bitmap yourSelectedImage;
    Bitmap resized;

    TelephonyManager tm;
    CallStateListener csl=new CallStateListener();
    private static final int SELECT_PHOTO = 100;

    @Override
    protected void onDestroy() {
        if(tm==null){

        }else{
            tm.listen(csl, PhoneStateListener.LISTEN_NONE);
        }
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.infinite);

        tm=(TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(csl,PhoneStateListener.LISTEN_CALL_STATE);

        makeNextSong();













    }

    public void makeNextSong(){
        String[] chords=new String[64];
        String[] melody=new String[64];
        String[] rythm=new String[64];

        for(int i=0;i<64;i++){

            chords[i]=giveRandomStringColor();
        }
        for(int i=0;i<64;i++){

            melody[i]=giveRandomStringColor();
        }
        for(int i=0;i<64;i++){

            rythm[i]=giveRandomStringColor();
        }

        MidiTrack tt=Tempomaker.tempomake(4,4);
        SongMaker.makeFile("hey",chords,melody,rythm,tt);

        MediaPlayer mp=MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath().toString()+ "/hey.mid"));

        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                makeNextSong();
            }
        });


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





    public class CallStateListener extends PhoneStateListener{
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            switch(state){
                case TelephonyManager.CALL_STATE_RINGING:
                    finish();
            }
        }
    }
}
