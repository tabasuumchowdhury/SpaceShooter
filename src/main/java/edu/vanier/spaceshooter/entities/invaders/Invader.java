package edu.vanier.spaceshooter.entities.invaders;

import edu.vanier.spaceshooter.helpers.Level;
import edu.vanier.spaceshooter.entities.Sprite;
import javafx.scene.paint.Color;

public class Invader extends Sprite {
    private Level level;
    private double speed;
    private String pattern;

    public Invader(Level level, int posX, int posY, double speed, String pattern) {
        super(posX, posY,"invader");

        this.level = level;
        this.speed = speed;
        this.pattern = pattern;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return "Invader{" +
                "level=" + level +
                ", speed=" + speed +
                ", pattern='" + pattern + '\'' +
                '}';
    }
}
