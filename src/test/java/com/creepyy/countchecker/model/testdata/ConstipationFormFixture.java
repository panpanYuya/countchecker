package com.creepyy.countchecker.model.testdata;

import com.creepyy.countchecker.model.form.ConstipationForm;
import com.creepyy.countchecker.model.form.ConstipationStatusForm;

public class ConstipationFormFixture {

    public static ConstipationForm makeForm(int userId,
            ConstipationStatusForm constipationStatusForm, String memo) {
        return new ConstipationForm(userId, constipationStatusForm, memo);
    }
}
