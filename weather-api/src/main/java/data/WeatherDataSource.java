package data;

import java.util.Set;

public interface WeatherDataSource {
    Set<String> getCities();
    String getByCity(String city);
}
