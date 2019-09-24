package utils.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseCommand {
    private  final String patternCoordinates = "\\d\\s\\d";
    private  final String patternPosition = "\\d\\s\\d\\s[N'|'S'|'E'|'W']";
    private  final String patternOrientation = "['L'|'R'|'F']*";

    private Matcher parseCommand(String command, String pattern){

        Pattern patternMatch = Pattern.compile(pattern);
        Matcher matcher = patternMatch.matcher(command);

        return matcher;
    }
}
