package utils.Robot;

import utils.interfaces.InteractOrientation;

public class TurnRight implements InteractOrientation<Position> {

    public String performOrientation(Position p) {
        String newOrientation = new String("");
        if (p.getOrientation().equals("S"))
            newOrientation = "W";
        else if (p.getOrientation().equals("N"))
            newOrientation = "E";
        else if (p.getOrientation().equals("W"))
            newOrientation = "N";
        else if (p.getOrientation().equals("E"))
            newOrientation = "S";
        else
            newOrientation = "";
        return newOrientation;
    }
}
