package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserModel {
    private UserData data;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserData {
        private Integer id;

    }
}