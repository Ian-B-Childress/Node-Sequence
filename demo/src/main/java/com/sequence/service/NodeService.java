package com.sequence.service;


import com.sequence.models.Node;
import com.sequence.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//i wanna get the barebones crud stuff i may need
@Service
public class NodeService {

    private final NodeRepository nodeRepository;

    @Autowired
    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public Node saveNode(Node node){
        return nodeRepository.save(node);
    }

    public Optional<Node> getNodeById(Integer id){
        return nodeRepository.findById(id);
    }

    public List<Node> getAllNodes(){
        return nodeRepository.findAll();
    }

    public void deleteNode(Integer id){
        nodeRepository.deleteById(id);
    }

    public Optional<Node> findByCode(String code){return nodeRepository.findByCode(code);}

    public Optional<Node> findPrevious(int id){return nodeRepository.findByIdLessThanOrderByDesc(id);}

    public Optional<Node> findNext(int id){return nodeRepository.findByIdGreaterThanOrderByAsc(id);}

}
