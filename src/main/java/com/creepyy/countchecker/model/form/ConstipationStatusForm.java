package com.creepyy.countchecker.model.form;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConstipationStatusForm {

    private int status_id;
    private int color_id;
    private int quantity_id;
    private int smell_id;
    private int refresh_feel_id;

    public int getStatusId() {
        return this.status_id;
    }

    public void setStatusId(int statusId) {
        this.status_id = statusId;
    }

    public int getColorId() {
        return this.color_id;
    }

    public void setColorId(int colorId) {
        this.color_id = colorId;
    }

    public int getQuantityId() {
        return this.quantity_id;
    }

    public void setQuantityId(int quantityId) {
        this.quantity_id = quantityId;
    }

    public int getSmellId() {
        return this.smell_id;
    }

    public void setSmellId(int smellId) {
        this.smell_id = smellId;
    }

    public int getRefreshFeelId() {
        return this.refresh_feel_id;
    }

    public void setRefreshFeelId(int refreshFeelId) {
        this.refresh_feel_id = refreshFeelId;
    }
}
