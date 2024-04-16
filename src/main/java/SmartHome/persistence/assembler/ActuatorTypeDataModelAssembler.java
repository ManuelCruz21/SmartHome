package smartHome.persistence.assembler;

import smartHome.domain.actuatorType.ActuatorType;
import smartHome.domain.actuatorType.IActuatorTypeFactory;
import smartHome.persistence.jpa.dataModel.ActuatorTypeDataModel;
import smartHome.valueObject.ActuatorTypeID;
import smartHome.valueObject.TypeDescription;
import smartHome.valueObject.UnitID;

import java.util.ArrayList;
import java.util.List;

public class ActuatorTypeDataModelAssembler implements IDataModelConverter<ActuatorTypeDataModel, ActuatorType>{
    private IActuatorTypeFactory _actuatorTypeFactory;

public ActuatorTypeDataModelAssembler(IActuatorTypeFactory actuatorTypeFactory) {
        validateActuatorTypeFactory (actuatorTypeFactory);
        _actuatorTypeFactory = actuatorTypeFactory;
    }

    /**
     * Validate the actuatorTypeFactory
     * @param actuatorTypeFactory the actuatorTypeFactory to be validated
     */
    private void validateActuatorTypeFactory (IActuatorTypeFactory actuatorTypeFactory) {
        if (actuatorTypeFactory == null)
            throw new IllegalArgumentException("Actuator Type Factory cannot be null");
    }

    /**
     * Method to convert a domain entity into a DataModel.
     * @param domainEntity is the domain entity to be converted.
     * @return the DataModel.
     */
    @Override
    public ActuatorType toDomain(ActuatorTypeDataModel domainEntity) {
        ActuatorTypeID actuatorTypeID = new ActuatorTypeID(domainEntity.getActuatorTypeID());
        TypeDescription actuatorTypeName = new TypeDescription(domainEntity.getActuatorTypeName());
        UnitID unitID = new UnitID(domainEntity.getUnitID());

        ActuatorType actuatorType = _actuatorTypeFactory.createActuatorType(actuatorTypeName, unitID, actuatorTypeID);

        return actuatorType;
    }

    /**
     * Method to convert a list of domain entities into a list of DataModels.
     * @param domainEntities is the list of domain entities to be converted.
     * @return the list of DataModels.
     */
    @Override
    public List<ActuatorType> toDomain(List<ActuatorTypeDataModel> domainEntities) {
        List<ActuatorType> actuatorTypes = new ArrayList<>();

        for(ActuatorTypeDataModel actuatorTypeDataModel : domainEntities) {
            ActuatorType actuatorType = toDomain(actuatorTypeDataModel);
            actuatorTypes.add(actuatorType);
        }
        return actuatorTypes;
    }
}

