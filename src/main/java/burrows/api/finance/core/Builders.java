package burrows.api.finance.core;

public class Builders {
    public static Request request() {
        return new Request.Impl();
    }
}
