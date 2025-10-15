package com.mohan.expense_tracker_app;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Expense Tracker REST API Documentation",
				description = "Expense Tracker REST API Documentation",
				version = "V1.0",
				contact = @Contact(
						name = "Mohan",
						email = "mohan@gmail.com",
						url = "https://www.mohan.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.mohan.com/license"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Expense tracker REST API Documentation for Developers",
				url = "https://www.mohan.com/external-doc.html"
		)
)

@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}
