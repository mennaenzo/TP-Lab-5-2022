package com.lab5.tp2022.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonTypeName("basketbolista")
@EqualsAndHashCode(callSuper = true)
public class Basketbolista extends Deportista{
    private Integer puntos;
    private Integer rebotes;
}
