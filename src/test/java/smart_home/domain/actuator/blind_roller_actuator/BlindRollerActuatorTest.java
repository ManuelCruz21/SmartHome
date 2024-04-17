package smart_home.domain.actuator.blind_roller_actuator;

import org.junit.jupiter.api.Test;
import smart_home.domain.actuator.blind_roller_actuator.BlindRollerActuator;
import smart_home.domain.actuator.blind_roller_actuator.BlindRollerValue;
import smart_home.value_object.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class BlindRollerActuatorTest {
    /**
     * Test the first constructor, of class BlindRollerActuator.
     */
    @Test
    void shouldCreateBlindRollerActuator_WhenConstructorArgumentsAreValid() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        //Act
        BlindRollerActuator blindRollerActuator  = new BlindRollerActuator(deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);

        //Assert
        assertNotNull(blindRollerActuator );
    }

    /**
     * Test the second constructor, of class BlindRollerActuator.
     */
    @Test
    void shouldCreateBlindRollerActuator_WhenSecondConstructorArgumentsAreValid() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);
        ActuatorID actuatorIDDouble = mock(ActuatorID.class);

        //Act
        BlindRollerActuator blindRollerActuator = new BlindRollerActuator(actuatorIDDouble, deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);

        //Assert
        assertNotNull(blindRollerActuator);
    }

    /**
     * Test for invalid deviceID
     */
    @Test
    void shouldThrowIllegalArgumentException_WhenDeviceIDIsNull() {
        //Arrange
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        String expectedMessage = "DeviceID is required";

        //Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BlindRollerActuator(null, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);
        });

        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test for invalid actuatorTypeID
     */
    @Test
    void shouldThrowIllegalArgumentException_WhenActuatorTypeIDIsNull() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);

        String expectedMessage = "ActuatorTypeID is required";

        //Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BlindRollerActuator(deviceIDDouble, modelPathDouble, null, actuatorNameDouble);
        });

        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test for invalid actuatorName
     */
    @Test
    void shouldThrowIllegalArgumentException_WhenActuatorNameIsNull() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        String expectedMessage = "ActuatorName is required";

        //Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BlindRollerActuator(deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, null);
        });

        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test for invalid modelPath
     */
    @Test
    void shouldThrowIllegalArgumentException_WhenModelPathIsNull() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        String expectedMessage = "ModelPath is required";

        //Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BlindRollerActuator(deviceIDDouble, null, actuatorTypeIDDouble, actuatorNameDouble);
        });

        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test for invalid actuatorID
     */
    @Test
    void shouldThrowIllegalArgumentException_WhenActuatorIDIsNull() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        String expectedMessage = "ActuatorID is required";

        //Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new BlindRollerActuator(null, deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);
        });
        assertEquals(expectedMessage, exception.getMessage());
    }

    /**
     * Test of getID method, of class BlindRollerActuator.
     */
    @Test
    void shouldReturnActuatorID_WhenGetIDIsCalled() {
        // Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        BlindRollerActuator blindRollerActuator = new BlindRollerActuator(deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);

        // Act
        ActuatorID result = blindRollerActuator.getID();

        // Assert
        assertNotNull(result);
    }


    /**
     * Test of getName method, of class BlindRollerActuator.
     */
    @Test
    void shouldReturnActuatorName_WhenGetNameIsCalled() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        BlindRollerActuator blindRollerActuator = new BlindRollerActuator(deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);

        //Act
        ActuatorName result = blindRollerActuator.getName();

        //Assert
        assertNotNull(result);
    }

    /**
     * Test of getModelPath method, of class BlindRollerActuator.
     */
    @Test
    void shouldReturnModelPath_WhenGetModelPathIsCalled() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        BlindRollerActuator blindRollerActuator = new BlindRollerActuator(deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);

        //Act
        ModelPath result = blindRollerActuator.getModelPath();

        //Assert
        assertNotNull(result);

    }

    /**
     * Test of getActuatorTypeID method, of class BlindRollerActuator.
     */
    @Test
    void shouldReturnActuatorTypeID_WhenGetActuatorTypeIDIsCalled() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        BlindRollerActuator blindRollerActuator = new BlindRollerActuator(deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);

        //Act
        ActuatorTypeID result = blindRollerActuator.getActuatorTypeID();

        //Assert
        assertNotNull(result);
    }
    /**
     * Test of getDeviceID method, of class BlindRoller
     */
    @Test
    void shouldReturnDeviceID_WhenGetDeviceIDIsCalled() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        BlindRollerActuator blindRollerActuator = new BlindRollerActuator(deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);

        //Act
        DeviceID result = blindRollerActuator.getDeviceID();

        //Assert
        assertNotNull(result);
    }

    /**
     * Test of setValue, of class BlindRollerActuator.
     */
    @Test
    void shouldReturnActuatorValue_WhenSetValueIsCalled() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);
        BlindRollerValue blindRollerValue = mock(BlindRollerValue.class);

        BlindRollerActuator blindRollerActuator = new BlindRollerActuator(deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);

        //Act
        BlindRollerValue result = blindRollerActuator.setValue(blindRollerValue);

        //Assert
        assertNotNull(result);
    }

    /**
     * Test of setValue when is null, of class BlindRollerActuator.
     */
    @Test
    void shouldReturnNull_WhenSetValueIsNull() {
        //Arrange
        DeviceID deviceIDDouble = mock(DeviceID.class);
        ModelPath modelPathDouble = mock(ModelPath.class);
        ActuatorName actuatorNameDouble = mock(ActuatorName.class);
        ActuatorTypeID actuatorTypeIDDouble = mock(ActuatorTypeID.class);

        BlindRollerActuator blindRollerActuator = new BlindRollerActuator(deviceIDDouble, modelPathDouble, actuatorTypeIDDouble, actuatorNameDouble);

        //Act
        BlindRollerValue result = blindRollerActuator.setValue(null);

        //Assert
        assertNull(result);
    }
}
