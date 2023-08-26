package com.creepyy.countchecker.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.creepyy.countchecker.model.entity.Constipation;
import com.creepyy.countchecker.model.testdata.ConstipationFixture;
import com.creepyy.countchecker.repository.ConstipationRepository;

@WebMvcTest
public class ConstipationServiceTest {
    // TODO DBに値を登録できるサービス層のテストを追加
    @Autowired
    MockMvc mockMvc;

    @MockBean
    ConstipationRepository constipationRepository;

    private ConstipationService constipationService;

    private int userId = 99999999;
    private int statusId = 99999999;
    private int colorId = 99999999;
    private int smellId = 99999999;
    private int quantityId = 99999999;
    private int refreshFeelId = 99999999;
    private String memo = "今日の記録をします。";

    @BeforeEach
    void setUp() {
        constipationService = new ConstipationService();
    }

    @Test
    @DisplayName("createConstipation_正常系")
    public void create_constipation_test() {

        Constipation testData = new ConstipationFixture().makeEntity(userId, statusId, colorId, smellId, quantityId,
                refreshFeelId, memo);

        Constipation result = constipationService.createConstipation(testData);
        Constipation expectedData = constipationRepository.findById(result.getId());

        assertAll(
                () -> assertEquals(testData.getUserId(), expectedData.getUserId()),
                () -> assertEquals(testData.getStatusId(), expectedData.getStatusId()),
                () -> assertEquals(testData.getColorId(), expectedData.getColorId()),
                () -> assertEquals(testData.getSmellId(), expectedData.getSmellId()),
                () -> assertEquals(testData.getQuantityId(), expectedData.getQuantityId()),
                () -> assertEquals(testData.getRefreshFeelId(), expectedData.getRefreshFeelId()),
                () -> assertEquals(testData.getMemo(), expectedData.getMemo()));

    }
}
