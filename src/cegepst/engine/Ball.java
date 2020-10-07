package cegepst.engine;

import java.util.Random;

public class Ball {

    private int radius = 25;
    private int x;
    private int y;
    private int velocityX;
    private int velocityY;

    public Ball(int radius) {
        this.radius = radius;

        x = getRandom(radius * 2, 800 - radius * 2);
        y = getRandom(radius * 2, 600 - radius * 2);
        velocityX = getRandom(0, 1) == 0 ? 10 : -10;
        velocityY = getRandom(0, 1) == 0 ? 10 : -10;
    }

    public void update() {
        x += velocityX;
        y += velocityY;
        if (hasTouchedVerticalBound()) {
            velocityY *= -1;

        }
        if (hasTouchedHorizontalBound()) {
            velocityX *= -1;
        }
    }

    public boolean hasTouchedBound() {
        return hasTouchedHorizontalBound() || hasTouchedVerticalBound();
    }

    public int getRadius() {
        return radius;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private boolean hasTouchedHorizontalBound() {
        return x <= radius || x >= 800 - radius;
    }

    private boolean hasTouchedVerticalBound() {
        return y <= radius || y >= 600 - radius;
    }

    private int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt((max-min) + 1) + min;
    }
}