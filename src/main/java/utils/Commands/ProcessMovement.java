package utils.Commands;

import utils.Robot.Robot;
import utils.interfaces.InteractionCommand;
import utils.interfaces.InterfaceGenericParser;

public class ProcessMovement implements InteractionCommand {

    private Robot robot;
    private InterfaceGenericParser parseCommand;
    private  final String patternMovement = "['L'|'R'|'F']*";

    public ProcessMovement(InterfaceGenericParser parseCommand, Robot robot) {
        this.parseCommand = parseCommand;
        this.robot = robot;
    }

    public boolean processCommand(String command){
        boolean found = false;
        String matcherMovement = this.parseCommand.parseCommand(command, patternMovement);
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

}
