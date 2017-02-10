package phototomusic.nanter1986.com.phototomusic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.leff.midi.MidiTrack;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends Activity {

    Button choose;
    ImageView picD;
    Bitmap yourSelectedImage;
    Bitmap resized;
    MediaPlayer mp;
    TelephonyManager tm;
    CallStateListener csl=new CallStateListener();
    private static final int SELECT_PHOTO = 100;

    @Override
    protected void onDestroy() {
        if(tm==null){

        }else{
            tm.listen(csl,PhoneStateListener.LISTEN_NONE);
        }
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choose= (Button) findViewById(R.id.chooseme);
        picD=(ImageView) findViewById(R.id.picDisplay);
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPic();
            }
        });











    }

    private void getPic() {
        if(mp!=null){
            mp.stop();
        }
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, SELECT_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    InputStream imageStream = null;
                    try {
                        imageStream = getContentResolver().openInputStream(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    yourSelectedImage = BitmapFactory.decodeStream(imageStream);
                }
        }
        resized=Bitmap.createScaledBitmap(yourSelectedImage, 100, 100, true);
        String[] chords=PhotoAnalyzer.AnalyzePhotoChords(resized);
        String[] melody=PhotoAnalyzer.AnalyzePhotoMelody(resized);
        String[] rythm=PhotoAnalyzer.AnalyzePhotoRythm(resized);

        picD.setImageBitmap(yourSelectedImage);
        for(int i=0;i<melody.length;i++){
            Log.i("colors",melody[i]);
        }

        MidiTrack tt=Tempomaker.tempomake(4,4);
        SongMaker.makeFile("hey",chords,melody,rythm,tt);



        tm=(TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        tm.listen(csl,PhoneStateListener.LISTEN_CALL_STATE);

        mp=MediaPlayer.create(this, Uri.parse(Environment.getExternalStorageDirectory().getPath().toString()+ "/hey.mid"));


        mp.setLooping(true);
        mp.start();
    }

    public class CallStateListener extends PhoneStateListener{
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
