package SmartHome.sensors;

import SmartHome.domain.CatalogueSensor;
import SmartHome.domain.SensorType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WindSensorTest {

    /**
     * Testing WindSensor constructor with valid description
     * @throws InstantiationException
     */
    @Test
    void shouldInstantiateValidObject_GivenValidDescription() throws  InstantiationException{
        //Arrange
        String strDescription = "WindSpeedAndDirection";
        CatalogueSensor catalogueDouble = mock(CatalogueSensor.class);
        SensorType sensorTypeDouble = mock(SensorType.class);
        when(catalogueDouble.getSensorType(strDescription)).thenReturn(sensorTypeDouble);

        //Act
        new WindSensor(catalogueDouble);
    }

    /**
     * Testing WindSensor constructor with null argument
     * @throws InstantiationException
     */
    @Test
    void shouldThrowError_GivenInvalidDescription() {
        //Arrange
        CatalogueSensor mockCatalogue = mock(CatalogueSensor.class);
        when(mockCatalogue.getSensorType("WindSpeedAndDirection")).thenReturn(null);
        //Act + Assert
        assertThrows(InstantiationException.class, () -> {
            new WindSensor(mockCatalogue);
        });
    }

    /**
     * Testing getSensorType method with correct sensor type
     * @throws InstantiationException
     */
    @Test
    void shouldReturnValidSensorType_GivenValidDescription() throws InstantiationException {
        //Arrange
        String strDescription = "WindSpeedAndDirection";
        CatalogueSensor catalogueDouble = mock(CatalogueSensor.class);
        SensorType sensorTypeDouble = mock(SensorType.class);
        when(catalogueDouble.getSensorType(strDescription)).thenReturn(sensorTypeDouble);
        WindSensor windSensor = new WindSensor(catalogueDouble);

        //Act
        SensorType result = windSensor.getSensorType();

        //Assert
        assertEquals(sensorTypeDouble, result);
    }

    /**
     * Testing getValue method
     * @throws InstantiationException
     */
    @Test
    void shouldReturnValidValue() throws InstantiationException {
        //Arrange
        String strDescription = "WindSpeedAndDirection";
        CatalogueSensor catalogueDouble = mock(CatalogueSensor.class);
        SensorType sensorTypeDouble = mock(SensorType.class);
        when(catalogueDouble.getSensorType(strDescription)).thenReturn(sensorTypeDouble);
        WindSensor windSensor = new WindSensor(catalogueDouble);

        //Act
        WindSensorValue value = (WindSensorValue) windSensor.getValue();

        //Assert
        assertNotNull(value);
        assertTrue(value instanceof WindSensorValue); //TODO: check this line
    }
    /**
     * Testing getValue method speed is within bounds
     * @throws InstantiationException
     */

    @Test
    void shouldReturnValidWindSpeed() throws InstantiationException {
        //Arrange
        String strDescription = "WindSpeedAndDirection";
        CatalogueSensor catalogueDouble = mock(CatalogueSensor.class);
        SensorType sensorTypeDouble = mock(SensorType.class);
        when(catalogueDouble.getSensorType(strDescription)).thenReturn(sensorTypeDouble);
        WindSensor windSensor = new WindSensor(catalogueDouble);

        //Act
        WindSensorValue value = (WindSensorValue) windSensor.getValue();

        //Assert
        assertTrue(value._nValue >= 0 && value._nValue <= 408);
    }

    /**
     * Testing getValue method direction is within bounds
     */
    @Test
    void shouldReturnValidDirection() throws InstantiationException {
        //Arrange
        String strDescription = "WindSpeedAndDirection";
        CatalogueSensor catalogueDouble = mock(CatalogueSensor.class);
        SensorType sensorTypeDouble = mock(SensorType.class);
        when(catalogueDouble.getSensorType(strDescription)).thenReturn(sensorTypeDouble);
        WindSensor windSensor = new WindSensor(catalogueDouble);
        String[] directions = {"N", "NE", "E", "SE", "S", "SW", "W", "NW"};

        //Act
        WindSensorValue value = (WindSensorValue) windSensor.getValue();

        //Assert
        assertTrue(Arrays.asList(directions).contains(value._dValue));
    }
}