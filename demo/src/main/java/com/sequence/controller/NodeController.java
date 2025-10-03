package com.sequence.controller;


import com.sequence.models.Node;
import com.sequence.repository.NodeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public ResponseEntity<Node> addNewNode(@RequestBody Node node){
        if(node == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        try{

        }
    }
}
