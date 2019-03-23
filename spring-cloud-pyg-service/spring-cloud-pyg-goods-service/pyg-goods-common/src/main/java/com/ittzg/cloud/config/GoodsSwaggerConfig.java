package com.ittzg.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/27 14:28
 * @Description: 这是商品模块的swagger文档
 */
@Configuration
@EnableSwagger2
public class GoodsSwaggerConfig  extends WebMvcConfigurerAdapter{
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ittzg.cloud"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("品优购电商项目商品模块api")
                .description("SpringCloud RestApi of Goods")
                .contact("ittzg")
                .version("1.0")
                .build();
    }

    public static void main(String[] args) {

    }
}
