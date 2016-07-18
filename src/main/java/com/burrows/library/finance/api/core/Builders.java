package com.burrows.library.finance.api.core;

public class Builders {
    public static Request request() {
        return new Request.Impl();
    }
}
