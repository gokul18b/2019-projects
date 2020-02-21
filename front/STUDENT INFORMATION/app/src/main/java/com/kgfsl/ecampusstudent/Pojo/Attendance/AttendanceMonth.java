package com.kgfsl.ecampusstudent.Pojo.Attendance;

/**
 * Created by gokul on 24-10-2017.
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
        "status",
        "Sem",
        "months"
})
public class AttendanceMonth {
    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("Sem")
    private List<String> sem = null;
    @JsonProperty("months")
    private List<String> months = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public Boolean getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @JsonProperty("Sem")
    public List<String> getSem() {
        return sem;
    }

    @JsonProperty("Sem")
    public void setSem(List<String> sem) {
        this.sem = sem;
    }

    @JsonProperty("months")
    public List<String> getMonths() {
        return months;
    }

    @JsonProperty("months")
    public void setMonths(List<String> months) {
        this.months = months;
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
