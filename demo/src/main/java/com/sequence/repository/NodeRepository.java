package com.sequence.repository;

import com.sequence.models.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NodeRepository extends JpaRepository<Node, Integer> {

    //thanks to jpa, spring reads this as the sql statement to call the db
    Optional<Node> findByCode(String code);

}
