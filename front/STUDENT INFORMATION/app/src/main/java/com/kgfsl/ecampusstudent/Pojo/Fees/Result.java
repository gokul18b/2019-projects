package com.kgfsl.ecampusstudent.Pojo.Fees;

/**
 * Created by gokul on 25-10-2017.
 */

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "fees",
        "child"
})
public class Result {

    @JsonProperty("fees")
    private String fees;
    @JsonProperty("child")
    private List<Child> child = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fees")
    public String getFees() {
        return fees;
    }

    @JsonProperty("fees")
    public void setFees(String fees) {
        this.fees = fees;
    }

    @JsonProperty("child")
    public List<Child> getChild() {
        return child;
    }

    @JsonProperty("child")
    public void setChild(List<Child> child) {
        this.child = child;
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
