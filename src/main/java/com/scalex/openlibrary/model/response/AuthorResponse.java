package com.scalex.openlibrary.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    public String name;
    public String personal_name;
    public LastModified last_modified;
    public String key;
    public String birth_date;
    public Type type;
    public int id;
    public int revision;

    @Data
    public static class LastModified{
        public String type;
        public String value;
    }

    @Data
    public static class Type{
        public String key;
    }

}
