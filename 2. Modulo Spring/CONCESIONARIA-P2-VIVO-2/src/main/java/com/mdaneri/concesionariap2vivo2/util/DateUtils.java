package com.mdaneri.concesionariap2vivo2.util;

import java.time.LocalDate;
import java.util.Arrays;

public class DateUtils {

    public static LocalDate convert(String date) {
        int[] params = Arrays.stream(date.split("-")).mapToInt(Integer::parseInt).toArray();
        return LocalDate.of(params[0], params[1], params[2]);
    }

}
