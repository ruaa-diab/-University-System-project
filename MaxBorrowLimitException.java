package TheLibrary;

public class MaxBorrowLimitException extends RuntimeException {  //i extende it like that because i want to convert it to unckecked so i can throw it without the need to do declaration
    
    private String msg;
    
    public MaxBorrowLimitException() {
        this.setMsg("You can't borrow more than 5 items.");
    }
    
    public MaxBorrowLimitException(String msg) {
        this.setMsg(msg);
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
