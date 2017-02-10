package phototomusic.nanter1986.com.phototomusic;

/**
 * Created by nanter1986 on 24/11/2016.
 */
public enum Chords {
    C4(60,64,67),
    D5(62,65,69),
    E5(64,67,71);

    private final int root;
    private final int middle;
    private final int top;

    Chords(int r, int m, int t) {
        this.root=r+12;
        this.middle=m+12;
        this.top=t+12;
    }
}
