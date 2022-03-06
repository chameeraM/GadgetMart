

package com.edu.soap.gadgetMart.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String userid;
    private String fullname;
    private String username;
    private String password;
    private String email;
    private String status;
    private String mobilenumber;

}
