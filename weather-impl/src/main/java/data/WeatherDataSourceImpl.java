package data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeatherDataSourceImpl implements WeatherDataSource {
    private Map<String,String> cities = new HashMap<>();
    public WeatherDataSourceImpl(){
        this.cities.put("Moscow","8C");
        this.cities.put("Kaliningrad","9C");
        this.cities.put("Pyatigorsk","10C");
        this.cities.put("Saint-petersburg","11C");
        this.cities.put("Chelyabinsk","12C");
        this.cities.put( "Nizhny-novgorod","13C");
        this.cities.put("Novosibirsk","14C");
        this.cities.put("Vladivostok","15C");
        this.cities.put("Krasnoyarsk","16C");
        this.cities.put("Kazan","17C");
    }
   public  Set<String> getCities(){
      return this.cities.keySet();
    }
    public String getByCity(String city){
       return this.cities.get(city);
    }
}
