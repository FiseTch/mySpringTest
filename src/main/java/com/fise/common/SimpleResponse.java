package com.fise.common;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleResponse {

    private String message;
    private Type type;

    public enum Type {
        SUCCESSFUL,FIAILED,EXCEPTION
    }
}
