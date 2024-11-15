package edu.vanier.spaceshooter.controllers;

import edu.vanier.spaceshooter.entities.invaders.Invader;
import edu.vanier.spaceshooter.entities.players.Player;
import edu.vanier.spaceshooter.helpers.Level;
import edu.vanier.spaceshooter.entities.Sprite;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FXML Controller class of the MainApp UI.
 */
public class MainAppFXMLController {
    private final static Logger logger = LoggerFactory.getLogger(MainAppFXMLController.class);
    @FXML
    private Pane animationPanel;
    private double elapsedTime = 0;
    private Player spaceShip;
    private Scene mainScene;
    AnimationTimer gameLoop;

    @FXML
    public void initialize() {
        logger.info("Initializing MainAppController...");

        spaceShip = new Player(300, 750, 40, 40, Color.BLUE, Level.LEVEL1);
        animationPanel.setPrefSize(600, 800);
//        animationPanel.getChildren().add(spaceShip);
    }

    public void setupGameWorld() {
        initGameLoop();
        setupKeyPressHandlers();
        generateInvaders();
    }

    private void initGameLoop() {
        // Create the game loop.
        gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }
        };
        gameLoop.start();
    }

    /**
     * Sets up the key press event handler for the main scene.
     * <p>
     * This handler listens for specific key presses and executes corresponding
     * actions:
     * <ul>
     * <li>Pressing 'A' moves the spaceship to the left.</li>
     * <li>Pressing 'D' moves the spaceship to the right.</li>
     * <li>Pressing the SPACE key triggers the spaceship to shoot.</li>
     * </ul>
     * </p>
     */
    private void setupKeyPressHandlers() {
        // e the key event containing information about the key pressed.
        mainScene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case KeyCode.A ->
                        spaceShip.moveLeft();
                case KeyCode.D ->
                        spaceShip.moveRight();
                case KeyCode.SPACE ->
                        shoot(spaceShip);

            }
        });
    }

    List<Sprite> invaderList = new ArrayList<>();

    private void generateInvaders() {
        for (int i = 0; i < 5; i++) {
            Invader invader = new Invader(
                    Level.LEVEL1, 90 + i * 100,
                    150, 1, "sideways");
            invader.setImage(getClass().getResource("/images/ufoBlue.png").toExternalForm());
            double px = 350 * Math.random() + 50;
            double py = 350 * Math.random() + 50;
            invader.setPosition(px, py);
            invaderList.add(invader);
//            animationPanel.getChildren().add(invader);
        }
    }

    /**
     * Retrieves a list of all sprites currently in the animation panel.
     * <p>
     * This method iterates through the children of the animation panel and
     * collects those that are instances of {@link Sprite} into a list.
     * </p>
     *
     * @return A list of {@link Sprite} objects found in the animation panel.
     */
//    private List<Sprite> getSprites() {
//        List<Sprite> spriteList = new ArrayList<>();
//        for (Node n : animationPanel.getChildren()) {
//            if (n instanceof Sprite sprite) {
//                // We should add to the list any node that is a Sprite object.
//                spriteList.add(sprite);
//            }
//        }
//        return spriteList;
//    }

    /**
     * Updates the game state for each frame.
     * <p>
     * This method increments the elapsed time and processes each sprite based
     * on its type. It handles the movement and collision detection for enemy
     * bullets and player bullets, as well as the shooting behavior for enemies.
     * Dead sprites are removed from the animation panel, and the elapsed time
     * is reset after a certain threshold.
     * </p>
     */
    private void update() {
        elapsedTime += 0.016;
        // Actions to be performed during each frame of the animation.
        //getSprites().forEach(this::processSprite);
//        removeDeadSprites();

        // Reset the elapsed time.
        if (elapsedTime > 2) {
            elapsedTime = 0;
        }
    }

    private void processSprite(Sprite sprite) {
        switch (sprite.getType()) {
            case "enemybullet" ->
                handleEnemyBullet(sprite);
            case "playerbullet" ->
                handlePlayerBullet(sprite);
            case "enemy" ->
                handleEnemyFiring(sprite);
        }
    }

    private void handleEnemyBullet(Sprite sprite) {
        sprite.moveDown();
        // Check for collision with the spaceship
//        if (sprite.getBoundsInParent().intersects(spaceShip.getBoundsInParent())) {
//            spaceShip.setDead(true);
//            sprite.setDead(true);
//        }
    }

    private void handlePlayerBullet(Sprite sprite) {
        sprite.moveUp();
//        for (Sprite enemy : getSprites()) {
//            if (enemy.getType().equals("enemy")) {
//                // Check for collision with an enemy
//                if (sprite.getBoundsInParent().intersects(enemy.getBoundsInParent())) {
//                    enemy.setDead(true);
//                    sprite.setDead(true);
//                }
//            }
//        }
    }

    private void handleEnemyFiring(Sprite sprite) {
        if (elapsedTime > 2) {
            if (Math.random() < 0.3) {
                shoot(sprite);
            }
        }
    }

    /**
     * Removes all dead sprites from the animation panel.
     * <p>
     * This method iterates through the children of the animation panel and
     * removes any sprite that is marked as dead. It utilizes a lambda
     * expression to filter out the dead sprites efficiently.
     * </p>
     */
//    private void removeDeadSprites() {
//        animationPanel.getChildren().removeIf(n -> {
//            Sprite sprite = (Sprite) n;
//            return sprite.isDead();
//        });
//    }

    /**
     * Creates and adds a bullet sprite fired by the specified entity.
     * <p>
     * The firing entity can be either an enemy or the spaceship. A bullet is
     * created at the position of the firing entity with a slight offset to the
     * right. The bullet's dimensions are set, and it is given a type based on
     * the firing entity's type.
     * </p>
     *
     * @param firingEntity The entity that is firing the bullet, which can be
     * either an enemy or the spaceship.
     */
    private void shoot(Sprite firingEntity) {
        // The firing entity can be either an enemy or the spaceship.
        Sprite bullet = new Sprite(
                (int) firingEntity.getPositionX() + 20,
                (int) firingEntity.getPositionY(),
                firingEntity.getType() + "bullet");
//        animationPanel.getChildren().add(bullet);
    }

    public void setScene(Scene scene) {
        mainScene = scene;
    }

    public void stopAnimation() {
        if (gameLoop != null) {
            gameLoop.stop();
        }
    }
}
