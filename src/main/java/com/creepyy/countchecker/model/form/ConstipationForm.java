package com.creepyy.countchecker.model.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConstipationForm {

    private int userId;
    private ConstipationStatusForm constipationStatusForm;
    private String memo;

}
