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

    public static class NotPosibleDeleteException extends Exception {
        public NotPosibleDeleteException(String msg) {
            super(msg+"\n" +
                    "It is not allowed to delete this record.");
        }
    }

}
