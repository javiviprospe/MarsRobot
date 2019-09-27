package utils.Commands;

import utils.File.GetFileStream;
import utils.Robot.Position;
import utils.Robot.Robot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseInstruction {

    private Position positionGrid;
    private Position positionScent;
    private String file;
    private List<String> output;

    public ParseInstruction(String file) {
        this.file = file;
        this.positionScent = new Position();
        this.output = new ArrayList<String>();
    }

    /***
     * This method loops file. First ocurrence sould be Grid Size.
     * Then rest ocurrences ara instructions as follows
     * instuction 0 = position
     * instruction 1 = movement
     */
    public void parseFile(){
        String line;
        String lineGrid;
        Robot robot;
        ParseCommands parseCommands = new ParseCommands();
        GetFileStream getFileStream = new GetFileStream(System.getProperty("user.dir")+this.file);
        try {
            int instruction=0;
            lineGrid = getFileStream.getStream().readLine();

            while (((line = getFileStream.getStream().readLine())!=null)) {

                if (line.length() != 0) {
                    if (instruction == 1){//command movement
                        parseCommands.getProcessMovement().processCommand(line);
                        if (parseCommands.getRobot().isOutOfGrid())
                            positionScent = new Position(parseCommands.getRobot().getPositionScent().getX(),parseCommands.getRobot().getPositionScent().getY());
                        instruction=0;
                        this.addTextToOutput(parseCommands);


                    }
                    else if (instruction == 0) {//position
                        robot = new Robot();
                        parseCommands = new ParseCommands(robot);
                        parseCommands.getProcessGrid().processCommand(lineGrid);
                        parseCommands.processScent(positionScent);
                        parseCommands.getProcessPosition().processCommand(line);
                        instruction++;
                    }
                }
            }

        }catch (IOException io){
            io.printStackTrace();
        }
    }


    private ParseInstruction addOutput(String output){
        this.output.add(output);
        return this;
    }

    public void addTextToOutput(ParseCommands parseCommands){
        String isLost = parseCommands.getRobot().isOutOfGrid() == true?"LOST":"";
        String output = parseCommands.getRobot().getPosition()+ " " +isLost+ " "+parseCommands.getRobot().getOrientation();
        this.addOutput(output);
    }

    public void printOutput(){
        for (int i=0;i<this.output.size();i++)
            System.out.println(this.output.get(i));
    }
}
