package net.brunogamer.noteblocktool;

public enum Tempo {
    TWENTY_TICKS_PER_SECOND(1),
    TEN_TICKS_PER_SECOND(2),
    FIVE_TICKS_PER_SECOND(4),
    FOUR_TICKS_PER_SECOND(5),
    TWO_TICKS_PER_SECOND(10),
    ONE_TICK_PER_SECOND(20);

    private final int tempo;

    Tempo(int tempo) {
        this.tempo = tempo;
    }

    public int getTempo() {
        return tempo;
    }


}
