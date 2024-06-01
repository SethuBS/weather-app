# Weather Report Application

## Description
This application displays a weather report for Cape Town, using data from a JSON file. It shows the high and low temperatures for each day, calculates and displays the average high and low temperatures, displays corresponding weather condition images, and plots the temperatures on a graph.

## Features
- Display high and low temperatures for 5 days.
- Calculate and display average high and low temperatures.
- Display images corresponding to weather conditions.
- Plot high and low temperatures on a graph.

## Technologies Used
- Java Spring Boot
- HTML, CSS, JavaScript
- Highcharts (for graph plotting)

## Setup
1. Clone the repository.
2. Navigate to the project directory.
3. Make sure you have Java and Maven installed.
4. Run the application using:
    ```bash
    ./mvnw spring-boot:run
    ```
5. Open a browser and go to `http://localhost:8080`.

## Directory Structure
- `src/main/java/com/example/weatherapp/` - Java source files.
- `src/main/resources/static/` - Static resources including `index.html` and JavaScript files.
- `src/main/resources/static/images/` - Images corresponding to weather conditions.
- `src/main/resources/static/weather_results.json` - JSON file with weather data.

## Future Enhancements
- Use a live weather API to fetch data for any city.
- Display integers that do not occur between the lowest and highest temperature.

## Contact
For any questions or issues, please contact Sethu at sethuserge@gmail.com.
