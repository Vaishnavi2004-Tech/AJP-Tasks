import java.net.*;
import java.io.*;
import java.util.Scanner;

class Weather {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        String apiKey = "026e2baebec52c3d4d6be29ca85087b0";

        try {

            String url =
            "https://api.openweathermap.org/data/2.5/weather?q="
            + city
            + "&appid="
            + apiKey
            + "&units=metric";

            URL apiUrl = new URL(url);

            BufferedReader br = new BufferedReader(
            new InputStreamReader(apiUrl.openStream()));

            String data = "";
            String line;

            while((line = br.readLine()) != null){
                data += line;
            }

            System.out.println("\nLive Weather Report");

            String weather =
            data.split("\"main\":\"")[1].split("\"")[0];

            String temp =
            data.split("\"temp\":")[1].split(",")[0];

            String humidity =
            data.split("\"humidity\":")[1].split("}")[0];

            System.out.println("Weather     : " + weather);
            System.out.println("Temperature : " + temp + " °C");
            System.out.println("Humidity    : " + humidity + "%");

        } catch(Exception e) {
            System.out.println("Check API key or Internet connection!");
        }
    }
}