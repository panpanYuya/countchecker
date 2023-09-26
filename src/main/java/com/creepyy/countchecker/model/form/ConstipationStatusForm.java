package com.creepyy.countchecker.model.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConstipationStatusForm implements Serializable {

    private int statusId;
    private int colorId;
    private int quantityId;
    private int smellId;
    private int refreshFeelId;

}
