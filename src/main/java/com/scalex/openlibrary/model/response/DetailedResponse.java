package com.scalex.openlibrary.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailedResponse {

    public List<String> publishers;
    public Integer number_of_pages;
    public String subtitle;
    public List<Contributor> contributors;
    public List<String> isbn_10;
    public String pagination;
    public List<Integer> covers;
    public List<String> lc_classifications;
    public List<String> url;
    public String key;
    public List<Author> authors;
    public List<String> publish_places;
    public List<String> contributions;
    public List<String> subjects;
    public List<String> uri_descriptions;
    public List<String> genres;
    public Classifications classifications;
    public List<String> source_records;
    public String title;
    public List<String> dewey_decimal_class;
    public Identifiers identifiers;
    public List<Language> languages;
    public List<String> lccn;
    public List<String> local_id;
    public String publish_date;
    public String publish_country;
    public List<String> work_title;
    public List<Work> works;
    public Type type;
    public List<String> uris;
    public String ocaid;
    public List<String> oclc_numbers;
    public Integer latest_revision;
    public Integer revision;
    public Created created;
    public LastModified last_modified;

    @Data
    public static class Author{
        public String key;
    }

    @Data
    public static class Classifications{
    }

    @Data
    public static class Contributor{
        public String role;
        public String name;
    }

    @Data
    public static class Created{
        public String type;
        public Date value;
    }

    @Data
    public static class Identifiers{
        public List<String> librarything;
        public List<String> goodreads;
    }

    @Data
    public static class Language{
        public String key;
    }

    @Data
    public static class LastModified{
        public String type;
        public Date value;
    }

    @Data
    public static class Type{
        public String key;
    }

    @Data
    public static class Work{
        public String key;
    }
}
