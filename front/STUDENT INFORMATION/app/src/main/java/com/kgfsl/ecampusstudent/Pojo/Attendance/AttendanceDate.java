package com.kgfsl.ecampusstudent.Pojo.Attendance;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "status",
        "punchcount",
        "Dates"
})
public class AttendanceDate {

    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("punchcount")
    private Integer punchcount;
    @JsonProperty("Dates")
    private List<Dates> dates = null;
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

    @JsonProperty("punchcount")
    public Integer getPunchcount() {
        return punchcount;
    }

    @JsonProperty("punchcount")
    public void setPunchcount(Integer punchcount) {
        this.punchcount = punchcount;
    }

    @JsonProperty("Dates")
    public List<Dates> getDates() {
        return dates;
    }

    @JsonProperty("Dates")
    public void setDates(List<Dates> dates) {
        this.dates = dates;
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