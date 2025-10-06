package com.sequence.controller;


import com.sequence.models.Node;
import com.sequence.repository.NodeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/n")
public class NodeController {

    private final NodeRepository nodeRepository;


    public NodeController(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Node> getAllNodes(){return nodeRepository.findAll();}


    //TODO: finish post

    @PostMapping("/nodes")
    public ResponseEntity<Node> addNewNode(@RequestBody Node node){
        if(node == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try{
            Node savedNode = nodeRepository.save(node);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedNode);
        } catch (Exception e){
            System.out.println("something went wrong, NodeController/addNewNode" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
