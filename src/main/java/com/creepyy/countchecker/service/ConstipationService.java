package com.creepyy.countchecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creepyy.countchecker.Exception.ConstipationException;
import com.creepyy.countchecker.model.entity.Constipation;
import com.creepyy.countchecker.repository.ConstipationRepository;

@Service
public class ConstipationService {

    @Autowired
    ConstipationRepository constipationRepository;

    /**
     * 
     * @param constipation
     * @return Constipation
     * @throws ConstipationException
     */
    public Constipation createConstipation(Constipation constipation) throws ConstipationException {
        try {
            return constipationRepository.save(constipation);
        } catch (IllegalArgumentException exception) {
            throw new ConstipationException(500, "Can't connect DB", "サーバに問題が発生しました");
        }
    }

}
