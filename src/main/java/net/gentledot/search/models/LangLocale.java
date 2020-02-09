package net.gentledot.search.models;

public enum LangLocale {
    KO("kr", "한국어"), US("en", "english");

    private String locale;
    private String value;

    LangLocale(String locale, String value) {
        this.locale = locale;
        this.value = value;
    }

    public String getLocale() {
        return locale;
    }

    public String getValue() {
        return value;
    }
}
