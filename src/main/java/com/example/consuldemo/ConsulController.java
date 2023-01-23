package com.example.consuldemo;

import com.example.consuldemo.consul.ConsulProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @Value("${address}")
    private String address;

    private final ConsulProperties consulProperties;

    public ConsulController(ConsulProperties consulProperties) {
        this.consulProperties = consulProperties;
    }

    @GetMapping("/userInfo")
    private String getUserInfo() {
        return "The user name is ".concat(name).concat(" and his age is ").concat(age).concat(" He is living in ").concat(address);
    }

    @GetMapping("/userInfoFromConsul")
    private String getUserInfoFromConsul() {
        return "The user name is ".concat(consulProperties.getDataByKey("name")).concat(" and his age is ").concat(consulProperties.getDataByKey("age")).concat(" He is living in ").concat(consulProperties.getDataByKey("address"));
    }

    @GetMapping("/health")
    private String healthCheck() {
        return "HEALTH CHECK OK";
    }
}
