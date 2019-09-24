import utils.Commands.ParseInstruction;

public class MoveRobotFromFile {

    public static void main (String args[])
    {
        ParseInstruction parseInstruction = new ParseInstruction("\\src\\main\\resources\\inputFile.txt");
        parseInstruction.parseFile();
        parseInstruction.printOutput();
    }
}
