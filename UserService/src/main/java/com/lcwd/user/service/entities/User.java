package com.lcwd.user.service.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "micro_users")
@Entity
public class User {


    @Column(name = "ID")
    @Id
    private String userId;
    @Column(name = "NAME",length = 30)
    private String userName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ABOUT")
    private String about;

    @Transient
    private List<Ratings> ratings=new ArrayList<>();
}