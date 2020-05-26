package com.codeengine.expenseTracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "category")
public class Category {

    @Id
    private long id;

    //Travel, grocery, ...
    private String name;


}
