package com.ttn.beans;

import org.springframework.stereotype.Component;

/**
 * Created by user on 7/13/2017.
 */
@Component
public class CreateLinkedResource {
    String url,description,topicnameforlinkedresource;
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopicnameforlinkedresource() {
        return topicnameforlinkedresource;
    }

    public void setTopicnameforlinkedresource(String topicnameforlinkedresource) {
        this.topicnameforlinkedresource = topicnameforlinkedresource;
    }
}
