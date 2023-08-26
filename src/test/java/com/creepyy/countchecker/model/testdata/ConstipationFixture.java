package com.creepyy.countchecker.model.testdata;

import com.creepyy.countchecker.model.entity.Constipation;
import com.creepyy.countchecker.model.form.ConstipationForm;
import com.creepyy.countchecker.model.form.ConstipationStatusForm;

public class ConstipationFixture {

    public static ConstipationForm makeForm(int constipationId, int userId,
            ConstipationStatusForm constipationStatusForm) {

        return new ConstipationForm(constipationId, userId, constipationStatusForm);
    }

    public static Constipation makeEntity(int userId, int statusId, int colorId, int smellId, int quantityId,
            int refreshFeelId, String memo) {
        return new Constipation(userId, statusId, colorId, smellId, quantityId, refreshFeelId, memo);
    }
}
