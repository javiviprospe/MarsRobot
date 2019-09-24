package utils.Commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

    private static final String patternCoordinates = "\\d\\s\\d";
    private static final String patternPosition = "\\d\\s\\d\\s[N'|'S'|'E'|'W']";
    private static final String patternOrientation = "['L'|'R'|'F']*";

    public static void main(String args[]){
        testSecond();
    }

    private static void testFirst(){
        String gridSize = "5 3";
        Pattern patterGrid = Pattern.compile(patternCoordinates);
        Matcher matcherGrid = patterGrid.matcher(gridSize);
        while(matcherGrid.find()) {
            System.out.println("found: " + matcherGrid.group(0));
        }
    }

    private static void testSecond(){
        String gridSize = "2 3 N";
        Pattern patterGrid = Pattern.compile(patternPosition);
        Matcher matcherGrid = patterGrid.matcher(gridSize);
        while(matcherGrid.find()) {
            System.out.println("found: " + matcherGrid.group(0));
        }
    }

    private static void testThird(){
        String gridSize = "LRLFRRDRFFFLL";
        Pattern patterGrid = Pattern.compile(patternOrientation);
        Matcher matcherGrid = patterGrid.matcher(gridSize);
        while(matcherGrid.find()) {
            System.out.println("found: " + matcherGrid.group(0));
        }
    }

    private static void testForth(){
        String gridSize = "popopopo";
        Pattern patterGrid = Pattern.compile(patternOrientation);
        Matcher matcherGrid = patterGrid.matcher(gridSize);
        System.out.println(matcherGrid);
    }
}
