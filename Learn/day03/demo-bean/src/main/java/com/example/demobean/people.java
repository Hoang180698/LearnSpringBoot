package com.example.demobean;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class people {
    private final Student student;
    private final Random random;
}
