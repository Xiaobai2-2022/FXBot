package com.fangxia.fxbot.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(description = "API Response from Server")
public class FXApiResponse<T> {

    public static final String SUCCESS_RESPONSE = "200";
    public static final String ILLEGAL_ACCESS_RESPONSE = "403";
    public static final String NOT_FOUND_RESPONSE = "404";
    public static final String ERROR_RESPONSE = "500";

    public static final String SUCCESS_MESSAGE = "Success";
    public static final String NOT_FOUND_MESSAGE = "Not Found";
    public static final String ERROR_MESSAGE = "Internal Server Error";

    @Schema(description = "Data Wrapped in Response")
    private T data;

    @Schema(description = "Response Message")
    private String msg;

    @Schema(description = "Response Code")
    private String code;

    public static <T> FXApiResponse<T> success(T data) {
        return FXApiResponse
            .<T>builder()
            .data(data)
            .msg(SUCCESS_MESSAGE)
            .code(SUCCESS_RESPONSE)
            .build();
    }

    public static <T> FXApiResponse<T> failure(T data) {
        return FXApiResponse
                .<T>builder()
                .data(data)
                .msg(ERROR_MESSAGE)
                .code(ERROR_RESPONSE)
                .build();
    }

    public static <T> FXApiResponse<T> illegal(String msg) {
        return FXApiResponse
                .<T>builder()
                .data(null)
                .msg(msg)
                .code(ILLEGAL_ACCESS_RESPONSE)
                .build();
    }

    @Schema(description = "Given if the Response is Successful - 200")
    public boolean isSuccess() {
        return SUCCESS_RESPONSE.equals(this.code);
    }

}
