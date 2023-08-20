package pl.kurs.finaltest.controllers;

import com.querydsl.core.types.Predicate;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kurs.finaltest.commands.CreateShapeCommand;
import pl.kurs.finaltest.dto.ShapeDto;
import pl.kurs.finaltest.models.*;
import pl.kurs.finaltest.respositories.predicates.*;
import pl.kurs.finaltest.services.ShapeFactoryService;
import pl.kurs.finaltest.security.AuthenticationProvider;
import pl.kurs.finaltest.services.ShapeManagementService;
import javax.validation.Valid;
import java.util.ArrayList;
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
        IShapeFactory matchingFactory = shapeFactoryService.getFactory(createShapeCommand.getType());
        Shape newShape = matchingFactory.createShape(createShapeCommand, username);
        shapeManagementService.add(newShape);
        ShapeDto shapeDto = mapper.map(newShape, matchingFactory.createShapeDto(newShape).getClass());
        return ResponseEntity.status(HttpStatus.CREATED).body(shapeDto);
    }

    @GetMapping
    public ResponseEntity<List<ShapeDto>> getShapes(@Valid ShapeParameters shapeParameters) {
        Predicate circlePredicate = CirclePredicate.createCirclePredicate(shapeParameters);
        Predicate rectanglePredicate = RectanglePredicate.createRectanglePredicate(shapeParameters);
        Predicate squarePredicate = SquarePredicate.createSquarePredicate(shapeParameters);
        List<Circle> circleList = shapeManagementService.getCircles(circlePredicate);
        List<Square> squareList = shapeManagementService.getSquares(squarePredicate);
        List<Rectangle> rectangleList = shapeManagementService.getRectangles(rectanglePredicate);
        List<Shape> allShapes = new ArrayList<>();
        allShapes.addAll(circleList);
        allShapes.addAll(squareList);
        allShapes.addAll(rectangleList);
        List<ShapeDto> allShapesDto = allShapes.stream()
                .map(x -> {
                    IShapeFactory shapeFactory = shapeFactoryService.getFactory(x.getType());
                    return mapper.map(x, shapeFactory.createShapeDto(x).getClass());
                })
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(allShapesDto);

    }
}
