package org.quemepongo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.quemepongo.api.AccuWeatherAPI;

public class ServicioAccuWeather implements ServicioClima {
  private AccuWeatherAPI apiClima;
  private Integer temperatura;
  private LocalDateTime ultimaActualizacion;
  private Long periodoDeValidezEnHoras;

  public ServicioAccuWeather(Long periodoDeValidezEnHoras, Integer temperatura, AccuWeatherAPI apiClima, LocalDateTime ultimaActualizacion) {
    this.periodoDeValidezEnHoras = periodoDeValidezEnHoras;
    this.temperatura = temperatura;
    this.apiClima = apiClima;
    this.ultimaActualizacion = ultimaActualizacion;
  }

  @Override
  public Integer temperaturaActual() {
    if (!elClimaExpiro()) {
      return temperatura;
    }
    List<Map<String, Object>> condicionesClimaticasList = apiClima.getWeather("Buenos Aires, Argentina");
    Map<String, Object> condicionesClimaticas = condicionesClimaticasList.get(0);
    Map<String, Object> temperatura = (HashMap<String, Object>) condicionesClimaticas.get("Temperature");
    ultimaActualizacion = LocalDateTime.now();
    return (Integer)temperatura.get("Value");
  }

  public boolean elClimaExpiro() {
    return Duration.between(ultimaActualizacion, LocalDateTime.now()).toHours() > periodoDeValidezEnHoras;
  }
}
