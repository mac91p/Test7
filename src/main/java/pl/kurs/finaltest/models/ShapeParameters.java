package pl.kurs.finaltest.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.time.LocalDateTime;

public class ShapeParameters {

    private String type;
    private String createdBy;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Past
    private LocalDateTime createdAtFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Past
    private LocalDateTime createdAtTo;
    private Double heightFrom;
    private Double heightTo;
    private Double widthFrom;
    private Double widthTo;
    private Double areaFrom;
    private Double areaTo;
    private Double perimeterFrom;
    private Double perimeterTo;
    private Double radiusFrom;
    private Double radiusTo;
    private Double lengthFrom;
    private Double lengthTo;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAtFrom() {
        return createdAtFrom;
    }

    public LocalDateTime getCreatedAtTo() {
        return createdAtTo;
    }

    public void setCreatedAtTo(LocalDateTime createdAtTo) {
        this.createdAtTo = createdAtTo;
    }

    public void setCreatedAtFrom(LocalDateTime createdAtFrom) {
        this.createdAtFrom = createdAtFrom;
    }

    public LocalDateTime getGetCreatedAtTo() {
        return createdAtTo;
    }

    public void setGetCreatedAtTo(LocalDateTime getCreatedAtTo) {
        this.createdAtTo = getCreatedAtTo;
    }

    public Double getHeightFrom() {
        return heightFrom;
    }

    public void setHeightFrom(Double heightFrom) {
        this.heightFrom = heightFrom;
    }

    public Double getHeightTo() {
        return heightTo;
    }

    public void setHeightTo(Double heightTo) {
        this.heightTo = heightTo;
    }

    public Double getWidthFrom() {
        return widthFrom;
    }

    public void setWidthFrom(Double widthFrom) {
        this.widthFrom = widthFrom;
    }

    public Double getWidthTo() {
        return widthTo;
    }

    public void setWidthTo(Double widthTo) {
        this.widthTo = widthTo;
    }

    public Double getAreaFrom() {
        return areaFrom;
    }

    public void setAreaFrom(Double areaFrom) {
        this.areaFrom = areaFrom;
    }

    public Double getAreaTo() {
        return areaTo;
    }

    public void setAreaTo(Double areaTo) {
        this.areaTo = areaTo;
    }

    public Double getPerimeterFrom() {
        return perimeterFrom;
    }

    public void setPerimeterFrom(Double perimeterFrom) {
        this.perimeterFrom = perimeterFrom;
    }

    public Double getPerimeterTo() {
        return perimeterTo;
    }

    public void setPerimeterTo(Double perimeterTo) {
        this.perimeterTo = perimeterTo;
    }

    public Double getRadiusFrom() {
        return radiusFrom;
    }

    public void setRadiusFrom(Double radiusFrom) {
        this.radiusFrom = radiusFrom;
    }

    public Double getRadiusTo() {
        return radiusTo;
    }

    public void setRadiusTo(Double radiusTo) {
        this.radiusTo = radiusTo;
    }

    public Double getLengthFrom() {
        return lengthFrom;
    }

    public void setLengthFrom(Double lengthFrom) {
        this.lengthFrom = lengthFrom;
    }

    public Double getLengthTo() {
        return lengthTo;
    }

    public void setLengthTo(Double lengthTo) {
        this.lengthTo = lengthTo;
    }
}
