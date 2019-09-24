package utils.Robot;

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
    private final int outOfBound = -51;

    public Robot(){
        this.turnLeft = new TurnLeft();
        this.turnRight = new TurnRight();
        this.moveRobot = new MoveRobot();
        this.positionCurrent = new Position();
        this.positionScent = new Position();
        this.outOfGrid = false;
        this.positionScent.setY(this.outOfBound);
        this.positionScent.setX(this.outOfBound);
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

    public Robot setPositionScent(int x, int y){
        this.positionScent = new Position(x,y);
        return this;
    }

    /***
     * Performs change of orientation in the grid(Left , Right)
     * @param orientation N W S E
     * @return new Orientation
     */
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

    /***
     * Performs Robot movement. If scent is sent and current position is that one, do not nothing.
     * Else if it's under boundaries, doit. Else It's out and scent is marked;
     * @return this
     */
    public Robot moveOneStep(){
        if (!outOfGrid) {
            Position positionPotential = (Position) this.moveRobot.interactCoord(this.positionCurrent.getOrientation(), this.positionCurrent);
            if (positionPotential.getX() == positionScent.getX() && positionPotential.getY() == positionScent.getY())
            {
                //do nothing
            }
            else if (positionPotential.getX() <= positionBoundaries.getX()
                && positionPotential.getY() <= positionBoundaries.getY()
                && positionPotential.getX() != -1 && positionPotential.getY() != -1) {
                positionCurrent.setX(positionPotential.getX());
                positionCurrent.setY(positionPotential.getY());
            } else {
                this.outOfGrid = true;
                this.setPositionScent( positionPotential.getX(),positionPotential.getY());
            }
        }
        return this;

    }
    public String getPosition(){
            return this.positionCurrent.getX()+" "+this.positionCurrent.getY();
    }

    public Position getPositionScent(){
        return this.positionScent;
    }

    public String getOrientation(){
            return positionCurrent.getOrientation();

    }
    public boolean isOutOfGrid(){
        return this.outOfGrid;
    }
}
