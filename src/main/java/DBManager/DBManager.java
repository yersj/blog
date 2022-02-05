package DBManager;

import model.Author;
import model.Blog;
import model.Comment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public static Connection connection;

    public static void setConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?useUnicode=true&serverTimezone=UTC", "root", "");
            System.out.println("DB connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Author getAuthor(String email) {
        Author author = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select *from author where email=?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                author = new Author(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return author;
    }

    public static Author getAuthorById(Long author_id) {
        Author author = null;
        try {
            PreparedStatement statement = connection.prepareStatement("select *from author where id=?");
            statement.setLong(1, author_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                author = new Author(resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("password"));
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return author;
    }

    public static boolean addAuthor(Author author) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO author (id, name, email, password)\n" +
                    "VALUES (null, ?, ?, ?);");
            statement.setString(1, author.getName());
            statement.setString(2, author.getEmail());
            statement.setString(3, author.getPassword());
            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;

    }


    public static boolean updateName(Author author) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("update author set name=? where id=?");

            statement.setString(1, author.getName());
            statement.setLong(2, author.getId());
            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;

    }

    public static boolean addBlog(Blog blog) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO blogs (id, title, content, author_id)\n" +
                    "VALUES (null, ?, ?, ?);");
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContent());
            statement.setLong(3, blog.getAuthor_id());
            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;

    }

    public static boolean deleteBlog(Long id) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("delete from blogs where id=?");
            statement.setLong(1, id);
            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;

    }

    public static boolean updateBlog(Long id, String title, String content) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("update blogs set title=?,content=? where id=?");
            statement.setString(1, title);
            statement.setString(2, content);
            statement.setLong(3, id);
            rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;

    }

    public static ArrayList<Blog> getAllBlogs() {
        ArrayList<Blog> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select *from blogs");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new Blog(resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content"),
                        resultSet.getLong("author_id")));
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<Comment> getCommentsByBlogId(Long id) {
        List<Comment> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select * from comments where blog_id=? order by desc");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new Comment(resultSet.getLong("id"),
                        resultSet.getString("comment"),
                        resultSet.getLong("author_id"),
                        resultSet.getLong("blog_id")));
            }

            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean addComment(Comment comment) {
        int rows = 0;
        try {
            PreparedStatement statement = connection.prepareStatement("insert into comments " +
                    "(id,comment,author_id,blog_id) values (null,?,?,?)");
            statement.setString(1, comment.getComment());
            statement.setLong(2, comment.getAuthor_id());
            statement.setLong(3, comment.getBlog_id());
            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    public static void deleteComment(Long id) {

        try {
            PreparedStatement statement = connection.prepareStatement("delete from comments where id=?");
            statement.setLong(1, id);
            statement.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<Comment> getAllComments() {
        List<Comment> comments=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("select *from comments");

            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()){
                comments.add(new Comment(
                        resultSet.getLong("id"),
                        resultSet.getString("comment"),
                        resultSet.getLong("author_id"),
                        resultSet.getLong("blog_id")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }


}
