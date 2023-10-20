package com.creepyy.countchecker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.creepyy.countchecker.Exception.ConstipationException;
import com.creepyy.countchecker.common.constants.ErrorConst;
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
            throw new ConstipationException(ErrorConst.INTERNAL_SERVER_ERROR_STATUS,
                    ErrorConst.CONNECTION_DB_ERROR_MESSAGE);
        } catch (RuntimeException exception) {
            throw new ConstipationException(ErrorConst.INTERNAL_SERVER_ERROR_STATUS,
                    ErrorConst.CONNECTION_DB_ERROR_MESSAGE);
        }
    }

}
