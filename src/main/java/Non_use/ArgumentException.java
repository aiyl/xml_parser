package Non_use;

public class ArgumentException extends RuntimeException{
    public ArgumentException(String message) {
        super(message);
    }
}
/*Если что неверно в аргументах например:
throw new Non_use.ArgumentException("not supported key:" + args[2]);
 */