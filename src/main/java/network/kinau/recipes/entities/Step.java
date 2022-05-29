package network.kinau.recipes.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "step")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Step {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    @ToString.Exclude
    private Recipe recipe;

    @Column(name = "step_number", nullable = false)
    private Long stepNumber;

    @Column(name = "description", nullable = false, length = 512)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Step step = (Step) o;
        return id != null && Objects.equals(id, step.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}