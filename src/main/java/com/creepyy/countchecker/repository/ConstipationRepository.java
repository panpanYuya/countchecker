package com.creepyy.countchecker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creepyy.countchecker.model.entity.Constipation;
import java.util.List;

@Repository
public interface ConstipationRepository extends JpaRepository<Constipation, Integer> {

    List<Constipation> findByUserId(Integer userId);

}
