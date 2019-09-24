package utils;

import utils.interfaces.InteractionPosition;

public class MoveRobot implements InteractionPosition<Position> {


    /***
     * Moves the position in the way the orientation indicates
     * @param orientation which indicate the way to move
     */
    public Position interactCoord(String orientation,Position p){
        Position newPosition = new Position();
        newPosition.setY(p.getY());
        newPosition.setX(p.getX());

        if (orientation.equals("N"))
            newPosition.setY(p.getY()+1);
        else if (orientation.equals("S"))
            newPosition.setY(p.getY()-1);
        else if (orientation.equals("E"))
            newPosition.setX(p.getX()+1);
        else if (orientation.equals("W"))
            newPosition.setX(p.getX()-1);
        return newPosition;
    }



}
