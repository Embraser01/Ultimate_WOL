package com.embraser01.android.ultimate_wol.database;


public class ReadOnlyException extends Exception {

    public ReadOnlyException() {
        super();
    }

    public ReadOnlyException(String detailMessage) {
        super(detailMessage);
    }

    public ReadOnlyException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public ReadOnlyException(Throwable throwable) {
        super(throwable);
    }
}
