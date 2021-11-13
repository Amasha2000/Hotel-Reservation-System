package view.tm;

import javafx.scene.control.Button;

public class RoomsTM {
    private String roomNum;
    private String roomType;
    private String roomSize;
    private Button btn;

    public RoomsTM() {
    }

    public RoomsTM(String roomNum, String roomType, String roomSize, Button btn) {
        this.setRoomNum(roomNum);
        this.setRoomType(roomType);
        this.setRoomSize(roomSize);
        this.setBtn(btn);
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}
