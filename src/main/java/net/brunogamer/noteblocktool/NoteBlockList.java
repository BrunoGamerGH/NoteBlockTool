package net.brunogamer.noteblocktool;



import java.util.ArrayList;
import java.util.Arrays;

public class NoteBlockList extends ArrayList<NoteBlockProperties> {

    public NoteBlockList(NoteBlockProperties... properties) {
        if (!(properties == null)) {
            this.addAll(Arrays.asList(properties));
        }
    }
    public String getTickPropertiesLined() {

        String list = null;

        for (int i = 0; i < this.size(); i++) {
            if (list == null) {
                list = "Property " + (i + 1) + ": " + this.get(i).toString() + "\n";
            } else {
                list = list + "Property " + (i + 1) + ": " + this.get(i).toString() + "\n";
            }


        }
        return list;
    }
    public String getTickPropertiesCompacted() {

        String list = null;

        for (int i = 0; i < this.size(); i++) {
            if (list == null) {
                list = "Property " + (i + 1) + ": " + this.get(i).toString() + "; ";
            } else {
                list = list + "Property " + (i + 1) + ": " + this.get(i).toString() + "; ";
            }


        }
        return list;
    }


}

