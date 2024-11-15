package edu.vanier.spaceshooter.entities;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite {
    private double health = 100;
    private boolean dead = false;
    private final String type;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private Image image;

    public Sprite(int x, int y, String type) {
        this.type = type;
        setPosition(x,y);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setImage(String filename) {
        Image i = new Image(filename);
        setImage(i);
    }

    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
    }
    public void moveLeft() {
        setPosition(getPositionX() - 5, getPositionY());
    }

    public void moveRight() {
        setPosition(getPositionX() + 5, getPositionY());    }

    public void moveUp() {
        setPosition(getPositionX(), getPositionY() - 5);
    }

    public void moveDown() {
        setPosition(getPositionX(), getPositionY() - 5);
    }

    public boolean isDead() {
        return dead;
    }

    public String getType() {
        return type;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public double getHealth() {
        return health;
    }
    public void setHealth(double damage) {
        health -= damage;
        if (health == 0)
            setDead(true);
    }
}
