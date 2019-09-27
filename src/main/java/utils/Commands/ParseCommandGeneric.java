package utils.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.interfaces.InterfaceGenericParser;

public class ParseCommandGeneric implements InterfaceGenericParser {

    public ParseCommandGeneric(){

    }

    public String parseCommand(String command, String pattern){

        Pattern patternMatch = Pattern.compile(pattern);
        Matcher matcher = patternMatch.matcher(command);
        if (matcher.find())
            return matcher.group(0);
        else
            return "";
    }

}
