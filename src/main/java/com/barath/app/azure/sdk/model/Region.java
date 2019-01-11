
package com.barath.app.azure.sdk.model;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "boundingBox",
    "lines"
})
public class Region {

    @JsonProperty("boundingBox")
    private String boundingBox;
    @JsonProperty("lines")
    private List<Line> lines = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("boundingBox")
    public String getBoundingBox() {
        return boundingBox;
    }

    @JsonProperty("boundingBox")
    public void setBoundingBox(String boundingBox) {
        this.boundingBox = boundingBox;
    }

    @JsonProperty("lines")
    public List<Line> getLines() {
        return lines;
    }

    @JsonProperty("lines")
    public void setLines(List<Line> lines) {
        this.lines = lines;
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
