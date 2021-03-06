/*
 *
 *  Copyright 2017 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.genie.core.jpa.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Entity representing a Tag.
 *
 * @author tgianos
 * @since 3.3.0
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "tag", callSuper = false)
@ToString(callSuper = true)
@Entity
@Table(name = "tags")
public class TagEntity extends AuditEntity {

    @Basic(optional = false)
    @Column(name = "tag", nullable = false, unique = true, updatable = false)
    @NotBlank(message = "Must have a tag value associated with this entity")
    @Length(max = 255, message = "Max length of a tag is 255 characters")
    private String tag;

    /**
     * Constructor.
     *
     * @param tag The tag to use
     */
    public TagEntity(final String tag) {
        super();
        this.tag = tag;
    }
}
