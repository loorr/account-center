package org.example.account.center.web.util;

import com.tove.web.infra.common.tool.Md5Tools;

import java.util.Map;
import java.util.Random;

public class RandomUtil {
    private final static Random random = new Random();
    public static Long getRandomLong(int size) {
        if (size < 1) {
            return 0L;
        }
        if (size > 18) {
            return 0L;
        }
        StringBuilder sb = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(10);
            while (i == 0 && num == 0){
                num = random.nextInt(10);
            }
            sb.append(num);
        }
        return Long.parseLong(sb.toString());
    }
}
