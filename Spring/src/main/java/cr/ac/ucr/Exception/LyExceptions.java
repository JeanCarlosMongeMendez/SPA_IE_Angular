package cr.ac.ucr.Exception;

public class LyExceptions {


    public static class RecordNotFoundException extends Exception {
        public RecordNotFoundException(String msg) {
            super(msg);
        }
    }

    public static class NameExistException extends Exception {
        public  NameExistException() {
        }
    }



}
