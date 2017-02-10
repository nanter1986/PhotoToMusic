package phototomusic.nanter1986.com.phototomusic;

import com.leff.midi.event.ProgramChange;

/**
 * Created by nanter1986 on 28/11/2016.
 */
public class OrganSelection {
    public static ProgramChange highSelection(String color) {
        int organ = 0;
        switch (color) {
            case "yellow":
                organ = ProgramChange.MidiProgram.ALTO_SAX.programNumber();
                break;
            case "cyan":
                organ = ProgramChange.MidiProgram.FLUTE.programNumber();
                break;
            case "purple":
                organ = ProgramChange.MidiProgram.VIOLIN.programNumber();
                break;
            case "red":
                organ = ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber();
                break;
            case "green":
                organ = ProgramChange.MidiProgram.BANJO.programNumber();
                break;
            case "blue":
                organ = ProgramChange.MidiProgram.CLARINET.programNumber();
                break;
            case "black":
                organ = ProgramChange.MidiProgram.CHURCH_ORGAN.programNumber();
                break;
        }
        ProgramChange pc = new ProgramChange(0, 1, organ);
        return pc;
    }



    public static ProgramChange midSelection(String color) {
        int organ = 0;
        switch (color) {
            case "yellow":
                organ = ProgramChange.MidiProgram.PAD_1_NEW_AGE.programNumber();
                break;
            case "cyan":
                organ = ProgramChange.MidiProgram.ELECTRIC_GUITAR_CLEAN.programNumber();
                break;
            case "purple":
                organ = ProgramChange.MidiProgram.CHOIR_AAHS.programNumber();
                break;
            case "red":
                organ = ProgramChange.MidiProgram.ACOUSTIC_GUITAR_NYLON.programNumber();
                break;
            case "green":
                organ = ProgramChange.MidiProgram.ORCHESTRAL_HARP.programNumber();
                break;
            case "blue":
                organ = ProgramChange.MidiProgram.ORCHESTRA_HIT.programNumber();
                break;
            case "black":
                organ = ProgramChange.MidiProgram.DISTORTION_GUITAR.programNumber();
                break;
        }
        ProgramChange pc = new ProgramChange(0, 0, organ);
        return pc;
    }

}

