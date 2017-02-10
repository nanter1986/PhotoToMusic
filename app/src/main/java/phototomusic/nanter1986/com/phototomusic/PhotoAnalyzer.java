package phototomusic.nanter1986.com.phototomusic;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import java.util.Arrays;

import static java.lang.Math.abs;

/**
 * Created by nanter1986 on 26/11/2016.
 */
public class PhotoAnalyzer {
    public static String[] AnalyzePhotoChords(Bitmap b) {

        //VERSE ************************************************************************************
        int chord1 = b.getPixel(25, 12);
        int chord2 = b.getPixel(25, 37);
        int chord3 = b.getPixel(25, 62);
        int chord4 = b.getPixel(25, 87);

        int chord5 = b.getPixel(75, 12);
        int chord6 = b.getPixel(75, 37);
        int chord7 = b.getPixel(75, 62);
        int chord8 = b.getPixel(75, 87);

        String[] chordArray = new String[8];
        chordArray[0]=getStrongColor(chord1);
        chordArray[1]=getStrongColor(chord2);
        chordArray[2]=getStrongColor(chord3);
        chordArray[3]=getStrongColor(chord4);
        chordArray[4]=getStrongColor(chord5);
        chordArray[5]=getStrongColor(chord6);
        chordArray[6]=getStrongColor(chord7);
        chordArray[7]=getStrongColor(chord8);

        return chordArray;
    }

    public static String[] AnalyzePhotoMelody(Bitmap b) {

        int[] pix = new int[64];
        String[] color=new String[64];

        for (int i = 0; i < 64; i++) {
            pix[i] = b.getPixel(20 + i, 50);

        }


        for(int i=0;i<64;i++) {
            color[i] = getStrongColor(pix[i]);
        }


        for(int i=0;i<color.length;i++){
            Log.i("dup",color[i]);
        }
        return color;

    }

    public static String[] AnalyzePhotoRythm(Bitmap b){
        int[] pix = new int[64];
        String[] color=new String[64];
        String[] colorWithoutDuplicates=new String[32];

        for (int i = 0; i < 64; i++) {
            pix[i] = b.getPixel(50,20 + i);

        }


        for(int i=0;i<64;i++) {
            color[i] = getStrongColor(pix[i]);
        }


        colorWithoutDuplicates=color;
        /*colorWithoutDuplicates[0]=color[0];
        for(int i=1;i<8;i++) {
            if(color[i].equals(color[i-1])){
                colorWithoutDuplicates[i]="yellow";
            }else{
                colorWithoutDuplicates[i]=color[i];
            }
        }
        colorWithoutDuplicates[8]=color[8];
        for(int i=9;i<16;i++) {
            if(color[i].equals(color[i-1])){
                colorWithoutDuplicates[i]="yellow";
            }else{
                colorWithoutDuplicates[i]=color[i];
            }
        }
        colorWithoutDuplicates[16]=color[16];
        for(int i=17;i<24;i++) {
            if(color[i].equals(color[i-1])){
                colorWithoutDuplicates[i]="yellow";
            }else{
                colorWithoutDuplicates[i]=color[i];
            }
        }
        colorWithoutDuplicates[24]=color[24];
        for(int i=25;i<32;i++) {
            if(color[i].equals(color[i-1])){
                colorWithoutDuplicates[i]="yellow";
            }else{
                colorWithoutDuplicates[i]=color[i];
            }
        }*/

        for(int i=0;i<color.length;i++){
            Log.i("dup",color[i] + colorWithoutDuplicates[i]);
        }

        return colorWithoutDuplicates;
    }










    public static String getStrongColor(int clr){

        int red=Color.red(clr);
        int green=Color.green(clr);
        int blue=Color.blue(clr);


        Log.i("numbers", Integer.toString(red) + " " + Integer.toString(green) + " " + Integer.toString(blue));



        if(abs(red-green)<60 && blue<60 && red>40 && green>40) {
            Log.i("domColor","yellow");
            return "yellow";
        }else if(abs(blue-green)<60 && red<60 && blue>40 && green>40){
            Log.i("domColor","cyan");
            return "cyan";
        }else if(abs(red-blue)<60 && green<60 && red>40 && blue>40){
            Log.i("domColor","purple");
            return "purple";
        } else if((red-blue>70) && (red-green>70)){
            Log.i("domColor","red");
            return "red";
        }else if(green-blue>70){
            Log.i("domColor","green");
            return "green";
        }else if(blue-green>70) {
            Log.i("domColor","blue");
            return "blue";
        }else if(blue>80 && red>80 && green>80){
            Log.i("domColor","white");
            return "white";
        }else{
            Log.i("domColor","black");
            return "black";
        }


    }
}
