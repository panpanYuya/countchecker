package com.creepyy.countchecker.model.testdata;

import com.creepyy.countchecker.model.form.ConstipationStatusForm;

public class ConstipationStatusFormFixture {

    public static ConstipationStatusForm makeForm(int statusId, int colorId, int quantityId, int smellId,
            int refreshFeelId) {
        ConstipationStatusForm testStatusForm = new ConstipationStatusForm(statusId, colorId, quantityId, smellId,
                refreshFeelId);
        return testStatusForm;
    }
}
