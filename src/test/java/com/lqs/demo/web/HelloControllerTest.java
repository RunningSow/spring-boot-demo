package com.lqs.demo.web;

import com.lqs.demo.service.HelloService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)//使用@WebMvcTest只实例化Web层，而不是整个上下文。在具有多个Controller的应用程序中，
// 甚至可以要求仅使用一个实例化，例如@WebMvcTest(HelloController.class)
class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @Test
    void hello() throws Exception {
        //模拟 helloService.getHello("lqs") 方法执行
        when(helloService.getHello("lqs")).thenReturn("Hello world lqs");
        MockHttpServletResponse response = this.mockMvc.perform(post("/hello?name=lqs")).andDo(print()).andReturn().getResponse();
        Assert.assertTrue(response.getStatus() == HttpStatus.OK.value());
        Assert.assertTrue("Hello world lqs".equals(response.getContentAsString()));
    }
}