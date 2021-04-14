package com.csi.msscbeerservice.web.controller;

import com.csi.msscbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto>getBeerById(@PathVariable UUID beerId){
        //todo impl
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveNewBeer(@Valid @RequestBody BeerDto beerDto){
        //todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable UUID beerId,@Valid @RequestBody BeerDto beerDto){
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
