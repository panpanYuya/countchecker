package com.creepyy.countchecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creepyy.countchecker.model.entity.Constipation;
import com.creepyy.countchecker.repository.ConstipationRepository;

@Service
public class ConstipationService {

    @Autowired
    ConstipationRepository constipationRepository;

    /**
     * お通じをDBに登録する機能
     * 
     * @param constipation
     * @return Constipation
     */
    public Constipation createConstipation(Constipation constipation) {
        Constipation saveData = new Constipation();

        saveData.setUserId(constipation.getUserId());
        saveData.setStatusId(constipation.getStatusId());
        saveData.setColorId(constipation.getColorId());
        saveData.setSmellId(constipation.getSmellId());
        saveData.setQuantityId(constipation.getQuantityId());
        saveData.setRefreshFeelId(constipation.getRefreshFeelId());
        saveData.setMemo(constipation.getMemo());

        return constipationRepository.save(saveData);
    }

}
