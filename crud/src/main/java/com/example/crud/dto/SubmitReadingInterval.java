package com.example.crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import jakarta.validation.constraints.Min;


@Data
public class SubmitReadingInterval {
    @JsonProperty("book_id")
    @NotNull
    private Integer bookId;

    @JsonProperty("user_id")
    private int userId;


    @JsonProperty("start_interval")
    @Min(value = 1, message = "minimum number of start interval is 1")
    private int startInterval;

    @JsonProperty("end_interval")
    @Max(value = 5000, message = "maximum number of end interval is 5000")
    private int endInterval;
}
