package net.gentledot.study.repositories;

import net.gentledot.study.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
    // nativeQuery = true : entity 자동 생성 쿼리가 아닌 입력한 쿼리가 동작.
    @Query(value = "SELECT * FROM test WHERE MATCH (keyword) AGAINST (CONCAT('+', :query, '*') IN BOOLEAN MODE)", nativeQuery = true)
    List<Test> search(String query);
}
