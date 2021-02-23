package com.cheky.springboot.demo.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.OffsetDateTime;

/**
 * @author Cheky
 */
@Data
@ToString
@MappedSuperclass
@EqualsAndHashCode
public class BaseDO {

    /**
     * Create time.
     */
    @Column(name = "created_at")
    private OffsetDateTime createAt;

    /**
     * Update time.
     */
    @Column(name = "updated_at")
    private OffsetDateTime updateAt;

    @PrePersist
    private void prePersist() {
        if (createAt == null) {
            createAt = OffsetDateTime.now();
        }
    }

    @PreUpdate
    private void preUpdate() {
        updateAt = OffsetDateTime.now();
    }

    private void setCreateAt(OffsetDateTime value){
        createAt = value;
    }

    private void setUpdateAt(OffsetDateTime value){
        updateAt = value;
    }
}
