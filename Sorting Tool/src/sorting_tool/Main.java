package sorting_tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            List<String> argsList = new ArrayList<>(Arrays.asList(args));
            String[] command = Util.getCommand(argsList);
            String dataType = command[0];
            String sortingType = command[1];

            switch (dataType) {
                case "long":
                    new SortContext(sc, new LongDataType(), sortingType);
                    break;

                case "word":
                    new SortContext(sc, new WordDataType(), sortingType);
                    break;

                case "line":
                    new SortContext(sc, new LineDataType(), sortingType);
                    break;
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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