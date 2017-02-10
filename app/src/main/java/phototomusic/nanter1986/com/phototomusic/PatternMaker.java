package phototomusic.nanter1986.com.phototomusic;

import java.util.ArrayList;

/**
 * Created by nanter1986 on 10/12/2016.
 */
public class PatternMaker {
    public static ArrayList<Integer> givePattern(String[] r,String[] m){
        ArrayList<Integer> pattern=new ArrayList<>();

        for(String s:m) {
            switch (s) {
                case "white":
                    pattern.add(0);
                    break;
                case "yellow":
                    pattern.add(1);
                    break;
                case "cyan":
                    pattern.add(1);
                    break;
                case "green":
                    pattern.add(2);
                    break;
                case "red":
                    pattern.add(-2);
                    break;
                case "blue":
                    pattern.add(-1);
                    break;
                case "purple":
                    pattern.add(-1);
                    break;
                case "black":
                    pattern.add(0);
                    break;
            }
        }
        return pattern;
    }

}
