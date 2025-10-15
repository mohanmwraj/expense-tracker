package com.mohan.expense_tracker_app.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "ErrorDetails DTO (Data Transfer Object) to " +
                "transfer the error response data between client and server"
)

@Getter
@Setter
public class ErrorDetails {

    @Schema(description = "Error Occurred data time")
    private LocalDateTime timeStamp;

    @Schema(description = "Error Message")
    private String message;

    @Schema(description = "Error Details")
    private String details;

    @Schema(description = "Error Code")
    private String errorCode;

}
