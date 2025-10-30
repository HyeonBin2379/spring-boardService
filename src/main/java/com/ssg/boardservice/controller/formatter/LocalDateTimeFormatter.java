package com.ssg.boardservice.controller.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

// 날짜/형변환에 관한 커스터마이징을 수행할 때 주로 사용
// servlet-context.xml에서 빈으로 등록
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 문자열을 지정한 형식에 맞게 파싱
    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        return LocalDateTime.parse(text, FORMATTER);
    }

    // 파싱한 내용을 바탕으로 문자열을 지정한 타입으로 변환
    @Override
    public String print(LocalDateTime object, Locale locale) {
        return FORMATTER.format(object);
    }
}
