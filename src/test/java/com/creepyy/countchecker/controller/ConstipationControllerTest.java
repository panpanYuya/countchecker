package com.creepyy.countchecker.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.creepyy.countchecker.model.entity.Constipation;
import com.creepyy.countchecker.model.form.ConstipationForm;
import com.creepyy.countchecker.model.form.ConstipationStatusForm;
import com.creepyy.countchecker.model.testdata.ConstipationFixture;
import com.creepyy.countchecker.model.testdata.ConstipationFormFixture;
import com.creepyy.countchecker.model.testdata.ConstipationStatusFormFixture;
import com.creepyy.countchecker.repository.ConstipationRepository;
import com.creepyy.countchecker.service.ConstipationService;
import com.creepyy.countchecker.service.CreateMockMvcRequestBuilder;

// ↓この下記かただとMockito.performで415が返ってくる
// @SpringBootTest(classes = { ConstipationController.class })
// ↓このアノテーションにより、テスト実行時にリクエストを発行するためのモックオブジェクト「MockMvc」
@WebMvcTest(ConstipationController.class)
@AutoConfigureMockMvc
public class ConstipationControllerTest {

        private final int constipationId = 1;
        private final int userId = 1;
        private final String memo = "true memo";

        // お通じのステータスコード
        private final int statusId = 1;
        private final int colorId = 1;
        private final int quantityId = 1;
        private final int smellId = 1;
        private final int refreshFeelId = 1;

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private ConstipationService constipationService;

        @MockBean
        ConstipationRepository constipationRepository;

        @Test
        public void test_path() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.post("/constipation/post"))
                                .andExpect(MockMvcResultMatchers.status().isOk());
        }

        @Test
        public void test_normal() throws Exception {
                // テストデータを作成
                ConstipationStatusForm testConStatus = ConstipationStatusFormFixture.makeForm(statusId, colorId,
                                quantityId, smellId, refreshFeelId);
                ConstipationForm testConstipation = ConstipationFormFixture.makeForm(userId,
                                testConStatus, memo);
                Constipation expectedData = ConstipationFixture.fixture(constipationId, userId, statusId, colorId,
                                smellId, quantityId,
                                refreshFeelId, memo);
                Map<String, Object> testData = createRequestJson(userId, statusId, colorId, quantityId, smellId,
                                refreshFeelId, memo);

                Mockito.when(constipationService.createConstipation(expectedData)).thenReturn(expectedData);

                // 正常系のテストを実行
                mockMvc.perform(CreateMockMvcRequestBuilder.post("/constipation/post", testData))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("userId")
                                                .value(testConstipation.getUserId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("status_id")
                                                .value(testConstipation.getConstipationStatusForm().getStatusId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("color_id")
                                                .value(testConstipation.getConstipationStatusForm().getColorId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("quantity_id")
                                                .value(testConstipation.getConstipationStatusForm().getQuantityId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("smell_id")
                                                .value(testConstipation.getConstipationStatusForm().getSmellId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("refresh_feel_id")
                                                .value(testConstipation.getConstipationStatusForm()
                                                                .getRefreshFeelId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("memo")
                                                .value(testConstipation.getMemo()));
        }

        private Map<String, Object> createRequestJson(int userId, int statusId, int colorId, int quantityId,
                        int smellerId, int refreshFeelId, String memo) {
                Map<String, Object> requestData = new HashMap<String, Object>();
                Map<String, String> requestStatusData = new HashMap<String, String>();
                requestData.put("user_id", Integer.valueOf(userId).toString());
                requestStatusData.put("status_id", Integer.valueOf(statusId).toString());
                requestStatusData.put("color_id", Integer.valueOf(colorId).toString());
                requestStatusData.put("quantity_id", Integer.valueOf(quantityId).toString());
                requestStatusData.put("smell_id", Integer.valueOf(smellId).toString());
                requestStatusData.put("refresh_feel_id",
                                Integer.valueOf(refreshFeelId).toString());
                requestData.put("constipation_status_form", requestStatusData);
                requestData.put("memo", memo);

                return requestData;
        }

}
