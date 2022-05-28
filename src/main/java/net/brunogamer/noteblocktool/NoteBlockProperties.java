package net.brunogamer.noteblocktool;

public class NoteBlockProperties {


    private final float volume;
    private final Note note;
    private final NoteBlockSound sound;


    public NoteBlockProperties(NoteBlockSound sound, Note note, float volume) {
        this.volume = volume;
        this.note = note;
        this.sound = sound;
    }
    public float getVolume() {
        return volume;
    }
    public Note getNote() {
        return note;
    }
    public NoteBlockSound getSound() {
        return sound;
    }

    @Override
    public String toString() {
        return "Sound: " + getSound().toString() + ", Note: " + getNote().toString() + ", Volume: " + getVolume();
    }
}
