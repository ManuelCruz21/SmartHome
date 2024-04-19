package smart_home.persistence.mem;


import smart_home.ddd.IRepository;
import smart_home.domain.sensor_type.SensorType;
import smart_home.utils.Validator;
import smart_home.value_object.SensorTypeID;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class SensorTypeRepository implements IRepository<SensorTypeID, SensorType> {

    private final Map<SensorTypeID, SensorType> _sensorTypeData = new LinkedHashMap<>();


    /**
     * Save a SensorType. If the SensorType is null, throw an IllegalArgumentException.
     *
     * @param sensorType the SensorType to save.
     * @return the saved SensorType.
     */
    @Override
    public SensorType save(SensorType sensorType) {
        Validator.validateNotNull(sensorType, "SensorType");

        if (containsOfIdentity(sensorType.getID())) {
            throw new IllegalArgumentException("SensorType already exists.");
        } else {
            _sensorTypeData.put(sensorType.getID(), sensorType);
        }
        return sensorType;
    }

    /**
     * Find all SensorTypes.
     *
     * @return a list of all SensorTypes.
     */
    @Override
    public List<SensorType> findAll() {
        List<SensorType> allSensorTypes = _sensorTypeData.values().stream().toList();
        return allSensorTypes;
    }

    /**
     * Find a SensorType by its identity.
     *
     * @param sensorTypeID the identity of the SensorType to find.
     * @return the SensorType if found, otherwise Optional.empty().
     */
    @Override
    public Optional<SensorType> ofIdentity(SensorTypeID sensorTypeID) {
        Optional<SensorType> sensorType = Optional.ofNullable(_sensorTypeData.get(sensorTypeID));
        return sensorType;
    }

    /**
     * Check if a SensorType exists by its identity.
     *
     * @param sensorTypeID the identity of the SensorType to check.
     * @return true if the SensorType exists, otherwise false.
     */
    @Override
    public boolean containsOfIdentity(SensorTypeID sensorTypeID) {
        return _sensorTypeData.containsKey(sensorTypeID);
    }

}
