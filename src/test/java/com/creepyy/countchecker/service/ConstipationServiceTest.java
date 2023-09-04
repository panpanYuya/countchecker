package com.creepyy.countchecker.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.creepyy.countchecker.model.entity.Constipation;
import com.creepyy.countchecker.model.testdata.ConstipationFixture;
import com.creepyy.countchecker.repository.ConstipationRepository;

@WebMvcTest(ConstipationService.class)
public class ConstipationServiceTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ConstipationRepository constipationRepository;

    @Autowired
    private ConstipationService constipationService;

    private int id = 99999999;
    private int userId = 99999999;
    private int statusId = 99999999;
    private int colorId = 99999999;
    private int smellId = 99999999;
    private int quantityId = 99999999;
    private int refreshFeelId = 99999999;
    private String memo = "今日の記録をします。";

    @Test
    @DisplayName("createConstipation_正常系")
    public void create_constipation_test() {
        Constipation testData = createConstipation(userId, statusId, colorId, smellId, quantityId, refreshFeelId, memo);
        Constipation expectedData = ConstipationFixture.fixture(id, userId, statusId, colorId, smellId, quantityId,
                refreshFeelId, memo);

        Mockito.when(constipationRepository.save(testData)).thenReturn(expectedData);

        Constipation result = constipationService.createConstipation(testData);
        assertAll(
                () -> assertEquals(testData.getUserId(), result.getUserId()),
                () -> assertEquals(testData.getStatusId(), result.getStatusId()),
                () -> assertEquals(testData.getColorId(), result.getColorId()),
                () -> assertEquals(testData.getSmellId(), result.getSmellId()),
                () -> assertEquals(testData.getQuantityId(), result.getQuantityId()),
                () -> assertEquals(testData.getRefreshFeelId(), result.getRefreshFeelId()),
                () -> assertEquals(testData.getMemo(), result.getMemo()));

    }

    private Constipation createConstipation(int userId, int statusId, int colorId, int smellId, int quantityId,
            int refreshFeelId, String memo) {
        Constipation testData = new Constipation();
        testData.setUserId(userId);
        testData.setStatusId(statusId);
        testData.setColorId(colorId);
        testData.setSmellId(smellId);
        testData.setQuantityId(quantityId);
        testData.setRefreshFeelId(refreshFeelId);
        testData.setMemo(memo);
        return testData;
    }
}
