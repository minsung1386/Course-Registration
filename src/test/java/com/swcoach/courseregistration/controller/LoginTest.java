package com.swcoach.courseregistration.controller;

import com.swcoach.courseregistration.domain.user.UserDto;
import com.swcoach.courseregistration.domain.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class LoginTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void 회원가입_성공() throws Exception {
        // given
        UserDto userDto = new UserDto(
                "test_username",
                "test_password",
                "123-456-7890",
                "test_password",
                "test_password"
        );

        // when
        ResultActions resultActions = mockMvc.perform(post("/signup")
                .flashAttr("userDto", userDto));

        // then
        resultActions
                .andExpect(status().isOk())
                .andExpect(content().string("회원가입이 성공적으로 완료되었습니다."))
                .andExpect(model().attribute("success", true))
                .andDo(print());
    }

    @Test
    public void 비밀번호확인_오류() throws Exception {
        // given
        UserDto userDto = new UserDto(
                "test_username",
                "test_password",
                "123-456-7890",
                "test_password",
                "wrong_password"
        );

        // when
        ResultActions result = mockMvc.perform(post("/signup")
                .flashAttr("userDto", userDto));

        // then
        result.andExpect(status().isForbidden())
                .andExpect(content().string("비밀번호가 일치하지 않습니다."))
                .andDo(print());
    }

}