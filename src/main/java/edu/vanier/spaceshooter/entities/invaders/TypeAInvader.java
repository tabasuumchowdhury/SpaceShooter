package edu.vanier.spaceshooter.entities.invaders;

import edu.vanier.spaceshooter.helpers.Level;
import javafx.scene.paint.Color;

public class TypeAInvader extends Invader{
    public TypeAInvader(Level level, int posX, int posY, double speed, String pattern, int width, int height, Color color) {
        super(level, posX, posY, speed, pattern, width, height, color);
    }
}
