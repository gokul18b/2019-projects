package com.kgfsl.ecampusstudent.Pojo.Announcement;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gokul on 24-10-2017.
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "img",
        "des",
        "link"
})
public class Announcementdatum {

    @JsonProperty("img")
    private String img;
    @JsonProperty("des")
    private String des;
    @JsonProperty("link")
    private String link;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("img")
    public String getImg() {
        return img;
    }

    @JsonProperty("img")
    public void setImg(String img) {
        this.img = img;
    }

    @JsonProperty("des")
    public String getDes() {
        return des;
    }

    @JsonProperty("des")
    public void setDes(String des) {
        this.des = des;
    }

    @JsonProperty("link")
    public String getLink() {
        return link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.link = link;
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