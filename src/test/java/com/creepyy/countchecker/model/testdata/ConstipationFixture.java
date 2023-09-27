package com.creepyy.countchecker.model.testdata;

import com.creepyy.countchecker.model.entity.Constipation;

public class ConstipationFixture {

    public static Constipation fixture(int id, int userId, int statusId, int colorId, int smellId,
            int quantityId, int refreshFeelId, String memo) {
        Constipation fixture = new Constipation();

        fixture.setId(id);
        fixture.setUserId(userId);
        fixture.setStatusId(statusId);
        fixture.setColorId(colorId);
        fixture.setSmellId(smellId);
        fixture.setQuantityId(quantityId);
        fixture.setRefreshFeelId(refreshFeelId);
        fixture.setMemo(memo);

        return fixture;
    }

    public static Constipation fixtureNoId(int userId, int statusId, int colorId, int smellId,
            int quantityId, int refreshFeelId, String memo) {
        Constipation fixture = new Constipation();

        fixture.setUserId(userId);
        fixture.setStatusId(statusId);
        fixture.setColorId(colorId);
        fixture.setSmellId(smellId);
        fixture.setQuantityId(quantityId);
        fixture.setRefreshFeelId(refreshFeelId);
        fixture.setMemo(memo);

        return fixture;
    }

}
