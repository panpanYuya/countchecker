package com.creepyy.countchecker.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.creepyy.countchecker.model.form.ConstipationForm;
import com.creepyy.countchecker.model.form.ConstipationStatusForm;
import com.creepyy.countchecker.model.testdata.ConstipationFixture;
import com.creepyy.countchecker.model.testdata.ConstipationStatus;
import com.creepyy.countchecker.service.CreateMockMvcRequestBuilder;

// ↓この下記かただとMockito.performで415が返ってくる
// @SpringBootTest(classes = { ConstipationController.class })
// ↓このアノテーションにより、テスト実行時にリクエストを発行するためのモックオブジェクト「MockMvc」
@WebMvcTest(ConstipationController.class)
@AutoConfigureMockMvc
public class ConstipationControllerTest {

        private final int constipationId = 1;
        private final int userId = 1;

        // お通じのステータスコード
        private final int statusId = 1;
        private final int colorId = 1;
        private final int quantityId = 1;
        private final int smellId = 1;
        private final int refreshFeelId = 1;

        @Autowired
        private MockMvc mockMvc;

        // @Test
        public void test_path() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.post("/constipation/post"))
                                .andExpect(MockMvcResultMatchers.status().isOk());
        }

        @Test
        public void test_normal() throws Exception {
                // テストデータを作成
                ConstipationStatusForm testConStatus = ConstipationStatus.makeForm(statusId, colorId, quantityId,
                                smellId,
                                refreshFeelId);
                ConstipationForm testConstipation = ConstipationFixture.makeForm(constipationId, userId, testConStatus);

                Map<String, Object> testData = new HashMap<String, Object>();
                Map<String, String> testStatusData = new HashMap<String, String>();
                testData.put("user_id", Integer.valueOf(userId).toString());
                testData.put("constipation_id", Integer.valueOf(constipationId).toString());
                testStatusData.put("status_id", Integer.valueOf(statusId).toString());
                testStatusData.put("color_id", Integer.valueOf(colorId).toString());
                testStatusData.put("quantity_id", Integer.valueOf(quantityId).toString());
                testStatusData.put("smell_id", Integer.valueOf(smellId).toString());
                testStatusData.put("refresh_feel_id",
                                Integer.valueOf(refreshFeelId).toString());
                testData.put("constipation_status_form", testStatusData);

                // 正常系のテストを実行
                mockMvc.perform(CreateMockMvcRequestBuilder.post("/constipation/post", testData))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.jsonPath("user_id")
                                                .value(testConstipation.getUserId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("constipation_id")
                                                .value(testConstipation.getConstipationId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("constipation_status_form.status_id")
                                                .value(testConstipation.getConstipationStatusForm().getStatusId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("constipation_status_form.color_id")
                                                .value(testConstipation.getConstipationStatusForm().getColorId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("constipation_status_form.quantity_id")
                                                .value(testConstipation.getConstipationStatusForm().getQuantityId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("constipation_status_form.smell_id")
                                                .value(testConstipation.getConstipationStatusForm().getSmellId()))
                                .andExpect(MockMvcResultMatchers.jsonPath("constipation_status_form.refresh_feel_id")
                                                .value(testConstipation.getConstipationStatusForm()
                                                                .getRefreshFeelId()));
        }

}
