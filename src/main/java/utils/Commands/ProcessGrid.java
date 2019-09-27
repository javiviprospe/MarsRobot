package utils.Commands;

import utils.Robot.Robot;
import utils.interfaces.InteractionCommand;
import utils.interfaces.InterfaceGenericParser;

public class ProcessGrid implements InteractionCommand {

    private Robot robot;
    private InterfaceGenericParser parseCommand;
    private final String patternCoordinates = "\\d\\s\\d";

    public ProcessGrid(InterfaceGenericParser parseCommand, Robot robot) {
        this.parseCommand = parseCommand;
        this.robot = robot;
    }

    public boolean processCommand(String command) {
        boolean found = false;
        parseCommand = new ParseCommandGeneric();
        String matcherGrid[] = this.parseCommand.parseCommand(command,patternCoordinates).split(" ");
        if (matcherGrid.length == 2) {
            this.robot.setPositionBoundaries(Integer.valueOf(matcherGrid[0]), Integer.valueOf(matcherGrid[1]));
            found = true;
        }
        return found;
    }

}
