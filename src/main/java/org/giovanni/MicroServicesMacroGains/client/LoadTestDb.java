package org.giovanni.MicroServicesMacroGains.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
class LoadTestDb {
    private static final Logger log = LoggerFactory.getLogger(LoadTestDb.class);

    @Bean
    CommandLineRunner initDb(MemberRepository memberRepository) {
        return args -> {
            memberRepository.save(new Member("John", "Fatson", Gender.MALE, 1.70, 147.5,
                    42.0, true, new Date()));
            memberRepository.save(new Member("Mike", "Grasshopper Chest", Gender.MALE, 1.85,
                    65.0,
                    8.0, true, new Date()));
            memberRepository.save(new Member("Leo", "Nidas", Gender.MALE, 1.80,
                    85.0,
                    7.0, true, new Date()));
            memberRepository.save(new Member("Ana", "Bol", Gender.FEMALE, 1.58,
                    60.2, 17.0, false, new Date()));

            memberRepository.findAll().forEach(member -> {
                log.info("Preloaded " + member);
            });
        };

    }
}
