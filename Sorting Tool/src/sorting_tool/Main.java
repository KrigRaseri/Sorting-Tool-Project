package sorting_tool;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> argsList = new ArrayList<>(Arrays.asList(args));
        String[] command = Util.getCommand(argsList);
        String dataType = command[0];
        String sortingType = command[1];
        Scanner sc = FileHandler.getInputFile(argsList);
        File outputFile = FileHandler.getOutputFile(argsList);

        switch (dataType) {
            case "long":
                new SortContext(sc, new LongDataType(), sortingType, outputFile);
                break;

            case "word":
                new SortContext(sc, new WordDataType(), sortingType, outputFile);
                break;

            case "line":
                new SortContext(sc, new LineDataType(), sortingType, outputFile);
                break;
        }
        sc.close();
    }
}


/*
* ⠀⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢸⡏⠁⠈⠉⠙⠓⠶⢦⣤⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠈⢿⡀⢠⣄⠀⠀⠀⠀⠀⠈⠉⠛⠶⢦⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠻⣮⡙⠁⠀⠀⠺⣷⡄⠀⠀⠀⠀⠈⠉⠛⠶⣤⣄⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠈⠙⠲⣤⣀⠀⠀⠀⠀⠀⣰⡇⣤⠀⠀⠀⠀⠉⠛⠶⣤⣄⡀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠹⣎⡉⠀⠀⠀⢀⡿⢿⡟⠀⢀⣀⣤⣀⡀⠀⠀⠉⠛⠷⣦⣄
⠀⠀⠀⠀⠀⠀⠀⠀⢽⣿⡶⠶⠎⠁⠺⢡⠞⠉⠀⠀⠀⠙⡖⡆⠀⠀⠀⠀⠉
⠀⠀⠀⠀⠀⠀⠀⠀⠚⠻⣟⠛⣂⡤⢤⣟⠀⠀⢀⣀⣀⡼⠷⡧⢾⣏⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡞⠁⠀⠀⠈⣦⡠⠼⠿⠋⢀⡼⠃⣼⣿⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠀⢀⣤⣀⣠⠟⢲⠿⠗⠚⠉⠀⣰⣿⡟⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣗⣒⡛⠋⠁⣠⠞⠀⠀⠀⣠⣾⣿⡿⠁⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢨⣿⣫⠉⣁⣠⣤⣶⣿⣿⠿⠋⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠾⠋⠸⡏⠙⠛⠛⠛⠛⠩⠤⠴⠞⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⣠⠾⠁⠀⠀⠀⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
* */