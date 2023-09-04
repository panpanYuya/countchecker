package com.creepyy.countchecker.model.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConstipationStatusForm {

    private int statusId;
    private int colorId;
    private int quantityId;
    private int smellId;
    private int refreshFeelId;

}
