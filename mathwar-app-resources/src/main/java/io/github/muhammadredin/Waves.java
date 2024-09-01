package io.github.muhammadredin;

import java.util.ArrayList;

public class Waves {
    private ArrayList<Entity> wave = new ArrayList<>();

    public ArrayList<Entity> getWave() {
        wave.add(Goblin.getObj());
        wave.add(Orc.getObj());
        wave.add(Goblin.getObj());
        wave.add(Goblin.getObj());
        return wave;
    }
}
