package net.gentledot.search.models;

public class Langs {
    private String KR;
    private String EN;

    protected Langs() {}

    public Langs(String KR, String EN) {
        this.KR = KR;
        this.EN = EN;
    }

    public String getKR() {
        return KR;
    }

    public String getEN() {
        return EN;
    }

    public void setKR(String KR) {
        this.KR = KR;
    }

    public void setEN(String EN) {
        this.EN = EN;
    }
}
