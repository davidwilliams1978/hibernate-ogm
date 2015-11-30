/*
 * Hibernate OGM, Domain model persistence for NoSQL datastores
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.ogm.backendtck.callbacks;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

/**
 * @author David Williams
 */
@Entity
public class Zoo {

	@Id
	private Integer id;

	@ElementCollection
	private Set<Animal> animals = new HashSet<Animal>();

	private int nrOfAnimals;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(Set<Animal> animals) {
		this.animals = animals;
	}

	@Transient
	public int getNrOfAnimals() {
		return nrOfAnimals;
	}

	@PostLoad
	public void postLoad() {
		nrOfAnimals = animals.size();
	}
}
