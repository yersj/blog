package model;

public class Comment {
    private Long id;
    private String comment;
    private Long author_id;
    private Long blog_id;

    public Comment(){}
    public Comment(Long id, String comment, Long author_id, Long blog_id) {
        this.id = id;
        this.comment = comment;
        this.author_id = author_id;
        this.blog_id = blog_id;
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public Long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Long blog_id) {
        this.blog_id = blog_id;
    }
}
