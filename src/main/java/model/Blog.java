package model;

public class Blog {
    private Long id;
    private String title;
    private String content;
    private Long author_id;

    public Blog(){}

    public Blog(Long id, String title, String content, Long author_id) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author_id = author_id;
    }

    public Long getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }


}
