package SmartHomeDDD.ValueObject;

import SmartHomeDDD.ddd.ValueObject;

public class RoomName implements ValueObject {
    private String _name;

    /**
     * Class constructor.
     *
     * @param name The room name to set.
     */
    public RoomName(String name) {
        validateRoomName(name);
        _name = name.trim();
    }

    /**
     * Sets the room name after validating it.
     *
     * @param name The room name to set.
     */
    private void validateRoomName(String name) {
        if (name == null || name.isEmpty() || name.isBlank()){
            throw new IllegalArgumentException("The room name cannot be null, blank, or empty.");
        }

        if (!name.matches("[a-zA-Z0-9 ]+")) {
            throw new IllegalArgumentException("The room name can only contain letters and numbers.");
        }
    }

    /**
     * Gets the room name.
     *
     * @return The room name.
     */
    public String getRoomName() {
        return _name;
    }
    /*
    /The method getRoomName should be replaced by a generic method in the ValueObject interface
    */

    /**
     * Compares the current object with another object of the same type.
     *
     * @param o The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o instanceof RoomName) {
            RoomName roomName = (RoomName) o;
            if (this._name.equals(roomName._name))
                return true;
        }
        return false;
    }

    /**
     * Returns the string representation of the object.
     *
     * @return The string representation of the object.
     */
    @Override
    public String toString () {
        return this._name;
    }
}
