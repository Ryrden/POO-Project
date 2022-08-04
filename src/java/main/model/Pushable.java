package main.model;

public class Pushable extends DynamicObstacle implements Movel{
    public Pushable(int posX,int posY, String imgNamePNG) {
        super(posX, posY, imgNamePNG);
        setIsPushable(true);
    }

    @Override
    public boolean moveUp() {
        return this.position.moveUp();
    }

    @Override
    public boolean moveDown() {
        return this.position.moveDown();
    }

    @Override
    public boolean moveRight() {
        return this.position.moveRight();
    }

    @Override
    public boolean moveLeft() {
        return this.position.moveLeft();
    }

    @Override
    public void backToLastPosition() {
        this.position.back();
    }
}
