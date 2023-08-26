package com.creepyy.countchecker.model.entity;

import java.io.Serializable;
import java.security.Timestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@RequiredArgsConstructor
public class Constipation implements Serializable {

  @Id
  private Integer id;

  private final Integer userId;

  private final Integer statusId;
  // private Integer status_id;

  private final Integer colorId;
  // private Integer color_id;

  private final Integer smellId;

  private final Integer quantityId;

  private final Integer refreshFeelId;

  private final String memo;

  private Timestamp createdAt;

  private Timestamp updatedAt;

}
