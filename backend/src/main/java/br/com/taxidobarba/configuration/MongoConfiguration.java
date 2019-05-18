package br.com.taxidobarba.configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.stereotype.Component;

@Component
public class MongoConfiguration{

    private static final ZoneId ZONE_ID = ZoneId.of("America/Sao_Paulo");
    @Bean 
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        converters.add(new LocalDateTimeToZonedDateTimeConverter());
        converters.add(new ZonedDateTimeToLocalDateTimeConverter());
        converters.add(new DateToZonedDateTimeConverter());
        return new MongoCustomConversions(converters);
    }

    class LocalDateTimeToZonedDateTimeConverter implements Converter<LocalDateTime, ZonedDateTime> {
        @Override
        public ZonedDateTime convert(LocalDateTime source) {
            return source == null ? null : ZonedDateTime.of(source, ZONE_ID);
        }
    }

    class ZonedDateTimeToLocalDateTimeConverter implements Converter<ZonedDateTime, LocalDateTime> {
        @Override
        public LocalDateTime convert(ZonedDateTime source) {
            return source == null ? null : LocalDateTime.ofInstant(source.toInstant(), ZONE_ID);
        }
    }
    
    class DateToZonedDateTimeConverter implements Converter<Date, ZonedDateTime> {
        @Override
        public ZonedDateTime convert(Date source) {
            return source == null ? null : ZonedDateTime.ofInstant(source.toInstant(), ZONE_ID);
        }
    }

}
