package chat.models;

import javax.persistence.*;

@Entity
public class Messages {
    @GeneratedValue(generator = "messages_seq")
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "user_id",nullable = false,insertable = false,updatable = false)
    private Long userId;
    @OneToOne(optional = false)
    private User user;

    @Basic
    @Column(name = "message")
    private String message;
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Messages messages = (Messages) o;

        if (id != null ? !id.equals(messages.id) : messages.id != null) return false;
        if (userId != null ? !userId.equals(messages.userId) : messages.userId != null) return false;
        if (message != null ? !message.equals(messages.message) : messages.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "id=" + id +
                ", userId=" + userId +
                ", user=" + user +
                ", message='" + message + '\'' +
                '}';
    }
}
