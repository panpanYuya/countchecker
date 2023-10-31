package com.creepyy.countchecker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creepyy.countchecker.Exception.BadRequestException;
import com.creepyy.countchecker.Exception.ConstipationException;
import com.creepyy.countchecker.model.entity.Constipation;
import com.creepyy.countchecker.model.form.ConstipationForm;
import com.creepyy.countchecker.service.ConstipationService;

/**
 * お通じに関連している処理を記載
 */
@RestController
@RequestMapping("constipation")
public class ConstipationController {

    @Autowired
    ConstipationService constipationService;

    /**
     * お通じ登録
     * 
     * @param constipationForm
     * @return ResponseEntity<Constipation>
     * @throws ConstipationException
     * @throws BadRequestException
     */
    @RequestMapping("/post")
    public ResponseEntity<Constipation> post(@RequestBody ConstipationForm constipationForm)
            throws ConstipationException, BadRequestException {
        Constipation constipation = new Constipation();
        constipation.setUserId(constipationForm.getUserId());
        constipation.setStatusId(constipationForm.getConstipationStatusForm().getStatusId());
        constipation.setColorId(constipationForm.getConstipationStatusForm().getColorId());
        constipation.setSmellId(constipationForm.getConstipationStatusForm().getSmellId());
        constipation.setQuantityId(constipationForm.getConstipationStatusForm().getQuantityId());
        constipation.setRefreshFeelId(constipationForm.getConstipationStatusForm().getRefreshFeelId());
        constipation.setMemo(constipationForm.getMemo());

        try {
            Constipation registData = constipationService.createConstipation(constipation);
            return new ResponseEntity<Constipation>(registData, HttpStatus.OK);
        } catch (ConstipationException e) {
            throw new BadRequestException(e.getErrorMessage());
        }
    }

    @RequestMapping("/edit")
    public ResponseEntity<String> edit(@RequestParam int constipationId) {
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }

}
