package de.zettsystems.weather;

public class WeatherService {
    private TemperatureService temperatureService;
    private WindService windService;
    private RainfallService rainfallService;

    public WeatherService(TemperatureService temperatureService, WindService windService, RainfallService rainfallService) {
        this.temperatureService = temperatureService;
        this.windService = windService;
        this.rainfallService = rainfallService;
    }

    public Status measureWeather() {
        Status temperature = temperatureService.measureTemperature();
        Status wind = windService.measureWind();
        Status rain = rainfallService.measureRain();

        if (Status.GOOD == temperature && Status.GOOD == wind && Status.GOOD == rain) {
            return Status.GOOD;
        } else if (Status.BAD == temperature || Status.BAD == wind || Status.BAD == rain) {
            return Status.BAD;
        } else {
            return Status.OK;
        }

    }
}
