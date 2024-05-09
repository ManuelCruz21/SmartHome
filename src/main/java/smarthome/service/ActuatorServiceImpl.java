package smarthome.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import smarthome.domain.actuator.IActuator;
import smarthome.domain.actuator.IActuatorFactory;
import smarthome.domain.device.Device;
import smarthome.domain.repository.IActuatorRepository;
import smarthome.domain.repository.IDeviceRepository;
import smarthome.domain.value_object.ActuatorID;
import smarthome.domain.value_object.DeviceID;
import smarthome.utils.Validator;

@Service
public class ActuatorServiceImpl implements smarthome.domain.service.IActuatorService {

  private final IActuatorRepository actuatorRepository;
  private final IActuatorFactory actuatorFactory;
  private final IDeviceRepository deviceRepository;

  /**
   * Constructs an ActuatorService with the specified repositories and factory.
   *
   * @param actuatorRepository The repository for storing actuators.
   * @param actuatorFactory The factory for creating actuators.
   * @param deviceRepository The repository for accessing devices.
   */
  public ActuatorServiceImpl(
      IActuatorRepository actuatorRepository,
      IActuatorFactory actuatorFactory,
      IDeviceRepository deviceRepository) {

    Validator.validateNotNull(actuatorRepository, "Actuator repository");
    this.actuatorRepository = actuatorRepository;
    Validator.validateNotNull(actuatorFactory, "Actuator factory");
    this.actuatorFactory = actuatorFactory;
    Validator.validateNotNull(deviceRepository, "Device repository");
    this.deviceRepository = deviceRepository;
  }

  /**
   * Adds a new actuator to the repository and saves it.
   *
   * @param parameters The parameters needed to create the actuator.The first parameter should * be
   *     of type DeviceID. The rest of the parameters should be the required parameters to create *
   *     an actuator object.
   * @return The created and saved actuator object.
   */
  @Override
  public IActuator addActuator(Object... parameters) {
    DeviceID deviceID = (DeviceID) parameters[0];
    Optional<Device> deviceOptional = deviceRepository.ofIdentity(deviceID);
    if (deviceOptional.isEmpty()) {
      throw new IllegalArgumentException("Device with ID " + deviceID + " not found.");
    }
    if (!deviceOptional.get().getDeviceStatus().getStatus()) {
      throw new IllegalArgumentException("Device with ID " + deviceID + " is deactivated.");
    }
    IActuator actuator = actuatorFactory.create(parameters);
    actuatorRepository.save(actuator);
    return actuator;
  }

  /**
   * Retrieves an actuator by its ID.
   *
   * @param actuatorID The ID of the actuator to retrieve.
   * @return An Optional containing the retrieved actuator, or empty if not found.
   */
  @Override
  public Optional<IActuator> getActuatorByID(ActuatorID actuatorID) {
    return actuatorRepository.ofIdentity(actuatorID);
  }

  /**
   * Retrieves all actuators stored in the system.
   *
   * @return A list of all actuators.
   */
  @Override
  public List<IActuator> getAllActuators() {
    return actuatorRepository.findAll();
  }
}
