package com.mohan.expense_tracker_app.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        description = "Category DTO ( Data Transfer Object) to transfer the data between the client and server"
)


//records to create a immutable class.
public record CategoryDto(Long id,
                          @Schema(
                                  description = "Category Name"
                          )
                          String name) {
}
