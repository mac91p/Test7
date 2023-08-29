package pl.kurs.finaltest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.ShapeDto;
import pl.kurs.finaltest.models.*;
import pl.kurs.finaltest.services.ShapeFactoryService;
import pl.kurs.finaltest.services.ShapeManagementService;
import pl.kurs.finaltest.utils.UriParametersExtractor;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
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
    public ResponseEntity<List<ShapeDto>> getShapes(HttpServletRequest httpRequest) throws UnsupportedEncodingException {
        String uri = httpRequest.getQueryString();
        Map<String,String> shapeParameters = UriParametersExtractor.extractQueryParams(uri);
        List<Shape> allShapes = shapeManagementService.getAllShapes(shapeParameters);
        List<ShapeDto> allShapesDto = allShapes.stream()
                .map(x -> {
                    IShapeFactory shapeFactory = shapeFactoryService.getFactory(x.getType());
                    return mapper.map(x, shapeFactory.createShapeDto(x));
                })
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(allShapesDto);
    }
}
