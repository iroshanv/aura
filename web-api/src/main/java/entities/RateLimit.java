package entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class RateLimit {
    Integer coreLimit;
    Integer searchLimit;

    public Integer getCoreLimit() {
        return coreLimit;
    }

    public void setCoreLimit(Integer coreLimit) {
        this.coreLimit = coreLimit;
    }

    public Integer getSearchLimit() {
        return searchLimit;
    }

    public void setSearchLimit(Integer searchLimit) {
        this.searchLimit = searchLimit;
    }

    @JsonProperty("resources")
    public void unmarshall(Map<String, Object> resources) {
        Map<String, Integer> core = (Map<String, Integer>) resources.get("core");
        coreLimit = core.get("limit");

        Map<String, Integer> search = (Map<String, Integer>) resources.get("search");
        searchLimit = search.get("limit");
    }
}
