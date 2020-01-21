package net.gentledot.search.repositories;

import net.gentledot.search.models.TestModel;
import org.aspectj.weaver.ast.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long> {
    List<TestModel> findAllByKeyword(String keyword);
}
