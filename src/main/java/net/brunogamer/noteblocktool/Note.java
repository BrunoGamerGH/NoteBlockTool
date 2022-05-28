package net.brunogamer.noteblocktool;

/*
 *
 * https://minecraft.fandom.com/wiki/Note_Block#Notes
 *
 */


public enum Note {

    F3_SHARP(0.5F),
    G3(0.529732F),
    G3_SHARP(0.561231F),
    A3(0.594604F),
    A3_SHARP(0.629961F),
    B3(0.667420F),
    C4(0.707107F),
    C4_SHARP(0.749154F),
    D4(0.793701F),
    D4_SHARP(0.840896F),
    E4(0.890899F),
    F4(0.943874F),
    F4_SHARP(1.0F),
    G4(1.059463F),
    G4_SHARP(1.122462F),
    A4(1.189207F),
    A4_SHARP(1.259921F),
    B4(1.334840F),
    C5(1.414214F),
    C5_SHARP(1.498307F),
    D5(1.587401F),
    D5_SHARP(1.681793F),
    E5(1.781797F),
    F5(1.887749F),
    F5_SHARP(2.0F);

    private final float pitch;




    Note (float pitch) {
        this.pitch = pitch;
    }

    public float getPitch() {
        return pitch;
    }


}
