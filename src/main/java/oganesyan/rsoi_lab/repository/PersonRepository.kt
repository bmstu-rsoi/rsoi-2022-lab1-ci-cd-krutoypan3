package oganesyan.rsoi_lab.repository

import oganesyan.rsoi_lab.database.PersonEntities
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<PersonEntities, Int>