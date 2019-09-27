package utils.Commands;

import utils.Robot.Position;
import utils.Robot.Robot;
import utils.interfaces.InteractionCommand;
import utils.interfaces.InterfaceGenericParser;

public class ParseCommands {

    private Robot robot;
    private InterfaceGenericParser parseCommand;
    private InteractionCommand processGrid;
    private InteractionCommand processMovement;
    private InteractionCommand processPosition;

    public ParseCommands(Robot robot){
        this.robot = robot;
        this.parseCommand = new ParseCommandGeneric();
        this.processGrid = new ProcessGrid(this.parseCommand, this.robot);
        this.processMovement = new ProcessMovement(this.parseCommand,this.robot);
        this.processPosition = new ProcessPosition(this.parseCommand,this.robot);
    }
    public ParseCommands(){
        this.parseCommand = new ParseCommandGeneric();
    }

    public Robot getRobot() {
        return robot;
    }

    public InteractionCommand getProcessGrid(){
        return this.processGrid;
    }

    public InteractionCommand getProcessMovement(){
        return this.processMovement;
    }

    public InteractionCommand getProcessPosition(){ return this.processPosition; }

    public void processScent(Position p){
        if (p.getX()>0&&p.getY()>0)
            robot.setPositionScent(p.getX(),p.getY());
    }
}
