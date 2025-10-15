package com.mohan.expense_tracker_app.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
    private String errorCode;

}
