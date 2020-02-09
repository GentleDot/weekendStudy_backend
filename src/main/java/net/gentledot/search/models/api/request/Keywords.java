package net.gentledot.search.models.api.request;

import net.gentledot.search.models.Langs;
import org.apache.commons.lang3.StringUtils;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class Keywords {
    private final Langs rawData;
    private final String keyword;

    public Keywords(Langs rawData, String keyword) {
        checkNotNull(rawData, "검색어는 null이 될 수 없음.");
        checkNotNull(keyword, "키워드는 null이 될 수 없음.");
        checkArgument(isNotEmpty(keyword), "키워드는 빈 값이 될 수 없음.");
        this.rawData = rawData;
        this.keyword = keyword;
    }

    public Langs getRawData() {
        return rawData;
    }

    public String getKeyword() {
        return keyword;
    }
}
