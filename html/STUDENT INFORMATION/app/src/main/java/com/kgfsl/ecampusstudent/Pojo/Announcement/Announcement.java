package com.kgfsl.ecampusstudent.Pojo.Announcement;

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
        "status",
        "announcementdata"
})
public class Announcement {

    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("announcementdata")
    private List<Announcementdatum> announcementdata = null;
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

    @JsonProperty("announcementdata")
    public List<Announcementdatum> getAnnouncementdata() {
        return announcementdata;
    }

    @JsonProperty("announcementdata")
    public void setAnnouncementdata(List<Announcementdatum> announcementdata) {
        this.announcementdata = announcementdata;
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