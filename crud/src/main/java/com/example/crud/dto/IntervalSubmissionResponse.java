package com.example.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IntervalSubmissionResponse {
    @JsonProperty("status_code")
    private String statusCode;
}
