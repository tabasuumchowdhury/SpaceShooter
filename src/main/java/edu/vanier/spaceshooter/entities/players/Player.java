package edu.vanier.spaceshooter.entities.players;

import edu.vanier.spaceshooter.helpers.Level;
import edu.vanier.spaceshooter.entities.Sprite;
import javafx.scene.paint.Color;

public class Player extends Sprite {
    private Level level;
    private double speed;
    private double lives = 3;
    private double score = 0;
    public Player(int x, int y, int width, int height, Color color, Level level) {
        super(x, y, "player");

        this.level = level;
    }

}
