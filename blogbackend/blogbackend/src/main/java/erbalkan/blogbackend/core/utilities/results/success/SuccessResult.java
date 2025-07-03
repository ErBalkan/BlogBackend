package erbalkan.blogbackend.core.utilities.results.success;

import erbalkan.blogbackend.core.utilities.results.base.Result;

public class SuccessResult extends Result {

    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
