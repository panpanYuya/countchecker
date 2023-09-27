package com.creepyy.countchecker.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.creepyy.countchecker.model.entity.Constipation;
import com.creepyy.countchecker.model.testdata.ConstipationFixture;

//本番環境のテストデータを使用して実装することが出来る
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class ConstipationRepositoryTest {

    @Autowired
    ConstipationRepository constipationRepository;

    private int userId = 99999999;
    private int statusId = 99999999;
    private int colorId = 99999999;
    private int smellId = 99999999;
    private int quantityId = 99999999;
    private int refreshFeelId = 99999999;
    private String memo = "今日の記録をします。";

    @Test
    @DisplayName("save_正常系")
    public void test_save() {

        Constipation testData = ConstipationFixture.fixtureNoId(userId, statusId, colorId, smellId, quantityId,
                refreshFeelId, memo);

        constipationRepository.save(testData);

        List<Constipation> result = constipationRepository.findByUserId(userId);

        // データが取得できなかったので失敗
        if (result.size() == 0) {
            fail();
        }

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getUserId() == userId) {
                assertEquals(result.get(i).getUserId(), userId);
                assertEquals(result.get(i).getStatusId(), statusId);
                assertEquals(result.get(i).getColorId(), colorId);
                assertEquals(result.get(i).getSmellId(), smellId);
                assertEquals(result.get(i).getQuantityId(), quantityId);
                assertEquals(result.get(i).getRefreshFeelId(), refreshFeelId);
                assertEquals(result.get(i).getMemo(), memo);
                break;
            }
            // 一致するものがないため失敗
            if (result.size() == i + 1) {
                fail();
            }
        }

    }

}
