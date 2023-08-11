package pl.kurs.finaltest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.ShapeDto;
import pl.kurs.finaltest.models.Shape;
import pl.kurs.finaltest.models.ShapeFactory;
import pl.kurs.finaltest.services.ShapeFactoryService;
import pl.kurs.finaltest.security.AuthenticationProvider;
import pl.kurs.finaltest.services.ShapeManagementService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/v1/shapes")
public class ShapeController {

    private ModelMapper mapper;
    private ShapeManagementService shapeManagementService;
    private ShapeFactoryService shapeFactoryService;
    private AuthenticationProvider authenticationProvider;


    public ShapeController(ModelMapper mapper, ShapeManagementService shapeManagementService, ShapeFactoryService shapeFactoryService, AuthenticationProvider authenticationProvider) {
        this.mapper = mapper;
        this.shapeManagementService = shapeManagementService;
        this.shapeFactoryService = shapeFactoryService;
        this.authenticationProvider = authenticationProvider;
    }

    @PostMapping
    public ResponseEntity<ShapeDto> createShape(@RequestBody CreateShapeCommand createShapeCommand) {
        String username = authenticationProvider.getUsername();
        ShapeFactory matchingFactory = shapeFactoryService.getFactory(createShapeCommand.getType());
        Shape newShape = matchingFactory.createShape(createShapeCommand, username);
        shapeManagementService.add(newShape);
        ShapeDto shapeDto = mapper.map(newShape, matchingFactory.createShapeDto(newShape).getClass());
        return ResponseEntity.status(HttpStatus.CREATED).body(shapeDto);
    }

    @GetMapping
    public ResponseEntity<List<ShapeDto>> getShapesByParameters(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String createdBy,
            @RequestParam(required = false) Double areaFrom,
            @RequestParam(required = false) Double areaTo,
            @RequestParam(required = false) Double perimeterFrom,
            @RequestParam(required = false) Double perimeterTo,
            @RequestParam(required = false) Double widthFrom,
            @RequestParam(required = false) Double widthTo,
            @RequestParam(required = false) Double heightFrom,
            @RequestParam(required = false) Double heightTo,
            @RequestParam(required = false) Double radiusFrom,
            @RequestParam(required = false) Double radiusTo,
            @RequestParam(required = false) Double lengthFrom,
            @RequestParam(required = false) Double lengthTo,
            @RequestParam(required = false) LocalDateTime createdAtFrom,
            @RequestParam(required = false) LocalDateTime createdAtTo) {
        Specification<Shape> spec = shapeManagementService.createShapeSpecification(type, createdBy, areaFrom, areaTo,
                perimeterFrom, perimeterTo, widthFrom, widthTo, heightFrom, heightTo, radiusFrom, radiusTo,lengthFrom,
                lengthTo, createdAtFrom, createdAtTo);
        List<ShapeDto> allShapes = shapeManagementService.getAllBySpec(spec).stream()
                .map(x -> {
                    ShapeFactory shapeFactory = shapeFactoryService.getFactory(x.getType());
                    return mapper.map(x, shapeFactory.createShapeDto(x).getClass());
                })
                .collect(Collectors.toList());
        return ResponseEntity.ok(allShapes);
    }



}
