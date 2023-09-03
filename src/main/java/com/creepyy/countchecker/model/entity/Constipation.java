package com.creepyy.countchecker.model.entity;

import java.util.Date;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@EnableJpaAuditing
@Entity(name = "constipation")
public class Constipation {

    @PrePersist
    public void onPrePersist() {
        setCreatedAt(new Date());
        setUpdatedAt(new Date());
    }

    @PreUpdate
    public void onPreUpdate() {
        setUpdatedAt(new Date());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer statusId;

    private Integer colorId;

    private Integer smellId;

    private Integer quantityId;

    private Integer refreshFeelId;

    private String memo;

    private Date createdAt;

    private Date updatedAt;

}
