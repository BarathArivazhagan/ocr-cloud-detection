
package com.barath.app.azure.sdk.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "language",
    "textAngle",
    "orientation",
    "regions"
})
public class AzureOCRImageResponse {

    @JsonProperty("language")
    private String language;
    @JsonProperty("textAngle")
    private Double textAngle;
    @JsonProperty("orientation")
    private String orientation;
    @JsonProperty("regions")
    private List<Region> regions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("textAngle")
    public Double getTextAngle() {
        return textAngle;
    }

    @JsonProperty("textAngle")
    public void setTextAngle(Double textAngle) {
        this.textAngle = textAngle;
    }

    @JsonProperty("orientation")
    public String getOrientation() {
        return orientation;
    }

    @JsonProperty("orientation")
    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    @JsonProperty("regions")
    public List<Region> getRegions() {
        return regions;
    }

    @JsonProperty("regions")
    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
