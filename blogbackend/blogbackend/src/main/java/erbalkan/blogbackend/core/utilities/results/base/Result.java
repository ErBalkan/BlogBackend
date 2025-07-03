package erbalkan.blogbackend.core.utilities.results.base;

// Abstract sınıf tercih ettik çünkü bu sınıfın doğrudan new'lenmesi istemiyoruz.
public abstract class Result {
    private final boolean success;
    private final String message;
    
    protected Result(boolean success) {
        this.success = success;
        this.message = null;
    }

    protected Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
