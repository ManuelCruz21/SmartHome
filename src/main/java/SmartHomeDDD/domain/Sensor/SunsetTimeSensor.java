package SmartHomeDDD.domain.Sensor;

import SmartHome.domain.Gps;
import SmartHomeDDD.ddd.ValueObject;
import SmartHomeDDD.valueObject.*;
import org.shredzone.commons.suncalc.SunTimes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;

public class SunsetTimeSensor implements Sensor{
    private SunriseSunsetTimeValue _sunriseTimeValue;
    private SensorTypeID _sensorTypeID;
    private SensorID _sensorID;

    private SensorName _sensorName;

    private DeviceID _deviceID;

    private ModelPath _modelPath;
    private Gps _gps;

    public SunsetTimeSensor(DeviceID deviceID, ModelPath modelPath, SensorTypeID sensorTypeID, SensorName sensorName, Gps gps) throws InstantiationException {
        validateDeviceID(deviceID);
        validateSensorTypeID(sensorTypeID);
        validateModelPath(modelPath);
        validateSensorName(sensorName);
        generateSensorID();
        configureGpsLocation(gps);
    }
    private void validateDeviceID(DeviceID deviceID) {
        if (deviceID == null) {
            throw new IllegalArgumentException("DeviceID cannot be null.");
        } else {
            _deviceID = deviceID;
        }
    }
    private void validateSensorTypeID(SensorTypeID sensorTypeID) {
        if (sensorTypeID == null) {
            throw new IllegalArgumentException("SensorTypeID cannot be null.");
        }
        else if (!sensorTypeID.getId().equals("SunsetTime")) {
            throw new IllegalArgumentException("SensorTypeID must be 'SunsetTime'.");}
        else {
            _sensorTypeID = sensorTypeID;
        }
    }
    private void validateModelPath(ModelPath modelPath) {
        if (modelPath == null) {
            throw new IllegalArgumentException("ModelPath cannot be null.");
        } else {
            _modelPath = modelPath;
        }
    }
    private void validateSensorName(SensorName sensorName) {
        if (sensorName == null) {
            throw new IllegalArgumentException("SensorName cannot be null");
        } else {
            _sensorName = sensorName;
        }
    }
    private void generateSensorID() {
        _sensorID = new SensorID(UUID.randomUUID().toString());
    }
    private void configureGpsLocation(Gps gps) {
        if (gps == null) {
            throw new IllegalArgumentException("GPS cannot be null.");
        } else {
            _gps = gps;
        }
    }
    private LocalTime getSunsetTime(LocalDate date) {
        SunTimes time = SunTimes.compute().on(date).at(_gps.getLatitude(), _gps.getLongitude()).execute();
        LocalTime sunrise = Objects.requireNonNull(time.getSet()).toLocalTime().truncatedTo(ChronoUnit.MINUTES);
        return sunrise;
    }

    @Override
    public SensorID getID() {
        return _sensorID;
    }

    @Override
    public SensorName getName() {
        return _sensorName;
    }

    @Override
    public ModelPath getModelPath() {
        return _modelPath;
    }

    @Override
    public DeviceID getDeviceID() {
        return _deviceID;
    }
    @Override
    public SensorTypeID getSensorTypeID() {
        return _sensorTypeID;
    }

    @Override
    public ValueObject getValue() {
        LocalTime sunrise = getSunsetTime(LocalDate.now());
        this._sunriseTimeValue = new SunriseSunsetTimeValue(sunrise);
        return this._sunriseTimeValue;
    }
    public ValueObject getValue(LocalDate date) {
        LocalTime sunrise = getSunsetTime(date);
        this._sunriseTimeValue = new SunriseSunsetTimeValue(sunrise);
        return this._sunriseTimeValue;
    }
    @Override
    public String toString() {
        return "SunsetTimeSensor{" +
                "_sunriseTimeValue=" + _sunriseTimeValue +
                ", _sensorTypeID=" + _sensorTypeID +
                ", _sensorID=" + _sensorID +
                ", _sensorName=" + _sensorName +
                ", _deviceID=" + _deviceID +
                ", _modelPath=" + _modelPath +
                ", _gps=" + _gps +
                '}';
    }


}