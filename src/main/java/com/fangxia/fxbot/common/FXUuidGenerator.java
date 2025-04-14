package com.fangxia.fxbot.common;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FXUuidGenerator implements IdentifierGenerator {

    @Override
    public String nextUUID(Object entity) {
        return UUID.randomUUID().toString();
    }

    @Override
    public Number nextId(Object entity) {
        return null;
    }

}
