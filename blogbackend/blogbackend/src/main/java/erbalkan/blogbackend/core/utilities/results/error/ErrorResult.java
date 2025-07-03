package erbalkan.blogbackend.core.utilities.results.error;

import erbalkan.blogbackend.core.utilities.results.base.Result;

public class ErrorResult extends Result {

    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}
