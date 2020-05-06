package com.nick.baseconstruction;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages = "com.nick.baseconstruction.*")
@EnableSwagger2
public class BaseconstructionApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseconstructionApplication.class, args);
	}

	/**
	 * 创建API应用
	 * apiInfo() 增加API相关信息
	 * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
	 * 本例采用指定扫描的包路径来定义指定要建立API的目录。
	 *
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(basePackage("com.nick.baseconstruction.web.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	/**
	 * 创建该API的基本信息（这些基本信息会展现在文档页面中）
	 * 访问地址：http://项目实际地址/swagger-ui.html
	 *
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("测试 APIs")
				.description("测试api接口文档")
				.termsOfServiceUrl("http://www.baidu.com")
				.version("1.0")
				.build();
	}

	private static Function<Class<?>, Boolean> handlerPackage(final String basePackage) {
		return new Function<Class<?>, Boolean>() {
			public Boolean apply(Class<?> input) {
				for(String packages : basePackage.split(",")){
					boolean isMatch =  input.getPackage().getName().startsWith(packages);
					if(isMatch){
						return true;
					}
				}
				return false;

			}
		};
	}

	public static Predicate<RequestHandler> basePackage(final String basePackage) {
		return new Predicate<RequestHandler>() {
			public boolean apply(RequestHandler input) {
				return ((Boolean) declaringClass(input).transform(handlerPackage(basePackage)).or(true)).booleanValue();
			}
		};
	}

	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
		return Optional.fromNullable(input.declaringClass());
	}


}
