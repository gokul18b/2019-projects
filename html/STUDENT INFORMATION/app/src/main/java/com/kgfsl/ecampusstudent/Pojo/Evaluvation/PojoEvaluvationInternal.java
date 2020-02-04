package com.kgfsl.ecampusstudent.Pojo.Evaluvation;

/**
 * Created by manivasagam on 01-11-2017.
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
        "noe",
        "exname",
        "data"
})
public class PojoEvaluvationInternal {

    @JsonProperty("noe")
    private Integer noe;
    @JsonProperty("exname")
    private List<String> exname = null;
    @JsonProperty("data")
    private List<DatumInternal> data = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("noe")
    public Integer getNoe() {
        return noe;
    }

    @JsonProperty("noe")
    public void setNoe(Integer noe) {
        this.noe = noe;
    }

    @JsonProperty("exname")
    public List<String> getExname() {
        return exname;
    }

    @JsonProperty("exname")
    public void setExname(List<String> exname) {
        this.exname = exname;
    }

    @JsonProperty("data")
    public List<DatumInternal> getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<DatumInternal> data) {
        this.data = data;
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