package net.gentledot.search.models.api.request;

import lombok.experimental.SuperBuilder;
import net.gentledot.search.models.LangLocale;

import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

@SuperBuilder
public class Keywords {
    private Map<LangLocale, String> rawData;

    protected Keywords(){

    }

    public Keywords(Map<LangLocale, String> rawData) {
        checkNotNull(rawData, "검색어는 null이 될 수 없음.");
        this.rawData = rawData;
    }

    public Map<LangLocale, String> getRawData() {
        return rawData;
    }
}
