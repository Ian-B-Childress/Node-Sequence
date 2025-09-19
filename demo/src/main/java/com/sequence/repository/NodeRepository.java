package com.sequence.repository;

import com.sequence.models.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NodeRepository extends JpaRepository<Node, Integer> {
    Optional<Node> findByNodeId(Integer nodeId);
}
