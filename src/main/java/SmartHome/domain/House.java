package SmartHome.domain;

import java.util.ArrayList;
import java.util.List;

public class House {
    private LocationFactory _locationFactory;
    private RoomFactory _roomFactory;
    private Location _location;
    private List<Room> _rooms;

    public House(LocationFactory locationFactory, RoomFactory roomFactory) {
        this._locationFactory = locationFactory;
        this._roomFactory = roomFactory;
        this._rooms = new ArrayList<>();
    }
    public Location configureLocation(String street, String zipCode, int doorNumber, double latitude, double longitude) throws IllegalArgumentException {
        _location = _locationFactory.createLocation(street, zipCode, doorNumber, latitude, longitude);
        return _location;
    }


    public Room addRoom(String name, int floor, double length, double width, double height) throws IllegalArgumentException {
        Room room = _roomFactory.createRoom(name, floor, length, width, height);
        addRoomToList(room);
        return room;
    }

    protected Room addRoomToList(Room room) {
        _rooms.add(room);
        return room;
    }
    public List<Room> getRooms() {
        return List.copyOf(_rooms);
    }

    public List<Device> getAllDevices()
    {
        List<Device> deviceList = new ArrayList<>();

        for (Room room : _rooms)
        {
            deviceList.addAll( room.getDevices() );
        }

        return List.copyOf(deviceList);
    }
}
