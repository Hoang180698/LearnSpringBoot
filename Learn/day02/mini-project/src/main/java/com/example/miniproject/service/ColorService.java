package com.example.miniproject.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ColorService {
    public ColorService(){

    }
    public String randomColor(int type) {
        return  switch (type) {
            case 1 -> randomColorName();
            case 2 -> randomHexName();
            case 3 -> randomRGBName();
            default -> throw new RuntimeException("type khong hop le");
        };
    }

    private String randomColorName() {
        List<String> colors = List.of("black", "white", "blue", "green");
        Random random = new Random();
        return colors.get(random.nextInt(colors.size()));
    }

    private String randomRGBName() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return "rgb(" +r + "," +g +"," +b + ")";
    }

    private String randomHexName() {
        Random obj = new Random();
        int rand_num = obj.nextInt(0xffffff + 1);
        return String.format("#%06x", rand_num);
    }
}
