package chat.models;

import javax.persistence.*;

@Entity
@Table(name = "messages", schema = "public", catalog = "chat")
public class Messages {
    private long id;
    private String message;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message", nullable = true, length = -1)
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

        if (id != messages.id) return false;
        if (message != null ? !message.equals(messages.message) : messages.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
