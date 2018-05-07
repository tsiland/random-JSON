package csi403;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class OutJSON implements Serializable{

    private ArrayList outList;
    //private String errorMessage;

    public OutJSON() {
    }

    public ArrayList getOutList() {
        return outList;
    }

    public void setOutList(ArrayList outList) {
        this.outList = outList;
    }


/*
    public String getErrorMessage() { return errorMessage; }

    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
    */
}
