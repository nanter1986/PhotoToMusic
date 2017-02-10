package phototomusic.nanter1986.com.phototomusic;

/**
 * Created by nanter1986 on 28/11/2016.
 */
public class ColortoVelocity {
    public static int ColortoVelocity(String s){
        int velocity=0;
        switch (s){
            case "white":
                velocity=120;
                break;
            case "yellow":
                velocity=120;
                break;
            case "cyan":
                velocity=120;
                break;
            case "purple":
               velocity=120;
                break;
            case "red":
                velocity=120;
                break;
            case "green":
                velocity=120;
                break;
            case "blue":
                velocity=120;
                break;
            case "black":
                velocity=120;
        }
        return velocity;
    }

    public static int ColortoVelocityChord(String s){
        int velocity=0;
        switch (s){
            case "white":
                velocity=0;
                break;
            case "yellow":
                velocity=0;
                break;
            case "cyan":
                velocity=60;
                break;
            case "purple":
                velocity=60;
                break;
            case "red":
                velocity=60;
                break;
            case "green":
                velocity=0;
                break;
            case "blue":
                velocity=60;
                break;
            case "black":
                velocity=60;
        }
        return velocity;
    }
}
