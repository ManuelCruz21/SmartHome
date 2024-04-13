package smartHome.domain.sensor.dewPointSensor;

import smartHome.domain.sensor.ISensor;
import smartHome.valueObject.*;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class DewPointSensor implements ISensor {
    private ModelPath _modelPath;
    private SensorName _sensorName;
    private SensorID _sensorID;
    private SensorTypeID _sensorTypeID;
    private DewPointValue _dewPointValue;
    private DeviceID _deviceID;

    /**
     * Constructor of the class.
     *
     * @param deviceID     The device ID.
     * @param modelPath    The model path.
     * @param sensorName   The sensor name.
     * @param sensorTypeID The sensor type ID.
     */
    public DewPointSensor(DeviceID deviceID, ModelPath modelPath, SensorTypeID sensorTypeID, SensorName sensorName) {
        validateModelPath(modelPath);
        validateSensorName(sensorName);
        validateSensorTypeID(sensorTypeID);
        validateDeviceID(deviceID);
        generateDewPointID();
    }

    /**
     * Generates a new DewPointID.
     */
    private void generateDewPointID() {
        this._sensorID = new SensorID(UUID.randomUUID().toString());
    }

    /**
     * Validates the model path.
     *
     * @param modelPath The model path.
     */
    private void validateModelPath(ModelPath modelPath) {
        if (modelPath == null) {
            throw new IllegalArgumentException("ModelPath is required");
        } else {
            this._modelPath = modelPath;
        }
    }

    /**
     * Validates the sensor name.
     *
     * @param sensorName The sensor name.
     */
    private void validateSensorName(SensorName sensorName) {
        if (sensorName == null) {
            throw new IllegalArgumentException("SensorName is required");
        } else {
            this._sensorName = sensorName;
        }
    }

    /**
     * Validates the sensor type ID.
     *
     * @param sensorTypeID The sensor type ID.
     */
    private void validateSensorTypeID(SensorTypeID sensorTypeID) {
        if (sensorTypeID == null) {
            throw new IllegalArgumentException("SensorTypeID is required");

        } else if (!Objects.equals(sensorTypeID.getID(), "DewPoint")) {
            throw new IllegalArgumentException("SensorTypeID must be 'DewPoint'");

        } else {
            this._sensorTypeID = sensorTypeID;
        }
    }

    /**
     * Validates the device ID.
     *
     * @param deviceID The device ID.
     */
    private void validateDeviceID(DeviceID deviceID) {
        if (deviceID == null) {
            throw new IllegalArgumentException("DeviceID is required");
        } else {
            this._deviceID = deviceID;
        }
    }


    /**
     * Gets the sensor ID.
     *
     * @return The sensor ID.
     */
    @Override
    public SensorID getID() {
        return this._sensorID;
    }

    /**
     * Gets the sensor name.
     *
     * @return The sensor name.
     */
    @Override
    public SensorName getName() {
        return this._sensorName;
    }

    /**
     * Gets the model path.
     *
     * @return The model path.
     */
    @Override
    public ModelPath getModelPath() {
        return this._modelPath;
    }

    /**
     * Gets the sensor type ID.
     *
     * @return The sensor type ID.
     */
    @Override
    public SensorTypeID getSensorTypeID() {
        return this._sensorTypeID;
    }

    /**
     * Method to get the value object of the sensor.
     *
     * @return the value.
     */
    @Override
    public DewPointValue getValue() {
        Random rand = new Random();
        int dewPointValue = rand.nextInt(141) - 70;

        this._dewPointValue = new DewPointValue(dewPointValue);

        return _dewPointValue;
    }

    /**
     * Gets the device ID.
     *
     * @return The device ID.
     */
    @Override
    public DeviceID getDeviceID() {
        return this._deviceID;
    }

    /**
     * Method to compare the sensor with another object.
     *
     * @return the result of the comparison.
     */
    @Override
    public boolean equals(Object object) {
        if (object instanceof DewPointSensor dewPointSensor) {

            return this._sensorID.equals(dewPointSensor._sensorID);
        }
        return false;
    }


    /**
     * Method to get the hash code of the sensor.
     *
     * @return the hash code.
     */
    @Override
    public int hashCode(){
        return this._sensorID.hashCode();
    }

    /**
     * Method to get the string representation of the sensor.
     *
     * @return the string representation.
     */
    @Override
    public String toString() {
        return "DewPointSensor:" +
                " modelPath=" + _modelPath +
                ", sensorName=" + _sensorName +
                ", sensorID=" + _sensorID +
                ", sensorTypeID=" + _sensorTypeID +
                ", dewPointValue=" + _dewPointValue +
                ", deviceID=" + _deviceID;
    }

}
