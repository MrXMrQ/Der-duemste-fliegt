import java.text.DecimalFormat;
import java.util.*;

public class Main {
    private static final Properties properties = PropertySaver.loadProperties();

    public static void main(String[] args) {
        String[] player = {"Yannick", "Pascal", "Malte", "Lucy"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String loadQuestions = properties.getProperty("questions").replace("[", "").replace("]", "");
        String[] questions = loadQuestions.split(", ");

        String loadIndex = properties.getProperty("index").replace("[", "").replace("]", "");
        String[] indexString = loadIndex.split(", ");
        ArrayList<Integer> index = new ArrayList<>();

        for (String s : indexString) {
            index.add(Integer.valueOf(s));
        }

        System.out.println(index + "  = " + calculatePercentage((double) index.size() - 1, questions.length));

        int randomNum = randomQuestion(random, questions, index);
        int count = 0;

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            properties.setProperty("index", index.toString());
            PropertySaver.saveProperties(properties);
        }));

        while (true) {
            System.out.println(player[count] + "! " + questions[randomNum]);
            String input = scanner.nextLine();

            count++;
            if (count == player.length) {
                count = 0;
            }

            if (input.equals("cancel")) {
                properties.setProperty("index", index.toString());
                PropertySaver.saveProperties(properties);
                return;
            }
            randomNum = randomQuestion(random, questions, index);
        }
    }

    public static int randomQuestion(Random random, String[] questions, ArrayList<Integer> index) {
        int randomNum = random.nextInt(questions.length);
        if (questions.length + 1 == index.size()) {
            System.out.println("No more questions!");
            properties.setProperty("index", index.toString());
            PropertySaver.saveProperties(properties);
            System.exit(0);
        } else {
            for (int i = 0; i < index.size(); i++) {
                if (randomNum == index.get(i)) {
                    i = 0;
                    randomNum += 1;

                    if (randomNum >= questions.length) {
                        randomNum = 0;
                    }
                }
            }
        }
        index.add(randomNum);
        return randomNum;
    }

    private static String calculatePercentage(double partValue, double totalValue) {
        double percentage = partValue / totalValue;
        DecimalFormat df = new DecimalFormat("Total question use: #.##%");
        return df.format(percentage);
    }
}