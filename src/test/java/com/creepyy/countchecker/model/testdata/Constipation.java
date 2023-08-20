package com.creepyy.countchecker.model.testdata;

import com.creepyy.countchecker.model.form.ConstipationForm;
import com.creepyy.countchecker.model.form.ConstipationStatusForm;

public class Constipation {

    public static ConstipationForm makeForm(int constipationId, int userId,
            ConstipationStatusForm constipationStatusForm) {

        return new ConstipationForm(constipationId, userId, constipationStatusForm);
    }
}
