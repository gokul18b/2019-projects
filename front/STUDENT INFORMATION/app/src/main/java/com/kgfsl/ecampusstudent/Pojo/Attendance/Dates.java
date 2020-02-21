package com.kgfsl.ecampusstudent.Pojo.Attendance;

/**
 * Created by gokul on 24-10-2017.
 */

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
        "date",
        "day",
        "dayStatus",
        "att_report"
})
public class Dates {

    @JsonProperty("date")
    private String date;
    @JsonProperty("day")
    private String day;
    @JsonProperty("dayStatus")
    private String dayStatus;
    @JsonProperty("att_report")
    private List<String> attReport = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("day")
    public String getDay() {
        return day;
    }

    @JsonProperty("day")
    public void setDay(String day) {
        this.day = day;
    }

    @JsonProperty("dayStatus")
    public String getDayStatus() {
        return dayStatus;
    }

    @JsonProperty("dayStatus")
    public void setDayStatus(String dayStatus) {
        this.dayStatus = dayStatus;
    }

    @JsonProperty("att_report")
    public List<String> getAttReport() {
        return attReport;
    }

    @JsonProperty("att_report")
    public void setAttReport(List<String> attReport) {
        this.attReport = attReport;
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