package ua.training.model.entity.knight;

/**
 * Created by Roman Prokopenko on 17.11.2016.
 */
public class NoSuchItemTypeException extends RuntimeException {
    public NoSuchItemTypeException(String message){
        super(message);
    }
}
