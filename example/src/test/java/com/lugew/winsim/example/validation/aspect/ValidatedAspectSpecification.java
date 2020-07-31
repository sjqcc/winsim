package com.lugew.winsim.example.validation.aspect;

import com.lugew.winsim.example.controller.AbstractMvcControllerSpecification;
import com.lugew.winsim.example.controller.ValidatedController;
import com.lugew.winsim.example.entity.Validated;
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

    @Override
    public MockMvc mockMvc() {
        return mockMvc;
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

    @Test
    void givenNameNotNullAndPasswordNotNullWhenBothNotNullThenOK() throws Exception {
        Validated entity = new Validated();
        entity.setName("lugew");
        entity.setPassword("123456");
        post("/validated/nameAndPasswordNotNull", entity)
                .andExpect(jsonMatcher("$.code", 0));
    }

    @Test
    void givenNameNotNullAndPasswordNotNullWhenBothNullThenError() {
        Validated entity = new Validated();
        assertThatThrownBy(() -> post("/validated/nameAndPasswordNotNull", entity))
                .hasMessageContaining("cant be null");
    }

    @Test
    void givenNameNotNullAndPasswordNotNullWhenNameNotNullThenError() {
        Validated entity = new Validated();
        entity.setName("lugew");
        assertThatThrownBy(() -> post("/validated/nameAndPasswordNotNull", entity))
                .hasMessageContaining("password cant be null");
    }

    @Test
    void givenNameNotNullAndPasswordNullWhenNormalThenOK() throws Exception {
        Validated entity = new Validated();
        entity.setName("lugew");
        post("/validated/nameNotNullAndPasswordNull", entity)
                .andExpect(jsonMatcher("$.code", 0));
    }

    @Test
    void givenNameNotNullAndPasswordNullWhenPasswordNotNullThenOK() throws Exception {
        Validated entity = new Validated();
        entity.setName("lugew");
        entity.setPassword("123456");
        assertThatThrownBy(() -> post("/validated/nameNotNullAndPasswordNull", entity))
                .hasMessageContaining("password must be null");
    }

    @Test
    void givenSingleValidNameNotNullWhenNameNotNullThenOK() throws Exception {
        Validated entity = new Validated();
        entity.setName("lugew");
        post("/validated/singleValidNameNotNull", entity)
                .andExpect(jsonMatcher("$.code", 0));
    }

    @Test
    void givenSingleValidNameNotNullWhenNameNullThenError() {
        Validated entity = new Validated();
        assertThatThrownBy(() -> post("/validated/singleValidNameNotNull", entity))
                .hasMessageContaining("name cant be null");

    }


}