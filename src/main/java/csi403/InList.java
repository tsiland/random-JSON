package csi403;

import java.io.Serializable;
import java.util.ArrayList;

public class InList implements Serializable{

    private ArrayList<SubInJSON> InList;

    public InList() {
    }


    public ArrayList<SubInJSON> getInList() {
        return InList;
    }

    public void setInList(ArrayList<SubInJSON> inList) {
        InList = inList;
    }
}