package utils.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.Robot.Position;
import utils.Robot.Robot;

public class ParseCommand {
    private  final String patternCoordinates = "\\d\\s\\d";
    private  final String patternPosition = "\\d\\s\\d\\s[N'|'S'|'E'|'W']";
    private  final String patternMovement = "['L'|'R'|'F']*";
    private Robot robot;

    public ParseCommand(Robot robot){
        this.robot = robot;
    }
    private String parseCommand(String command, String pattern){

        Pattern patternMatch = Pattern.compile(pattern);
        Matcher matcher = patternMatch.matcher(command);
        if (matcher.find())
            return matcher.group(0);
        else
            return "";
    }

    public boolean processGrid(String command){
        boolean found = false;
        String matcherGrid[] = this.parseCommand(command,patternCoordinates).split(" ");
        if (matcherGrid.length==2){
            this.robot.setPositionBoundaries(Integer.valueOf(matcherGrid[0]),Integer.valueOf(matcherGrid[1]));
            found = true;
        }
        return found;
    }
    public void processScent(Position p){
        if (p.getX()>0&&p.getY()>0)
            robot.setPositionScent(p.getX(),p.getY());
    }

    public boolean processPosition(String command){
        boolean found = false;
        String matcherPosition[] = this.parseCommand(command,patternPosition).split(" ");
        if (matcherPosition.length==3){
            this.robot.setPositionCurrent(Integer.valueOf(matcherPosition[0]),Integer.valueOf(matcherPosition[1])).setOrientation(matcherPosition[2]);
            found = true;
        }
        return found;
    }
    public boolean processMovement(String command){
        boolean found = false;
        String matcherMovement = this.parseCommand(command, patternMovement);
        int position = 0;
        int leng = matcherMovement.length();
        if (matcherMovement.length()!=0) {
            found = true;
            while (position < leng) {
                String movement = String.valueOf(matcherMovement.charAt(position));
                if (movement.equals("L") || movement.equals("R"))
                    this.robot.changeOrientation(movement);
                else if (movement.equals("F"))
                    this.robot.moveOneStep();
                position++;
            }
        }
        return found;
    }

    public Robot getRobot() {
        return robot;
    }
}
