package edu.vanier.spaceshooter.entities.invaders;

import edu.vanier.spaceshooter.models.Level;
import edu.vanier.spaceshooter.models.Sprite;
import javafx.scene.paint.Color;

public class Invader extends Sprite {
    private Level level;
    private double speed;
    private String pattern;

    public Invader(Level level, int posX, int posY, double speed, String pattern,
                   int width, int height, Color color) {
        super(posX, posY,width, height,"invader", color);

        this.level = level;
        this.speed = speed;
        this.pattern = pattern;
    }
}
