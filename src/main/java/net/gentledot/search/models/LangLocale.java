package net.gentledot.search.models;

public enum LangLocale {
    kr("kr"), en("en");

    private String locale;

    LangLocale(String locale) {
        this.locale = locale;
    }

    public String locale() {
        return locale;
    }
}
