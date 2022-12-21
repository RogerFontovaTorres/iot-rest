package iot.home.service.iotrest.dao;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Sensors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDAO {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "homeId")
    private Integer homeId;

    @Column(name = "room")
    private String room;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

}
