package com.vicuts.service.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_service")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Service {

    @Id
    @GeneratedValue
    Integer id;
    String name;
    Integer price;
    String description;
}
