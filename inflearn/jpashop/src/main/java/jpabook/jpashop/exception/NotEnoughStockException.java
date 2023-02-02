package jpabook.jpashop.exception;

public class NotEnoughStockException extends RuntimeException{
    public NotEnoughStockException(){
        super();
    }

    public NotEnoughStockException(String message){
        super(message);
    }

    public NotEnoughStockException(String message, Throwable cause){
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause){
        super(cause);
    }

    protected NotEnoughStockException(String message, Throwable cause, boolean enableSupperession, boolean writableStackTrace){
        super(message, cause, enableSupperession, writableStackTrace);
    }
}
