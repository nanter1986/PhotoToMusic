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
        int chord1 = getAverageColorOfPixelArea(b,0,0);
        int chord2 = getAverageColorOfPixelArea(b,0,12);
        int chord3 = getAverageColorOfPixelArea(b,0,24);
        int chord4 = getAverageColorOfPixelArea(b,0,36);

        int chord5 = getAverageColorOfPixelArea(b,50,48);
        int chord6 = getAverageColorOfPixelArea(b,50,60);
        int chord7 = getAverageColorOfPixelArea(b,50,72);
        int chord8 = getAverageColorOfPixelArea(b,50,84);

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

    public static int getAverageColorOfPixelArea(Bitmap b,int x,int y){
        Log.i("testofsize",b.getWidth()+" "+b.getHeight());
        int widthOfPiece=50;
        int heightOfPiece=12;
        int totalOfPiece=0;
        int count=widthOfPiece*heightOfPiece;
        for(int i=x;i<x+widthOfPiece;i++){
            for(int j=y;j<y+heightOfPiece;j++){
                totalOfPiece+=b.getPixel(i,j);
            }
        }
        int average=totalOfPiece/count;

        return average;
    }
}
