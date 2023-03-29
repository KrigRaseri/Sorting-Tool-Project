import com.sun.jdi.LongType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            /*
            String dataType = "long";
            String sortingType = "natural";

            if (argsList.contains("-dataType")) {
                int i = argsList.indexOf("-dataType");
                dataType = argsList.get(i + 1);
            }

            if (argsList.contains("-sortingType")) {
                int i = argsList.indexOf("-sortingType");
                sortingType = argsList.get(i + 1);
            } */



            List<String> argsList = new ArrayList<>(Arrays.asList(args));

            if (argsList.contains("long")) {
                if (argsList.contains("byCount")) {
                    LongDataType.sortByCount(sc);
                } else {
                    LongDataType.sortNaturally(sc);
                }
            }

            if (argsList.contains("word")) {
                if (argsList.contains("byCount")) {
                    WordDataType.sortByCount(sc);
                } else {
                    WordDataType.sortNaturally(sc);
                }
            }

            if (argsList.contains("line")) {
                if (argsList.contains("byCount")) {
                    LineDataType.sortByCount(sc);
                } else {
                    LineDataType.sortNaturally(sc);
                }
            }
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