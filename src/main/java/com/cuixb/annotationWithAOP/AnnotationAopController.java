package com.cuixb.annotationWithAOP;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/annotationAOP")
public class AnnotationAopController {

	@Token
    @RequestMapping("/test")
    public String testAop(String key){
		System.out.println("controller 中的处理");
        return "testAop: key = " + key;
    }

}