package com.creepyy.countchecker.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = { ConstipationController.class })
// ↓このアノテーションにより、テスト実行時にリクエストを発行するためのモックオブジェクト「MockMvc」
@AutoConfigureMockMvc
public class ConstipationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_path() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/constipation/post"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
