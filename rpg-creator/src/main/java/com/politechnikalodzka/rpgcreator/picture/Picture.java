package com.politechnikalodzka.rpgcreator.picture;

/**
 *
 * @author lbary
 */
public class Picture {
    private final int ID;
    private final String URL;
    private final TypeOfPictrues TYPE;

    public Picture(int ID, String URL, TypeOfPictrues TYPE) {
        this.ID = ID;
        this.URL = URL;
        this.TYPE = TYPE;
    }

    @Override
    public String toString() {
        return "Picture{" + "id=" + ID + ", url=" + URL + ", type=" + TYPE + "}";
    }

    public int getID() {
        return ID;
    }

    public String getURL() {
        return URL;
    }

    public TypeOfPictrues getTYPE() {
        return TYPE;
    }
}
