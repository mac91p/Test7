package pl.kurs.finaltest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.ShapeDto;
import pl.kurs.finaltest.models.*;
import pl.kurs.finaltest.services.ShapeFactoryService;
import pl.kurs.finaltest.services.ShapeManagementService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/shapes")
public class ShapeController {

    private ModelMapper mapper;
    private ShapeManagementService shapeManagementService;
    private ShapeFactoryService shapeFactoryService;


    public ShapeController(ModelMapper mapper, ShapeManagementService shapeManagementService, ShapeFactoryService shapeFactoryService) {
        this.mapper = mapper;
        this.shapeManagementService = shapeManagementService;
        this.shapeFactoryService = shapeFactoryService;
    }

    @PostMapping
    public ResponseEntity<ShapeDto> createShape(@RequestBody CreateShapeCommand createShapeCommand) {
        IShapeFactory matchingFactory = shapeFactoryService.getFactory(createShapeCommand.getType());
        Shape newShape = matchingFactory.createShape(createShapeCommand);
        shapeManagementService.add(newShape);
        ShapeDto shapeDto = mapper.map(newShape, matchingFactory.createShapeDto(newShape));
        return ResponseEntity.status(HttpStatus.CREATED).body(shapeDto);
    }


    @GetMapping
    public ResponseEntity<PageImpl<ShapeDto>> getShapes(@RequestParam Map<String, String> parameters, @PageableDefault Pageable pageable) {
        List<Shape> allShapes = shapeManagementService.getAllShapes(parameters);
        List<ShapeDto> allShapesDto = allShapes.stream()
                .map(x -> {
                    IShapeFactory shapeFactory = shapeFactoryService.getFactory(x.getType());
                    return mapper.map(x, shapeFactory.createShapeDto(x));
                })
                .collect(Collectors.toList());
        PageImpl<ShapeDto> shapeDtoPage = new PageImpl<>(allShapesDto, pageable, allShapes.size());
        return ResponseEntity.status(HttpStatus.OK).body(shapeDtoPage);
    }

}
