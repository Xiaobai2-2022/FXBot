package com.fangxia.fxbot.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MyUuidGenerator implements IdentifierGenerator {

    @Override
    public String nextUUID(Object entity) {
        return UUID.randomUUID().toString();
    }

    @Override
    public Number nextId(Object entity) {
        return null;
    }

}
