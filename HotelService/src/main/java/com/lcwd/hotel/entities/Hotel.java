package com.lcwd.hotel.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "hotels")
@Entity
public class Hotel {

    public String getHotelid() {
        return hotelid;
    }

    public void setHotelid(String hotelid) {
        this.hotelid = hotelid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getAbout() {
        return about;
    }

    @Column(name = "ID")
    @Id
    private String hotelid;
    @Column(name = "NAME",length = 30)
    private String name;
    @Column(name = "LOCATION",length = 30)
    private String location;
    @Column(name = "ABOUT",length = 100)
    private String about;


}
