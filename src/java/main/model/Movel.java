package main.model;

public interface Movel {
     boolean moveUp() ;
     boolean moveDown();

     boolean moveRight();

     boolean moveLeft();

     void backToLastPosition();
}
