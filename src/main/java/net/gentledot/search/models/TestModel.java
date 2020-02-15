package net.gentledot.search.models;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity(name = "Test")
@Getter
@Table(name = "test")
@EqualsAndHashCode
@TypeDef(name = "json",
        typeClass = JsonStringType.class
)
public class TestModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testNo;

    @Type(type = "json")
    private Map<String, String> rawData;

    private String keyword;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    protected TestModel() {
    }

    public TestModel(Map<String, String> rawData, String keyword) {
        this(null, rawData, keyword, null, null);
    }

    public TestModel(Long testNo, Map<String, String> rawData, String keyword, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.testNo = testNo;
        this.rawData = rawData;
        this.keyword = keyword;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "testNo=" + testNo +
                ", rawData=" + rawData +
                ", keyword='" + keyword + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static final class TestModelBuilder {
        private Long testNo;
        private Map<String, String> rawData;
        private String keyword;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public TestModelBuilder() {
        }

        public TestModelBuilder(TestModel model) {
            this.testNo = model.getTestNo();
            this.rawData = model.getRawData();
            this.keyword = model.getKeyword();
            this.createdAt = model.getCreatedAt();
            this.updatedAt = model.getUpdatedAt();
        }

        public TestModelBuilder testNo(Long testNo) {
            this.testNo = testNo;
            return this;
        }

        public TestModelBuilder rawData(Map<String, String> rawData) {
            this.rawData = rawData;
            return this;
        }

        public TestModelBuilder keyword(String keyword) {
            this.keyword = keyword;
            return this;
        }

        public TestModelBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public TestModelBuilder updateAt(LocalDateTime updateAt) {
            this.updatedAt = updateAt;
            return this;
        }

        public TestModel build() {
            return new TestModel(testNo, rawData, keyword, createdAt, updatedAt);
        }
    }
}
