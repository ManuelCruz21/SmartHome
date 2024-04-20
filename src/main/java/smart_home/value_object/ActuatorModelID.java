package smart_home.value_object;

import smart_home.ddd.IDomainID;

public class ActuatorModelID implements IDomainID {
    private final String _actuatorModelId;

    public ActuatorModelID(String actuatorModelId) throws IllegalArgumentException {
        validationActuatorModelID(actuatorModelId);
        this._actuatorModelId = actuatorModelId;
    }

    private void validationActuatorModelID(String actuatorModelID) {
        if (actuatorModelID == null || actuatorModelID.isBlank())
            throw new IllegalArgumentException("The value of 'actuatorModelID' should not null, blank, or empty.");
    }

    @Override
    public String getID() {
        return _actuatorModelId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object instanceof ActuatorModelID actuatorModelID) {

            return this._actuatorModelId.equals(actuatorModelID._actuatorModelId);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return _actuatorModelId.hashCode();
    }
}
