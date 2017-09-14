package com.ttn.beans;

import org.springframework.stereotype.Component;

/**
 * Created by user on 7/13/2017.
 */
@Component
public class CreateDocumentResource {
    String topicnamefordocumentresource;
    String description;

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    String filepath;

    public String getTopicnamefordocumentresource() {
        return topicnamefordocumentresource;
    }

    public void setTopicnamefordocumentresource(String topicnamefordocumentresource) {
        this.topicnamefordocumentresource = topicnamefordocumentresource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
