package utils.Commands;

import utils.Robot.Robot;
import utils.interfaces.InteractionCommand;
import utils.interfaces.InterfaceGenericParser;

public class ProcessPosition implements InteractionCommand {

    private Robot robot;
    private InterfaceGenericParser parseCommand;
    private  final String patternPosition = "\\d\\s\\d\\s[N'|'S'|'E'|'W']";

    public ProcessPosition(InterfaceGenericParser parseCommand, Robot robot) {
        this.parseCommand = parseCommand;
        this.robot = robot;
    }


    public boolean processCommand(String command){
        boolean found = false;
        String matcherPosition[] = this.parseCommand.parseCommand(command,patternPosition).split(" ");
        if (matcherPosition.length==3){
            this.robot.setPositionCurrent(Integer.valueOf(matcherPosition[0]),Integer.valueOf(matcherPosition[1])).setOrientation(matcherPosition[2]);
            found = true;
        }
        return found;
    }
}
