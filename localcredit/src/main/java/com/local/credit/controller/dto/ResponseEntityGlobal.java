package com.local.credit.controller.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseEntityGlobal {

    private int type;
    private String message;
    private Object data;
}
