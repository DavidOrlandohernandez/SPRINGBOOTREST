package com.local.credit.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.http.HttpHeaders;

@OpenAPIDefinition(
        info = @Info(
                title = "API LOCAL CREDIT",
                description = "App - Administración de sistemas pyme de servicios. ",
                termsOfService = "www.localcredit.com/terminos_y_condiciones",
                version = "0.0.1-SNAPSHOT",
                contact = @Contact(
                        name = "David Hernandez Bastidas",
                        url = "https://localcredit.com",
                        email = "david.hernandez@gmail.com"

                ),
                license = @License(
                        name = "Standar Sofware use License for LocalCredit",
                        url = "https://localcredit.com/licence"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8083"
                ),
                @Server(
                        description = "TEST SERVER",
                        url = "http://localhost:8083"
                )
        }/*,
        security = @SecurityRequirement(
                name = "Security Token"
        )*/
)
/*@SecurityScheme(
        name = "Security Token",
        description = "Access Token For My API",
        type = SecuritySchemeType.HTTP,
        paramName = HttpHeaders.AUTHORIZATION,
        in = SecuritySchemeIn.HEADER,
        scheme = "bearer",
        bearerFormat = "JWT"
)*/
public class SwaggerConfig {
}
