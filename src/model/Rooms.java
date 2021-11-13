package model;

public class Rooms {
    private String roomNumber;
    private String roomType;
    private String roomSize;

    public Rooms() {
    }

    public Rooms(String roomNumber, String roomType, String roomSize) {
        this.setRoomNumber(roomNumber);
        this.setRoomType(roomType);
        this.setRoomSize(roomSize);
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }
}
