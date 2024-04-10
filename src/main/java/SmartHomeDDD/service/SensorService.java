package SmartHomeDDD.service;

import SmartHomeDDD.ddd.Repository;
import SmartHomeDDD.domain.Device.Device;
import SmartHomeDDD.domain.Device.IDeviceRepo;
import SmartHomeDDD.domain.Sensor.ISensor;
import SmartHomeDDD.domain.Sensor.ISensorFactory;
import SmartHomeDDD.valueObject.*;

import java.util.Optional;

public class SensorService {

  private Repository<SensorID, ISensor> _sensorRepository;
  private ISensorFactory _sensorFactory;
  private IDeviceRepo _deviceRepository;

  /**
   * Constructor for SensorService.
   *
   * @param sensorRepository is the repository for sensors.
   * @param sensorFactory is the factory for sensors.
   * @param deviceRepository is the repository for devices.
   */
  public SensorService(
      Repository<SensorID, ISensor> sensorRepository,
      ISensorFactory sensorFactory,
      IDeviceRepo deviceRepository) {
    validateSensorRepository(sensorRepository);
    validateSensorFactory(sensorFactory);
    validateDeviceRepository(deviceRepository);
  }

  /**
   * Validates the SensorRepository.
   *
   * @param sensorRepository The SensorRepository to validate.
   */
  private void validateSensorRepository(Repository<SensorID, ISensor> sensorRepository) {
    if (sensorRepository == null) {
      throw new IllegalArgumentException("Please enter a valid sensor repository.");
    } else {
      this._sensorRepository = sensorRepository;
    }
  }

  /**
   * Validates the SensorFactory.
   *
   * @param sensorFactory The SensorFactory to validate.
   */
  private void validateSensorFactory(ISensorFactory sensorFactory) {
    if (sensorFactory == null) {
      throw new IllegalArgumentException("Please enter a valid sensor factory.");
    } else {
      this._sensorFactory = sensorFactory;
    }
  }

  /**
   * Validates the DeviceRepository.
   *
   * @param deviceRepository The DeviceRepository to validate.
   */
  private void validateDeviceRepository(IDeviceRepo deviceRepository) {
    if (deviceRepository == null) {
      throw new IllegalArgumentException("Please enter a valid device repository.");
    } else {
      this._deviceRepository = deviceRepository;
    }
  }

  /**
   * Adds a sensor to the repository and saves it.
   *
   * @param parameters The parameters required to create a sensor object. The first parameter should
   *     be of type DeviceID. The rest of the parameters should be the required parameters to create
   *     a sensor object.
   * @return The created and saved Sensor object.
   */
  //    public ISensor addSensor(DeviceID deviceID, ModelPath modelPath, SensorTypeID sensorTypeID,
  // SensorName sensorName) {
  //        Optional<Device> deviceOptional = _deviceRepository.ofIdentity(deviceID);
  //        if (deviceOptional.isEmpty()) {
  //            throw new IllegalArgumentException("Device with ID " + deviceID + " not found.");
  //        }
  //
  //        ISensor sensor = _sensorFactory.create(deviceID, modelPath, sensorTypeID, sensorName);
  //        _sensorRepository.save(sensor);
  //        return sensor;
  //    }

  public ISensor addSensor(Object... parameters) {
    DeviceID deviceID = (DeviceID) parameters[0];

    Optional<Device> deviceOptional = _deviceRepository.ofIdentity(deviceID);
    if (deviceOptional.isEmpty()) {
      throw new IllegalArgumentException("Device with ID " + deviceID + " not found.");
    }

    ISensor sensor = _sensorFactory.create(parameters);
    _sensorRepository.save(sensor);
    return sensor;
  }
}
