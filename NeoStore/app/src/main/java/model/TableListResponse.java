package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableListResponse {

    @SerializedName("data")
    private List<TablesData> data;

    public List<TablesData> getData() {
        return data;
    }

}
