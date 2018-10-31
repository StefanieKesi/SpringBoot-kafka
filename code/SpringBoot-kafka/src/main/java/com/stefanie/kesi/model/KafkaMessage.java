package com.stefanie.kesi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter
@Getter
public class KafkaMessage implements Serializable{

    private String data;
    private String creatorName;

}
