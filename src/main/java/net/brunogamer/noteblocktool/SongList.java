package net.brunogamer.noteblocktool;

import java.util.ArrayList;
import java.util.Arrays;

public class SongList extends ArrayList<NoteBlockList> {




    public SongList(NoteBlockList... soundlists) {
        this.addAll(Arrays.asList(soundlists));

    }

    public String getTicksLined() {

        String list = null;

        for (int i = 0;i < this.size(); i++) {
            if (i != this.size() - 1) {
                if (list == null) {
                    list = "[" + (i + 1) + ": " + "NoteBlockList[" + this.get(i).getTickPropertiesCompacted() + "]\n";
                } else {
                    list = list + (i + 1) + ": " + "NoteBlockList[" + this.get(i).getTickPropertiesCompacted() + "]\n";
                }
            } else {
                list = list + (i + 1) + ": " + "NoteBlockList[" + this.get(i).getTickPropertiesCompacted() + "]]";
            }


        }
        list = list + "]";

        return list;
    }
    public String getTicksCompacted() {

        String list = null;

        for (int i = 0;i < this.size(); i++) {
            if (i != this.size() - 1) {
                if (list == null) {
                    list = "[" + (i + 1) + ": " + "NoteBlockList[" + this.get(i).getTickPropertiesCompacted() + "]; ";
                } else {
                    list = list + (i + 1) + ": " + "NoteBlockList[" + this.get(i).getTickPropertiesCompacted() + "]; ";
                }
            } else {
                list = list + (i + 1) + ": " + "NoteBlockList[" + this.get(i).getTickPropertiesCompacted() + "];]";
            }


        }


        return list;
    }





}
