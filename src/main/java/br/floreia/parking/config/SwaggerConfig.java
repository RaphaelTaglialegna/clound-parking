package br.floreia.parking.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.service.contexts.SecurityContext;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
  private Contact contact() {
    return new Contact(
        "Raphael Taglialegna",
        "https://github.com/RaphaelTaglialegna/dio-bootcamp-projeto-spring",
        "raphael.trcosta@gmail.com");
  }
    
  private ApiInfoBuilder informacoesApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Parking Springboot");
        apiInfoBuilder.description("This final course project will simulate a car parking using spring boot framework.");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença - Raphael Taglialegna");
        apiInfoBuilder.licenseUrl("https://github.com");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;

    }
    @Bean
    public Docket api() {
      Docket docket = new Docket(DocumentationType.SWAGGER_2);

      docket
          .select()
          .apis(RequestHandlerSelectors.basePackage("br.floreia.parking"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(this.informacoesApi().build())
          .consumes(new HashSet<String>(Arrays.asList("application/json")))
          .produces(new HashSet<String>(Arrays.asList("application/json")))
          .securityContexts(Arrays.asList(actuatorSecurityContext()))
          .securitySchemes(Arrays.asList(basicAuthScheme()));

      return docket;
    }
    private SecurityContext actuatorSecurityContext() {
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(basicAuthReference()))
                .build();
    }

    private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    private SecurityReference basicAuthReference() {
        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
    }

    private List<SecurityScheme> basicScheme() {
        List<SecurityScheme> schemeList = new ArrayList();
        schemeList.add(new BasicAuth("basicAuth"));
        return schemeList;
    }

    private ApiKey apiKey() {
        return new ApiKey("apiKey", "Authorization", "header");
    }
    
}
