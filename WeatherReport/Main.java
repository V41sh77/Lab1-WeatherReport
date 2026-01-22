import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String continueChoice;

        // STEP 7: Loop for multiple reports
        do {

            // STEP 1: Declare variables
            String weatherCondition;
            String precipitationChance;
            String windSpeed;

            double dailyHighTemperature;
            double dailyLowTemperature;
            int uvIndex;

            // STEP 2: Get input from user
            System.out.print("Enter today's weather condition: ");
            weatherCondition = input.nextLine();

            System.out.print("Enter possibility of precipitation (%): ");
            precipitationChance = input.nextLine();

            System.out.print("Enter wind speed (km/h): ");
            windSpeed = input.nextLine();

            // Validate temperatures
            do {
                System.out.print("Enter daily HIGH temperature: ");
                dailyHighTemperature = input.nextDouble();

                System.out.print("Enter daily LOW temperature: ");
                dailyLowTemperature = input.nextDouble();

                if (dailyHighTemperature < dailyLowTemperature) {
                    System.out.println("❌ High temperature must be greater than or equal to low temperature.");
                }
            } while (dailyHighTemperature < dailyLowTemperature);

            // Validate UV index
            do {
                System.out.print("Enter UV index (0–11): ");
                uvIndex = input.nextInt();

                if (uvIndex < 0 || uvIndex > 11) {
                    System.out.println("❌ UV index must be between 0 and 11.");
                }
            } while (uvIndex < 0 || uvIndex > 11);

            input.nextLine(); // clear buffer

            // STEP 4: Conditional statements (tips)
            String tips = "";

            if (uvIndex >= 6) {
                tips += "Use sunscreen. ";
            }

            if (Integer.parseInt(precipitationChance) >= 50) {
                tips += "Carry an umbrella. ";
            }

            if (Integer.parseInt(windSpeed) > 40) {
                tips += "Windy conditions. ";
            }

            // STEP 5: Full report
            String fullReport =
                    "\n🌤 WEATHER REPORT 🌤\n" +
                    "Condition: " + weatherCondition + "\n" +
                    "Precipitation: " + precipitationChance + "%\n" +
                    "Wind Speed: " + windSpeed + " km/h\n" +
                    "High Temp: " + dailyHighTemperature + "°C\n" +
                    "Low Temp: " + dailyLowTemperature + "°C\n" +
                    "UV Index: " + uvIndex + "\n" +
                    "Tips: " + (tips.isEmpty() ? "No special warnings." : tips);

            // STEP 6: Print report
            System.out.println(fullReport);

            // Ask to continue
            System.out.print("\nDo you want to enter another report? (yes/no): ");
            continueChoice = input.nextLine();

        } while (continueChoice.equalsIgnoreCase("yes"));

        input.close();
        System.out.println("✅ Program ended.");
    }
}
