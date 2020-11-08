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

    private final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwYXdlbDIiLCJpYXQiOjE2MDQ4MjEzNTYsImV4cCI6MTYwNDkwNzc1Nn0.x0Fbxj_Nh48OLP4e3VKK0JUuxzdBrvdYDq9P_qJbMGz95ZIoUOIifGJJJbXUK5ZNiFR9WI4Onsm7qKIgLcehCA";

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