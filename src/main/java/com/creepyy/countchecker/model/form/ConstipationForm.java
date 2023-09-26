package com.creepyy.countchecker.model.form;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ConstipationForm implements Serializable {

    private int userId;
    private ConstipationStatusForm constipationStatusForm;
    private String memo;

}
