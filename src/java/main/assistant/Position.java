package main.assistant;

public class Position {
    private int posX;
    private int posY;

    private int previousPosX;
    private int previousPosY;

    public Position(int posX, int posY) {
        this.setPosition(posX, posY);
    }

    public boolean setPosition(int posX, int posY) {
        if (posX < 0 || posX >= Constants.HEIGHT_RESOLUTION)
            return false;
        previousPosX = this.posX;
        this.posX = posX;

        if (posY < 0 || posY >= Constants.WIDTH_RESOLUTION)
            return false;
        previousPosY = this.posY;
        this.posY = posY;

        return true;
    }

    public int getPosX() {
        return posX;
    }

    public boolean back() {
        return this.setPosition(previousPosX, previousPosY);
    }

    public int getPosY() {
        return posY;
    }

    public boolean equals(Position position) {
        return (posX == position.getPosX() && posY == position.getPosY());
    }

    public boolean copy(Position position) {
        return this.setPosition(position.getPosX(), position.getPosY());
    }

    public boolean moveUp() {
        return this.setPosition(this.getPosX() - 1, this.getPosY());
    }

    public boolean moveDown() {
        return this.setPosition(this.getPosX() + 1, this.getPosY());
    }

    public boolean moveRight() {
        return this.setPosition(this.getPosX(), this.getPosY() + 1);
    }

    public boolean moveLeft() {
        return this.setPosition(this.getPosX(), this.getPosY() - 1);
    }
}
