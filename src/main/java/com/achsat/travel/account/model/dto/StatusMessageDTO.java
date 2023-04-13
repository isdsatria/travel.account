package com.achsat.travel.account.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusMessageDTO<T> {
    private Integer status;
    private String message;
    private T data;
}
