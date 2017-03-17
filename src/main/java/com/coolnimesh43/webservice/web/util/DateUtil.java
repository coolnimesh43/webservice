package com.coolnimesh43.webservice.web.util;

import java.time.Duration;
import java.time.ZonedDateTime;

public class DateUtil {

    public static Long getDifferenceInDays(ZonedDateTime startDate, ZonedDateTime endDate) {
        if (startDate != null && endDate != null) {
            return Duration.between(startDate, endDate).toDays();
        }
        return 0L;
    }
}
