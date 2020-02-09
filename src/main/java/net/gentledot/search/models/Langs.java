package net.gentledot.search.models;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.regex.Pattern.matches;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class Langs {
    private final String kr;
    private final String en;

    public Langs(String kr, String en) {
        checkNotNull(kr, "한국어 검색어는 null이 될 수 없습니다.");
        checkNotNull(en, "영어 검색어는 null이 될 수 없습니다.");
        checkArgument(isNotEmpty(kr), "한국어 검색어는 빈 값이 될 수 없습니다.");
        checkArgument(isNotEmpty(en), "영어 검색어는 빈 값이 될 수 없습니다.");
        checkArgument(matches("[가-힣._-]+", kr), "한국어 검색어는 한글만 입력 가능합니다.");
        checkArgument(matches("[a-zA-Z._-]+", en), "한국어 검색어는 한글만 입력 가능합니다.");

        this.kr = kr;
        this.en = en;
    }

    public String getKr() {
        return kr;
    }

    public String getEn() {
        return en;
    }
}
