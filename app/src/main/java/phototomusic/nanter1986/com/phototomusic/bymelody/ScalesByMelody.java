package phototomusic.nanter1986.com.phototomusic.bymelody;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nanter1986 on 31/12/2016.
 */
public class ScalesByMelody {
    public static ArrayList<Integer> choosenScale;
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

    public static ArrayList<Integer> getScale(){
        choosenScale=scaless;
        return choosenScale;
    }
}
