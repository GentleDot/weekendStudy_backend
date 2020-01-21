package net.gentledot.search.models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Test")
@Getter
@Table(name ="test")
@EqualsAndHashCode
@TypeDef(name = "json",
        typeClass = JsonStringType.class
)
public class TestModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testNo;

    @Type(type = "json")
    private Langs rawData;

    private String keyword;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;

    public TestModel() {
    }

    public TestModel(Long testNo) {
        this.testNo = testNo;
    }

    public TestModel(Long testNo, Langs rawData, String keyword, LocalDateTime createdAt, LocalDateTime updatedAt) {
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
                ", rawData='" + rawData + '\'' +
                ", keyword='" + keyword + '\'' +
                ", createdAt=" + createdAt +
                ", updateAt=" + updatedAt +
                '}';
    }

    public static TestModelBuilder builder(TestModel testModel) {
        return new TestModelBuilder(testModel);
    }


    public static final class TestModelBuilder {
        private Long testNo;
        private Langs rawData;
        private String keyword;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private TestModelBuilder(TestModel model) {
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

        public TestModelBuilder rawData(Langs rawData) {
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
