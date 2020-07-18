package com.qf.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import com.qf.constant.SystemConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: BootSsm
 * @description:
 * @author: Feri
 * @create: 2019-10-21 15:01
 */
@Configuration //配置文件
//@EnableSwagger2WebMvc//启用Swagger
@EnableSwagger2//启用Swagger
@EnableSwaggerBootstrapUI
public class SwaggerConfig {
@Bean
public Docket createRestApi() {
    //添加head参数配置start
    ParameterBuilder tokenPar = new ParameterBuilder();
    List<Parameter> pars = new ArrayList<>();
    tokenPar.name(SystemConstant.TOKEN_HEADER).description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
    pars.add(tokenPar.build());
    //添加head参数配置end
    return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.qf.controller"))
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(pars);//注意这里
}

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("宅客微购后端接口文档")
                .description("这个程序写的真好呀")
                .termsOfServiceUrl("https://www.zkwg.com")
                .version("1.0").contact(new Contact("第一组","https://www.zkwg.com","zkwg@163.com"))
                .build();
    }


}