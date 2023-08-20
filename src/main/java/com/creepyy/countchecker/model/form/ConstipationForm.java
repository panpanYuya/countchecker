package com.creepyy.countchecker.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class ConstipationForm {

    private int constipation_id;
    private int user_id;
    private ConstipationStatusForm constipation_status_form;

    public int getConstipationId() {
        return this.constipation_id;
    }

    public void setConstipationId(int constipationId) {
        this.constipation_id = constipationId;
    }

    public int getUserId() {
        return this.user_id;
    }

    public void setUserId(int userId) {
        this.user_id = userId;
    }

    public ConstipationStatusForm getConstipationStatusForm() {
        return this.constipation_status_form;
    }

    public void setConstipationStatusForm(ConstipationStatusForm constipationStatusForm) {
        this.constipation_status_form = constipationStatusForm;
    }

}
