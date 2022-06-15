package com.lab5.tp2022.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ErrorBody {
    private String message;
    private int code;
}
