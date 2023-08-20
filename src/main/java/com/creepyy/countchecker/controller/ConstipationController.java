package com.creepyy.countchecker.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creepyy.countchecker.model.form.ConstipationForm;

@RestController
@RequestMapping("constipation")
public class ConstipationController {

  @RequestMapping("/post")
  public ResponseEntity<Map<String, Object>> post(@RequestBody ConstipationForm constipationForm) {
    Map<String, Object> requestData = new HashMap<String, Object>();
    Map<String, String> requestStatusData = new HashMap<String, String>();
    requestData.put("user_id", Integer.valueOf(constipationForm.getUserId()).toString());
    requestData.put("constipation_id", Integer.valueOf(constipationForm.getConstipationId()).toString());
    requestStatusData.put("status_id",
        Integer.valueOf(constipationForm.getConstipationStatusForm().getStatusId()).toString());
    requestStatusData.put("color_id",
        Integer.valueOf(constipationForm.getConstipationStatusForm().getColorId()).toString());
    requestStatusData.put("quantity_id",
        Integer.valueOf(constipationForm.getConstipationStatusForm().getQuantityId()).toString());
    requestStatusData.put("smell_id",
        Integer.valueOf(constipationForm.getConstipationStatusForm().getSmellId()).toString());
    requestStatusData.put("refresh_feel_id",
        Integer.valueOf(constipationForm.getConstipationStatusForm().getRefreshFeelId()).toString());
    requestData.put("constipation_status_form", requestStatusData);

    return new ResponseEntity<Map<String, Object>>(requestData, HttpStatus.OK);
  }
}
