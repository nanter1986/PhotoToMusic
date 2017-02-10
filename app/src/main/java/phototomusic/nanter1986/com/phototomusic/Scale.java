package phototomusic.nanter1986.com.phototomusic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nanter1986 on 6/12/2016.
 */
public class Scale {
    public static ArrayList<Integer>choosenScale;
    public static ArrayList<Integer>scaless=new ArrayList<>(Arrays.asList(
            0,2,4,5,7,9,11,
            12,14,16,17,19,21,23,
            24,26,28,29,31,33,35,
            36,38,40,41,43,45,47,
            48,50,52,53,55,57,59,
            60,62,64,65,67,69,71,
            72,74,76,77,79,81,83,
            84,86,88,89,91,93,95,
            96,98,100,101,103,105,107));

    public static ArrayList<Integer>scalessHarmonicMinor=new ArrayList<>(Arrays.asList(
            0,2,3,5,7,8,11,
            12,14,15,17,19,20,23,
            24,26,27,29,31,32,35,
            36,38,39,41,43,44,47,
            48,50,51,53,55,56,59,
            60,62,63,65,67,68,71,
            72,74,75,77,79,80,83,
            84,86,87,89,91,92,95,
            96,98,99,101,103,104,107));

    public static ArrayList<Integer>scalessPersian=new ArrayList<>(Arrays.asList(
            0,1,4,5,6,8,11,
            12,13,16,17,18,20,23,
            24,25,28,29,30,32,35,
            36,37,40,41,42,44,47,
            48,49,52,53,54,56,59,
            60,61,64,65,66,68,71,
            72,73,76,77,78,80,83,
            84,85,88,89,90,92,95,
            96,97,100,101,102,104,107));

    public static ArrayList<Integer>scalessPrometheus=new ArrayList<>(Arrays.asList(
            0,2,4,6,10,
            12,14,16,18,22,
            24,26,28,30,34,
            36,38,40,42,46,
            48,50,52,54,58,
            60,62,64,66,70,
            72,74,76,78,82,
            84,86,88,90,94,
            96,98,100,102,106));
    public static int getPitch(int note,int octave){

        int pitch=scaless.get(note+octave*7);


        return pitch;

    }

    public static ArrayList<Integer> getScaleFlavor(String s){
        if(s.equals("harmonic")){
            choosenScale=scalessHarmonicMinor;
        }else if(s.equals("persian")){
            choosenScale=scalessPersian;
        }else if(s.equals("prometheus")){
            choosenScale=scalessPrometheus;
        }else{
            choosenScale=scaless;
        }
        return choosenScale;
    }
}
