package br.com.base.shared.entities;

import br.com.base.shared.utils.DateTimeUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    protected Long id;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @PrePersist
    private void onCreate() {
        createdAt = updatedAt = DateTimeUtil.nowZoneUTC();
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = DateTimeUtil.nowZoneUTC();
    }

}