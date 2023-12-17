package com.parkplus.parkinglot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@SuperBuilder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}