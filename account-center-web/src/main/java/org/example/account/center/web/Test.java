package org.example.account.center.web;

import com.tove.web.infra.common.tool.DateUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Date date1 = new Date(1658764800000L);
        Date date2 = new Date(1661356791999L);
        System.out.println(DateUtils.formatter(date1, DateUtils.DETAILED_NUMBER_PATTERN));
        System.out.println(DateUtils.formatter(date2, DateUtils.DETAILED_NUMBER_PATTERN));
        System.out.println(getDiffDays(date1, date2));
        System.out.println(String.valueOf(DateUtils.getDateDiff(date1, date2)));

        LocalDateTime date3 = Instant.ofEpochMilli(date1.getTime())
                .atZone(ZoneOffset.ofHours(0))
                .truncatedTo(ChronoUnit.DAYS)
                .toLocalDateTime();
        LocalDateTime date4 = Instant.ofEpochMilli(date2.getTime())
                .atZone(ZoneOffset.ofHours(0))
                .truncatedTo(ChronoUnit.DAYS)
                .toLocalDateTime();

        System.out.println(date3.toString());
        System.out.println(date4.toString());
        System.out.println(date3.until(date4, ChronoUnit.DAYS));
        System.out.printf(date3.format(DateTimeFormatter.ofPattern(DateUtils.SIMPLE_PATTERN)));
    }

    public static int getDiffDays(Date beginDate, Date endDate) {
        Instant begin = beginDate.toInstant();
        Instant end = endDate.toInstant();
        return (int) ChronoUnit.DAYS.between(begin, end);
   }
}
