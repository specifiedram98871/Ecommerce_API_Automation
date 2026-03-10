package framework.utils;

import java.util.Random;

public class RandomUtils {

    public static int generateId() {
        return new Random().nextInt(100000);
    }
}