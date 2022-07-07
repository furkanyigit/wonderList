package wonderlist.wonderlist.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    //@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Description is required")
    private String description;

    @Getter
    @Setter
    private boolean complete;

    @Getter
    @Setter
    private Instant createdDate;

    @Getter
    @Setter
    private Instant modifiedDate;

    public Todo(){}

    public Todo(String description){
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }
        @Override
    public String toString(){
            return String.format("Todo{id=%d, description='%s', complete='%s', createdDate='%s', modifiedDate='%s'}",
                    id, description, complete, createdDate, modifiedDate);
        }
}
