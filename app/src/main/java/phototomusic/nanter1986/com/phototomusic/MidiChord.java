package phototomusic.nanter1986.com.phototomusic;

import android.util.Log;

import com.leff.midi.MidiTrack;

/**
 * Created by nanter1986 on 16/11/2016.
 */
public class MidiChord extends MidiTrack{
    int root;
    int middle;
    int top;

    String noteSymbol;
    int oct;

    public static MidiChord chordMake(String n,int oc,String quality){
        int intNote;
        MidiChord mCH = new MidiChord();
        if(quality.equals("western")){
            switch (n){
                case "c":
                    mCH.root=36;
                    mCH.middle=40;
                    mCH.top=43;

                    break;
                case "d":
                    mCH.root=38;
                    mCH.middle=41;
                    mCH.top=45;

                    break;
                case "e":
                    mCH.root=40;
                    mCH.middle=43;
                    mCH.top=35;
                    break;
                case "f":
                    mCH.root=41;
                    mCH.middle=45;
                    mCH.top=36;
                    break;
                case "g":
                    mCH.root=43;
                    mCH.middle=47;
                    mCH.top=38;

                    break;
                case "a":
                    mCH.root=45;
                    mCH.middle=48;
                    mCH.top=40;

                    break;
                case "b":
                    mCH.root=35;
                    mCH.middle=38;
                    mCH.top=41;

                    break;

                default:
                    intNote=0;



            }
        }else if(quality.equals("harmonic")){
            switch (n){
                case "c":
                    mCH.root=36;
                    mCH.middle=39;
                    mCH.top=43;

                    break;
                case "d":
                    mCH.root=38;
                    mCH.middle=41;
                    mCH.top=44;

                    break;
                case "e":
                    mCH.root=39;
                    mCH.middle=43;
                    mCH.top=35;
                    break;
                case "f":
                    mCH.root=41;
                    mCH.middle=44;
                    mCH.top=36;
                    break;
                case "g":
                    mCH.root=43;
                    mCH.middle=47;
                    mCH.top=38;

                    break;
                case "a":
                    mCH.root=44;
                    mCH.middle=48;
                    mCH.top=39;

                    break;
                case "b":
                    mCH.root=35;
                    mCH.middle=38;
                    mCH.top=41;

                    break;

                default:
                    intNote=0;



            }
        }else if(quality.equals("persian")){
            switch (n){
                case "c":
                    mCH.root=36;
                    mCH.middle=40;
                    mCH.top=42;

                    break;
                case "d":
                    mCH.root=37;
                    mCH.middle=41;
                    mCH.top=44;

                    break;
                case "e":
                    mCH.root=40;
                    mCH.middle=42;
                    mCH.top=35;
                    break;
                case "f":
                    mCH.root=41;
                    mCH.middle=44;
                    mCH.top=36;
                    break;
                case "g":
                    mCH.root=42;
                    mCH.middle=47;
                    mCH.top=37;

                    break;
                case "a":
                    mCH.root=44;
                    mCH.middle=48;
                    mCH.top=40;

                    break;
                case "b":
                    mCH.root=35;
                    mCH.middle=37;
                    mCH.top=41;

                    break;

                default:
                    intNote=0;



            }
        }else if(quality.equals("prometheus")){
            switch (n){
                case "c":
                    mCH.root=36;
                    mCH.middle=40;
                    mCH.top=46;

                    break;
                case "d":
                    mCH.root=38;
                    mCH.middle=42;
                    mCH.top=48;

                    break;
                case "e":
                    mCH.root=40;
                    mCH.middle=46;
                    mCH.top=36;
                    break;
                case "f":
                    mCH.root=42;
                    mCH.middle=48;
                    mCH.top=38;
                    break;
                case "g":
                    mCH.root=46;
                    mCH.middle=50;
                    mCH.top=40;

                    break;
                case "a":
                    mCH.root=48;
                    mCH.middle=52;
                    mCH.top=34;

                    break;
                case "b":
                    mCH.root=38;
                    mCH.middle=42;
                    mCH.top=48;

                    break;

                default:
                    intNote=0;



            }
        }









        mCH.noteSymbol=n;

        mCH.oct=oc;

        return mCH;
    }
}
