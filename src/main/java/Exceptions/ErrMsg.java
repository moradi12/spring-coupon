package Exceptions;

public enum ErrMsg {
    ID_NOT_FOUND("id not found.."),
    ID_ALREADY_EXISTS("Id already exists!");

    private String msg;

    ErrMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
