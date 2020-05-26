package com.codeengine.expenseTracker.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    private long id;

    private String name;

    private String email;


}
