package net.brunogamer.noteblocktool;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public class NoteBlockMusic {

    private SongList list;
    private Tempo tempo;
    private Player player;
    private int ticksPassed = 0;
    private Plugin main;

    public NoteBlockMusic(Tempo tempo, SongList list, Player player, Plugin main) {
        this.tempo = tempo;
        this.list = list;
        this.player = player;
        this.main = main;
    }

    public NoteBlockMusic(Tempo tempo, Player player, Plugin main) {
        this.tempo = tempo;
        this.player = player;
        this.main = main;
        this.list = new SongList();
    }

    public Tempo getTempo() {
        return tempo;
    }
    public SongList getList() {
        return list;
    }
    public Player getPlayer() {
        return player;
    }
    public Plugin getMain() {
        return main;
    }
    public void setTempo(Tempo tempo) {
        this.tempo = tempo;
    }
    public void setList(SongList list) {
        this.list = list;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setMain(Plugin main) {
        this.main = main;
    }

    // Adds ticks, clearly
    public void addTicks(NoteBlockProperties... properties) {


        getList().add(new NoteBlockList(properties));
    }

    /* Modifies a certain tick. tickNumber is the position of the tick, starting from 1, not 0. modifyType specifies what type is gonna be the
    modification. properties are the NoteBlock Properties.
    */
    public void modifyTick(int tickNumber, String modifyType, NoteBlockProperties... properties) {
        try {
            getList().get(tickNumber - 1);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return;
        }
        if (modifyType.equalsIgnoreCase("add")) {
            getList().get(tickNumber - 1).addAll(Arrays.asList(properties));
        } else if (modifyType.equalsIgnoreCase("removeall")) {
            getList().get(tickNumber -1).clear();
        }
    }

    public void modifyTick(int tickNumber, String modifyType, int propertyNumber) {
        try {
            getList().get(tickNumber - 1);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return;
        }
        if (modifyType.equalsIgnoreCase("remove")) {
            getList().get(tickNumber - 1).remove(propertyNumber - 1);
        }
    }

    // Gets the NoteBlockProperties info. tickNumber already specified.
    public String getTickInfo(int tickNumber) {
        return getList().get(tickNumber - 1).getTickPropertiesLined();
    }

    // Gets the tick. tickNumber already specified.
    public NoteBlockList getTick(int tickNumber) {
        return getList().get(tickNumber - 1);
    }



    // Startes the song
    public void play() {

        if (!(ticksPassed >= list.size())) {
            for (NoteBlockProperties sound : list.get(ticksPassed))
                if (sound != null) {

                    try {
                        player.playSound(player.getLocation(), Sound.valueOf("BLOCK_NOTE_BLOCK_" + sound.getSound()), sound.getVolume(),sound.getNote().getPitch());
                    } catch (IllegalArgumentException e) {
                        if (sound.getSound() == NoteBlockSound.EXPERIENCE) {
                            player.playSound(player.getLocation(),Sound.ENTITY_EXPERIENCE_ORB_PICKUP, sound.getVolume(),sound.getNote().getPitch());
                        } else if (sound.getSound() == NoteBlockSound.ANVIL) {
                            player.playSound(player.getLocation(),Sound.BLOCK_ANVIL_LAND, sound.getVolume(),sound.getNote().getPitch());
                        } else if (sound.getSound() == NoteBlockSound.PORTAL) {
                            player.playSound(player.getLocation(),Sound.BLOCK_PORTAL_TRIGGER, sound.getVolume(),sound.getNote().getPitch());
                        } else if (sound.getSound() == NoteBlockSound.END_PORTAL) {
                            player.playSound(player.getLocation(),Sound.BLOCK_END_PORTAL_SPAWN, sound.getVolume(), sound.getNote().getPitch());
                        }

                    }



                }
            ticksPassed++;

        }



        new BukkitRunnable() {

            @Override
            public void run() {

                cancel();
                NoteBlockMusic.this.play();



            }
        }.runTaskTimer(main, tempo.getTempo(),1);

    }


}
