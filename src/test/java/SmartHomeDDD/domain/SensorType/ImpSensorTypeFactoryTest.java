package SmartHomeDDD.domain.SensorType;

import SmartHomeDDD.valueObject.SensorTypeID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import SmartHomeDDD.valueObject.TypeDescription;
import SmartHomeDDD.valueObject.UnitID;

import java.util.List;

import org.mockito.MockedConstruction;

public class ImpSensorTypeFactoryTest {

    /**
     * Test to ensure that a SensorType can be created successfully
     */
    @Test
    public void shouldCreateSensorType_whenAttributesAreValid() {
        // Arrange
        SensorTypeID sensorTypeIdDouble = mock(SensorTypeID.class);
        TypeDescription typeDescriptionDouble = mock(TypeDescription.class);
        UnitID unitDouble = mock(UnitID.class);

        try(MockedConstruction<SensorType> sensorTypeDouble = mockConstruction(SensorType.class,(mock, context) -> {
            TypeDescription actualTypeDescription = (TypeDescription) context.arguments().get(0);
            UnitID actualUnitDouble = (UnitID) context.arguments().get(1);
            when(mock.getName()).thenReturn(actualTypeDescription);
            when(mock.getID()).thenReturn(sensorTypeIdDouble);
            when(mock.getUnit()).thenReturn(actualUnitDouble);

        })) {
            ImpSensorTypeFactory impSensorTypeFactory = new ImpSensorTypeFactory();

            // Act
            SensorType sensorType = impSensorTypeFactory.createSensorType(typeDescriptionDouble, unitDouble);

            // Assert
            List<SensorType> sensorTypeList = sensorTypeDouble.constructed();
            assertEquals(1, sensorTypeList.size());
            assertEquals(sensorTypeIdDouble, sensorType.getID());
        }
    }
}
