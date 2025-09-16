package com.bright.userprofilems;

import com.bright.userprofilems.dto.request.ProfileRequestDto;
import com.bright.userprofilems.dto.request.UserRequestDto;
import com.bright.userprofilems.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class UserProfilemsApplication {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserProfilemsApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            userService.createUser(
                    new UserRequestDto(
                            "tom", "Ch1*",
                            new ProfileRequestDto(
                                    "Tom", "Varghese",
                                    LocalDate.parse("2020-06-02"),
                                    "christene@gmail.com",
                                    "123456789",
                                    "I am Mickey"
                            )
                    )
            );

            userService.createUser(
                    new UserRequestDto(
                            "jerry", "Ch1*",
                            new ProfileRequestDto(
                                    "Jerry", "Varghese1",
                                    LocalDate.parse("2020-06-02"),
                                    "christen1e@gmail.com",
                                    "123456789",
                                    "I am Tom"
                            )
                    )
            );

            userService.createUser(
                    new UserRequestDto(
                            "mickey", "Ch1*",
                            new ProfileRequestDto(
                                    "Mickey", "Varghese2",
                                    LocalDate.parse("2020-06-02"),
                                    "christen2e@gmail.com",
                                    "123456789",
                                    "I am Donald"
                            )
                    )
            );

            userService.createUser(
                    new UserRequestDto(
                            "donald", "Ch1*",
                            new ProfileRequestDto(
                                    "Donald", "Varghese3",
                                    LocalDate.parse("2020-06-02"),
                                    "christen3e@gmail.com",
                                    "123456789",
                                    "I am Jerry"
                            )
                    )
            );
        };
    }

}
