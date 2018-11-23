package com.fise;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket create() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true) // 生产环境改为false
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.fise"))
                .paths(PathSelectors.any()) // 生产环境设为PathSelectors.none 二选其一 推荐选上面的
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring boot学习项目，API描述")
                .description("")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
}
