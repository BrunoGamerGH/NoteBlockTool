# NoteBlockTool

I have not found that many tools that help the use of noteblock music making on plugins, so i made this repository for whoever finds this and uses.

### Repository and Dependency:

 #### Maven:
  ````xml
  <repository>
        <id>brunogamer-repo</id>
        <url>https://nexus.brunogamer.xyz/repository/brunogamer-repo/</url>
  </repository>
 
  <dependency>
        <groupId>net.brunogamer</groupId>
        <artifactId>NoteBlockTool</artifactId>
        <version>1.0</version>
  </dependency>
   ````
   
 #### Gradle:
   ```gradle
repositories {
    maven { url "https://nexus.brunogamer.xyz/repository/brunogamer-repo/" }
}

dependencies {
    compileOnly group: "net.brunogamer", name: "NoteBlockTool", version: "1.0";
}
```
   
#### Example code:
  

  
   ````java
        NoteBlockList tick1 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.D4, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.D4, 1.00f));
        NoteBlockList tick2 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.D4, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.D4, 1.00f));
        NoteBlockList tick3 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.D5, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.D5, 1.00f));
        NoteBlockList tick4 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.D5, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.D5, 0.30f));
        NoteBlockList tick5 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.A4, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.A4, 1.00f));
        NoteBlockList tick6 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.A4, 0.30f),new NoteBlockProperties(NoteBlockSound.HARP, Note.A4, 0.30f));
        // If you want to make a pause on the music, just dont add anything.
        NoteBlockList tick7 = new NoteBlockList();
        NoteBlockList tick8 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.G4_SHARP, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.G4_SHARP, 1.00f));
        NoteBlockList tick9 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.G4_SHARP, 0.30f),new NoteBlockProperties(NoteBlockSound.HARP, Note.G4_SHARP, 0.30f));
        NoteBlockList tick10 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.G4, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.G4, 1.00f));
        NoteBlockList tick11 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.G4, 0.30f),new NoteBlockProperties(NoteBlockSound.HARP, Note.G4, 0.30f));
        NoteBlockList tick12 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.F4, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.F4, 1.00f));
        NoteBlockList tick13 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.F4, 0.30f),new NoteBlockProperties(NoteBlockSound.HARP, Note.F4, 0.30f));
        NoteBlockList tick14 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.D4, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.D4, 1.00f));
        NoteBlockList tick15 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.F4, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.F4, 1.00f));
        NoteBlockList tick16 = new NoteBlockList(new NoteBlockProperties(NoteBlockSound.FLUTE, Note.G4, 1.00f),new NoteBlockProperties(NoteBlockSound.HARP, Note.G4, 1.00f));



        SongList song = new SongList(tick1,
                tick2,
                tick3,
                tick4,
                tick5,
                tick6,
                tick7,
                tick8,
                tick9,
                tick10,
                tick11,
                tick12,
                tick13,
                tick14,
                tick15,
                tick16);
          
         // You can use Event#getPlayer/any other method to send to only one player, it would still be the same
        for (Player player: Bukkit.getOnlinePlayers()) {
            NoteBlockMusic music = new NoteBlockMusic(Tempo.TEN_TICKS_PER_SECOND, song, player, this);
            //                                                                                   ^^   You need to get your Main class instance to replace this parameter 
            music.play();
        } 
        
