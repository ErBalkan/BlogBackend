package erbalkan.blogbackend.core.utilities.results.base;

// Abstract sınıf tercih ettik çünkü bu sınıfın doğrudan new'lenmesini istemiyoruz.
public abstract class DataResult<T> extends Result {
    private final T data;

    protected DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }

    protected DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
