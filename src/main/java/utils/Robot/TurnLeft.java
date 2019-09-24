package utils.Robot;

import utils.interfaces.InteractOrientation;

public class TurnLeft implements InteractOrientation<Position> {

    public TurnLeft(){
    }

    public String performOrientation(Position p) {
        String newOrientation = new String("");
        if (p.getOrientation().equals("N"))
            newOrientation = "W";
        else if (p.getOrientation().equals("S"))
            newOrientation = "E";
        else if (p.getOrientation().equals("E"))
            newOrientation = "N";
        else if (p.getOrientation().equals("W"))
            newOrientation = "S";
        else
            newOrientation = "";
        return newOrientation;
    }
}
