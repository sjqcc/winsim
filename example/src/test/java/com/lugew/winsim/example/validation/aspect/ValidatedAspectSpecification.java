package com.lugew.winsim.example.validation.aspect;

import com.lugew.winsim.example.controller.AbstractMvcControllerSpecification;
import com.lugew.winsim.example.controller.ValidatedController;
import com.lugew.winsim.example.entity.Validated;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * 字段验证器说明
 *
 * @author LuGew
 * @since 2020/7/30
 */
@WebMvcTest({ValidatedController.class, ValidatedAspect.class})
@EnableAspectJAutoProxy(proxyTargetClass = true)
class ValidatedAspectSpecification extends AbstractMvcControllerSpecification {
    @Autowired
    ValidatedController controller;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {

    }

    @Test
    void givenUsernameNotNullWenUsernameNotNullThenOk() throws Exception {
        Validated entity = new Validated();
        entity.setName("lugew");
        post("/validated/nameNotNull", entity)
                .andExpect(jsonMatcher("$.code", 0));
    }

    @Test
    void givenUsernameNotNullWenUsernameNullThenError() {
        Validated entity = new Validated();
        assertThatThrownBy(() -> post("/validated/nameNotNull", entity))
                .hasMessageContaining("name cant be null");

    }

    @Override
    public MockMvc mockMvc() {
        return mockMvc;
    }
}