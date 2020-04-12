package com.xphsc.validation.controller;

import com.xphsc.validation.model.TestModel;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * {@link }
 * @author <a href="xiongpeih@163.com">huipei.x</a>
 * @description:
 * @date:
 * @since 0.1.0
 */
@RestController
public class TestController {

    @PostMapping("/params")
    public Object params(@Validated @RequestBody TestModel testModel) {
        return testModel;
    }


    @GetMapping("/test")
    public Object test() {
        return 122332334;
    }
}
