package smarthome.controller;

import java.util.List;
import smarthome.ddd.IAssembler;
import smarthome.domain.sensor_type.SensorType;
import smarthome.domain.service.ISensorTypeService;
import smarthome.domain.service.IUnitService;
import smarthome.domain.unit.Unit;
import smarthome.domain.value_object.TypeDescription;
import smarthome.domain.value_object.UnitID;
import smarthome.utils.Validator;
import smarthome.utils.dto.SensorTypeDTO;
import smarthome.utils.dto.SensorTypeDataDTO;
import smarthome.utils.dto.UnitDTO;

public class AddSensorTypeController {

  private final ISensorTypeService sensorTypeService;
  private final IUnitService unitService;
  private final IAssembler<SensorType, SensorTypeDTO> sensorTypeAssembler;
  private final IAssembler<Unit, UnitDTO> unitAssembler;

  /**
   * Constructs an AddSensorTypeController with the specified services and assemblers.
   *
   * @param sensorTypeService   The service for managing sensor types.
   * @param sensorTypeAssembler The assembler for converting sensor types to DTOs.
   * @param unitService         The service for managing units.
   * @param unitAssembler       The assembler for converting units to DTOs.
   */
  public AddSensorTypeController(ISensorTypeService sensorTypeService,
      IAssembler<SensorType, SensorTypeDTO> sensorTypeAssembler,
      IUnitService unitService, IAssembler<Unit, UnitDTO> unitAssembler) {
    Validator.validateNotNull(sensorTypeService, "Sensor type service");
    Validator.validateNotNull(sensorTypeAssembler, "Sensor type assembler");
    Validator.validateNotNull(unitService, "Unit service");
    Validator.validateNotNull(unitAssembler, "Unit assembler");

    this.sensorTypeService = sensorTypeService;
    this.sensorTypeAssembler = sensorTypeAssembler;
    this.unitService = unitService;
    this.unitAssembler = unitAssembler;

  }

  /**
   * Get all supported units.
   *
   * @return The list of supported units.
   */
  public List<UnitDTO> getSupportedUnits() {
    List<Unit> units = unitService.getAllMeasurementTypes();
    return unitAssembler.domainToDTO(units);
  }

  /**
   * Add and save a sensor type.
   *
   * @param sensorTypeDataDTO The sensor type data to add and save.
   * @return The sensor type DTO.
   */
  public SensorTypeDTO addAndSaveSensorType(SensorTypeDataDTO sensorTypeDataDTO) {
    try {
      TypeDescription typeDescription = new TypeDescription(
          sensorTypeDataDTO.sensorTypeDescription);
      UnitID unitID = new UnitID(sensorTypeDataDTO.unitID);
      SensorType sensorType = sensorTypeService.createSensorType(typeDescription, unitID);
      SensorType savedSensorType = sensorTypeService.addSensorType(sensorType);
      return sensorTypeAssembler.domainToDTO(savedSensorType);
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid sensor type data.");
    }
  }
}
