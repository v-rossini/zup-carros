package br.com.vitor.zupcarros;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@RestController
public class ZupcarrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZupcarrosApplication.class, args);
	}

	@RequestMapping("")
	public void redirect(HttpServletResponse httpServletResponse) {
		httpServletResponse.setHeader("Location", "/swagger-ui.html");
		httpServletResponse.setStatus(302);
	}
	
}
