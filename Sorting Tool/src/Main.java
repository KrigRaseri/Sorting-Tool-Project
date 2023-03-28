import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            switch (args[1]) {
                case "long" -> LongType.longInfo(sc);
                case "line" -> LineType.lineInfo(sc);
                case "word" -> WordType.wordInfo(sc);
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