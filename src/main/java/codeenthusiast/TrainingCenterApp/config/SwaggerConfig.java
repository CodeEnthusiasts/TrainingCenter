package codeenthusiast.TrainingCenterApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwYXdlbDIiLCJpYXQiOjE2MDQ3Mjc3NjIsImV4cCI6MTYwNDgxNDE2Mn0.lGOunHUWMJs9b5xdT2UauN_R-z8u5QQEpTPO3hV_A7OYfR6zLYVe1tL2EBNo_i12vdIU8_2J307tMmWdGOQ8Lw";

    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build()
                .useDefaultResponseMessages(false).apiInfo(apiInfo())
                .globalOperationParameters(Collections.singletonList(
                        new ParameterBuilder()
                                .name("Authorization")
                                .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .hidden(true)
                                .defaultValue("Bearer " + TOKEN)
                                .build()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Training Center").version("1.0.0").build();
    }
}