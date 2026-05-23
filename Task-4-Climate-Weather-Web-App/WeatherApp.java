import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;

public class WeatherApp {

    public static void main(String[] args) {

        try {

            String html =

            "<!DOCTYPE html>" +
            "<html>" +

            "<head>" +
            "<title>Weather App</title>" +

            "<style>" +

            "body{" +
            "margin:0;" +
            "font-family:Arial,sans-serif;" +
            "background:#e9eef5;" +
            "display:flex;" +
            "justify-content:center;" +
            "align-items:center;" +
            "height:100vh;" +
            "}" +

            ".container{" +
            "width:520px;" +
            "background:white;" +
            "padding:35px;" +
            "border-radius:18px;" +
            "box-shadow:0 8px 25px rgba(0,0,0,0.15);" +
            "text-align:center;" +
            "}" +

            "h1{" +
            "margin-bottom:25px;" +
            "color:#222;" +
            "}" +

            ".search-box{" +
            "display:flex;" +
            "justify-content:center;" +
            "align-items:center;" +
            "gap:10px;" +
            "position:relative;" +
            "}" +

            "#city{" +
            "width:70%;" +
            "padding:12px 40px 12px 12px;" +
            "font-size:17px;" +
            "border:1px solid #ccc;" +
            "border-radius:8px;" +
            "outline:none;" +
            "}" +

            "#clearBtn{" +
            "position:absolute;" +
            "right:115px;" +
            "font-size:22px;" +
            "color:#777;" +
            "cursor:pointer;" +
            "user-select:none;" +
            "}" +

            "#clearBtn:hover{" +
            "color:black;" +
            "}" +

            "button{" +
            "padding:12px 18px;" +
            "font-size:16px;" +
            "background:#2563eb;" +
            "color:white;" +
            "border:none;" +
            "border-radius:8px;" +
            "cursor:pointer;" +
            "}" +

            "button:hover{" +
            "background:#1d4ed8;" +
            "}" +

            "#result{" +
            "margin-top:30px;" +
            "padding:22px;" +
            "background:#f8fafc;" +
            "border-radius:12px;" +
            "font-size:20px;" +
            "line-height:2;" +
            "text-align:left;" +
            "}" +

            ".label{" +
            "font-weight:bold;" +
            "}" +

            "</style>" +
            "</head>" +

            "<body>" +

            "<div class='container'>" +

            "<h1>Weather Application</h1>" +

            "<div class='search-box'>" +

            "<input type='text' id='city' placeholder='Enter City'>" +

            "<span id='clearBtn' onclick='clearInput()'>×</span>" +

            "<button onclick='getWeather()'>Search</button>" +

            "</div>" +

            "<div id='result'></div>" +

            "</div>" +

            "<script>" +

            "function clearInput(){" +
            "document.getElementById('city').value='';" +
            "document.getElementById('result').innerHTML='';" +
            "}" +

            "async function getWeather(){" +

            "let city=document.getElementById('city').value;" +

            "let apiKey='026e2baebec52c3d4d6be29ca85087b0';" +

            "let url='https://api.openweathermap.org/data/2.5/weather?q=' + city + '&appid=' + apiKey + '&units=metric';" +

            "try{" +

            "let response=await fetch(url);" +
            "let data=await response.json();" +

            "document.getElementById('result').innerHTML=" +

            "'<span class=\"label\">Weather:</span> '+data.weather[0].main+" +

            "'<br><span class=\"label\">Temperature:</span> '+data.main.temp+' °C'+ " +

            "'<br><span class=\"label\">Humidity:</span> '+data.main.humidity+'%'+ " +

            "'<br><span class=\"label\">Feels Like:</span> '+data.main.feels_like+' °C'+ " +

            "'<br><span class=\"label\">Wind Speed:</span> '+data.wind.speed+' m/s'+ " +

            "'<br><span class=\"label\">Pressure:</span> '+data.main.pressure+' hPa';" +

            "}" +

            "catch(e){" +

            "document.getElementById('result').innerHTML=" +
            "'Unable to fetch weather data';" +

            "}" +

            "}" +

            "</script>" +

            "</body>" +
            "</html>";

            File file = new File("weather.html");

            FileWriter writer =
            new FileWriter(file);

            writer.write(html);

            writer.close();

            Desktop.getDesktop().browse(file.toURI());

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

}