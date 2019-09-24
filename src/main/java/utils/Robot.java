package utils;

import javafx.geometry.Pos;
import utils.interfaces.InteractOrientation;
import utils.interfaces.InteractionPosition;

public class Robot {

    private Position positionCurrent;
    private Position positionBoundaries;
    private Position positionScent;
    private boolean outOfGrid;
    private InteractOrientation turnLeft;
    private InteractOrientation turnRight;
    private InteractionPosition moveRobot;

    public Robot(){
        this.turnLeft = new TurnLeft();
        this.turnRight = new TurnRight();
        this.moveRobot = new MoveRobot();
        this.positionCurrent = new Position();
        this.outOfGrid = false;
    }

    public Robot setPositionCurrent(int x, int y){
        this.positionCurrent.setX(x);
        this.positionCurrent.setY(y);
        return this;
    }

    public Robot setOrientation(String orientation){
        this.positionCurrent.setOrientation(orientation);
        return this;
    }

    public Robot setPositionBoundaries(int x, int y){
        this.positionBoundaries = new Position(x,y);
        return this;
    }

    private Robot setPositionScent(int x, int y){
        this.positionScent = new Position(x,y);
        return this;
    }

    public Robot changeOrientation(String orientation){
        if (!outOfGrid) {
            String newOrientation = new String();
            orientation = orientation.toUpperCase();
            if (orientation.equals("L"))
                this.positionCurrent.setOrientation(turnLeft.performOrientation(this.positionCurrent));
            else if (orientation.equals("R"))
                this.positionCurrent.setOrientation(turnRight.performOrientation(this.positionCurrent));
        }
        return this;
    }

    public Robot moveOneStep(){
        if (!outOfGrid) {
            Position positionPotential = (Position) this.moveRobot.interactCoord(this.positionCurrent.getOrientation(), this.positionCurrent);
            if (positionPotential.getX() <= positionBoundaries.getX() && positionPotential.getY() <= positionBoundaries.getY()
                && positionPotential.getX() != -1 && positionPotential.getY() != -1) {
                positionCurrent.setX(positionPotential.getX());
                positionCurrent.setY(positionPotential.getY());
            } else {
                this.outOfGrid = true;
                this.positionScent = positionCurrent;
            }
        }
        return this;

    }
    public String getPosition(){
        if (outOfGrid)
            return this.positionScent.getX()+" "+this.positionScent.getY();
        else
            return this.positionCurrent.getX()+" "+this.positionCurrent.getY();
    }

    public String getOrientation(){
        if (outOfGrid)
            return positionScent.getOrientation();
        else
            return positionCurrent.getOrientation();
    }
    public boolean isOutOfGrid(){
        return this.outOfGrid;
    }
}
