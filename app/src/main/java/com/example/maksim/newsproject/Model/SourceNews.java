package com.example.maksim.newsproject.Model;

import java.util.ArrayList;

/**
 * Created by Maksim on 17.12.2016.
 */

public class SourceNews {

    String status;
    ArrayList<ModelNews> sources;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ModelNews> getSources() {
        return sources;
    }

    public void setSource(ArrayList<ModelNews> sources) {
        this.sources = sources;
    }
}
