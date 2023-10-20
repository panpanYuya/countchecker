package com.creepyy.countchecker.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.creepyy.countchecker.Exception.ConstipationException;
import com.creepyy.countchecker.common.constants.ErrorConst;
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
    public void create_constipation_test() throws ConstipationException {
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

    @Test
    @DisplayName("createConstipation_DB接続エラー")
    public void create_createConstipation_throw_Exception() throws IllegalArgumentException, ConstipationException {
        Constipation testData = createConstipation(userId, statusId, colorId, smellId, quantityId, refreshFeelId, memo);
        // mockito.whenでservice層で呼び出す処理を実装
        Mockito.when(constipationRepository.save(any(Constipation.class)))
                .thenThrow(new IllegalArgumentException());
        // trycatchでエラーを取得する
        try {
            constipationService.createConstipation(testData);
        } catch (ConstipationException exception) {
            assertEquals(ErrorConst.INTERNAL_SERVER_ERROR_STATUS, exception.getStatusCode());
            assertEquals(ErrorConst.CONNECTION_DB_ERROR_MESSAGE, exception.getErrorMessage());
        }

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
