package utils.Commands;

import utils.File.GetFileStream;
import utils.Robot.Position;
import utils.Robot.Robot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseInstruction {

    private Position positionGrid;
    private ParseCommand parseCommandRobot;
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

        GetFileStream getFileStream = new GetFileStream(System.getProperty("user.dir")+this.file);
        try {
            int instruction=0;
            lineGrid = getFileStream.getStream().readLine();

            while (((line = getFileStream.getStream().readLine())!=null)) {

                if (line.length() != 0) {
                    if (instruction == 1){//command movement
                        parseCommandRobot.processMovement(line);
                        if (parseCommandRobot.getRobot().isOutOfGrid())
                            positionScent = new Position(parseCommandRobot.getRobot().getPositionScent().getX(),parseCommandRobot.getRobot().getPositionScent().getY());
                        instruction=0;
                        this.addTextToOutput();


                    }
                    else if (instruction == 0) {//position
                        Robot robot = new Robot();
                        parseCommandRobot = new ParseCommand(robot);
                        parseCommandRobot.processGrid(lineGrid);
                        parseCommandRobot.processScent(positionScent);
                        parseCommandRobot.processPosition(line);
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

    public void addTextToOutput(){
        String isLost = parseCommandRobot.getRobot().isOutOfGrid() == true?"LOST":"";
        String output = parseCommandRobot.getRobot().getPosition()+ " " +isLost+ " "+parseCommandRobot.getRobot().getOrientation();
        this.addOutput(output);
    }

    public void printOutput(){
        for (int i=0;i<this.output.size();i++)
            System.out.println(this.output.get(i));
    }
}
