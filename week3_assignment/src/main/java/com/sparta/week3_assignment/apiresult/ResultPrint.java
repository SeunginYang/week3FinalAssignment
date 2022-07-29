package com.sparta.week3_assignment.apiresult;

public class ResultPrint {
    public static <T>ApiResult<T> success(T response) {
        return new ApiResult<>(true, response, null);
    }

}
