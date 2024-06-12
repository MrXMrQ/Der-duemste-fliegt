import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class PropertySaver extends Properties {
    private static final String PROPERTIES_FILE = "config.properties";
    private static final String[] questions = {
            "Was ist der längste Fluss der Welt? – Der Nil",
            "Welches ist das kleinste Land der Welt? – Vatikanstadt",
            "In welchem Land befindet sich die Stadt Timbuktu? – Mali",
            "Welche Gebirgskette trennt Europa von Asien? – Der Ural",
            "Wie heißt die Hauptstadt von Australien? – Canberra",
            "Welche Wüste ist die größte der Welt? – Die Sahara",
            "In welchem Land liegt der Mount Everest? – Nepal",
            "Welcher Kontinent hat die meisten Länder? – Afrika",
            "Wie heißt der größte See der Welt? – Das Kaspische Meer",
            "Welches Land hat die längste Küstenlinie? – Kanada",
            "In welcher Stadt steht das Kolosseum? – Rom",
            "Wie viele Länder gibt es in Südamerika? – 12",
            "Welches Land ist flächenmäßig das größte in Afrika? – Algerien",
            "Welche Hauptstadt liegt am nächsten zum Äquator? – Quito",
            "Welches Land hat die meisten Nachbarländer? – China",
            "Welcher Fluss fließt durch die Stadt London? – Die Themse",
            "Welches ist das höchste Gebirge in Nordamerika? – Die Rocky Mountains",
            "Wie heißt die Hauptstadt von Kanada? – Ottawa",
            "Welcher See liegt an der Grenze zwischen Peru und Bolivien? – Der Titicacasee",
            "Wie viele Zeitzonen hat Russland? – 11",
            "Welche Stadt ist die größte Stadt in Brasilien? – São Paulo",
            "In welchem Land liegt die Stadt Kyoto? – Japan",
            "Welches Land grenzt sowohl an den Atlantischen als auch an den Indischen Ozean? – Südafrika",
            "In welchem Ozean liegt Madagaskar? – Indischer Ozean",
            "Welches Land hat die meisten Inseln? – Schweden",
            "Welcher Kontinent ist der bevölkerungsreichste? – Asien",
            "Wie heißt die Hauptstadt von Neuseeland? – Wellington",
            "Welcher Fluss fließt durch Paris? – Die Seine",
            "In welchem Land befinden sich die Pyramiden von Gizeh? – Ägypten",
            "Wie heißt die größte Insel der Welt? – Grönland",
            "Welche Stadt ist die Hauptstadt von Island? – Reykjavík",
            "In welchem Land liegt die Stadt Dubai? – Vereinigte Arabische Emirate",
            "Welche beiden Länder teilen sich die Insel Hispaniola? – Haiti und die Dominikanische Republik",
            "Welches ist das höchste Gebirge in Südamerika? – Die Anden",
            "Wie viele US-Bundesstaaten grenzen an Kanada? – 13",
            "Welche Stadt liegt auf zwei Kontinenten? – Istanbul",
            "Welches Land in Europa hat die größte Bevölkerung? – Deutschland",
            "Welcher Ozean ist der kleinste der Welt? – Der Arktische Ozean",
            "Wie heißt der größte Nationalpark der Welt? – Der Nordost-Grönland-Nationalpark",
            "Welches ist das südlichste Land der Welt? – Chile",
            "Welche Hauptstadt liegt am Ufer des Flusses Dnjepr? – Kiew",
            "In welchem Land liegt der Grand Canyon? – USA",
            "Welches Land hat die höchste Bevölkerungsdichte? – Monaco",
            "Welche Inselgruppe liegt südlich von Argentinien? – Die Falklandinseln",
            "Wie heißt der größte Wüstenstaat der Welt? – Saudi-Arabien",
            "Welches Land ist für die berühmten Fjorde bekannt? – Norwegen",
            "Welches ist das bevölkerungsreichste Land Afrikas? – Nigeria",
            "Welche Insel gehört sowohl politisch zu Europa als auch geografisch zu Asien? – Zypern",
            "Wie viele Länder liegen am Mittelmeer? – 21",
            "Welches Land ist bekannt für seine Tulpenfelder und Windmühlen? – Niederlande"
    };
    private static final String[] index = {"-1"};

    public static Properties loadProperties() {
        Properties properties = new Properties();
        File file = new File(PROPERTIES_FILE);
        if (file.exists()) {
            try (FileInputStream input = new FileInputStream(file)) {
                properties.load(input);
            } catch (IOException e) {
                // Failed to load properties, ignore
            }
        } else {
            properties.setProperty("questions", Arrays.toString(questions));
            properties.setProperty("index", Arrays.toString(index));
            saveProperties(properties);
        }
        return properties;
    }

    public static void saveProperties(Properties properties) {
        try (FileOutputStream output = new FileOutputStream(PROPERTIES_FILE)) {
            properties.store(output, null);
        } catch (IOException e) {
            // Failed to save properties, ignore
        }
    }
}