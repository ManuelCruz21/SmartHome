package smarthome.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import smarthome.ddd.IAssembler;
import smarthome.domain.sensor.ISensor;
import smarthome.utils.Validator;
import smarthome.utils.dto.SensorDTO;

@Component
public class SensorAssembler implements IAssembler<ISensor, SensorDTO> {


  /**
   * Converts a domain entity to a DTO.
   *
   * @param sensor is the domain entity to be converted.
   * @return the DTO that was created.
   */
  @Override
  public SensorDTO domainToDTO(ISensor sensor) {
    Validator.validateNotNull(sensor, "Sensor");

    String deviceID = sensor.getDeviceID().toString();
    String modelPath = sensor.getModelPath().toString();
    String sensorTypeID = sensor.getSensorTypeID().toString();
    String sensorID = sensor.getID().toString();
    String sensorName = sensor.getName().toString();

    SensorDTO sensorDTO = new SensorDTO(deviceID, modelPath, sensorTypeID, sensorID, sensorName);

    return sensorDTO;
  }

  /**
   * Converts a list of domain entities to a list of DTOs.
   *
   * @param sensors is the list of domain entities to be converted.
   * @return the list of DTOs that was created.
   */
  @Override
  public List<SensorDTO> domainToDTO(List<ISensor> sensors) {
    if (sensors == null || sensors.isEmpty()) {
      throw new IllegalArgumentException("The list of sensors cannot be null or empty");
    }

    List<SensorDTO> sensorDTOList = sensors.stream().map(this::domainToDTO).toList();

    return sensorDTOList;
  }
}
