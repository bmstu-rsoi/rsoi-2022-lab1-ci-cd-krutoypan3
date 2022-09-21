package oganesyan.rsoi_lab.service

import oganesyan.rsoi_lab.model.PersonRequest
import oganesyan.rsoi_lab.model.PersonResponse


interface PersonService {
    fun getPersonById(id: Int): PersonResponse
    fun getAllPersons(): List<PersonResponse>
    fun createPerson(request: PersonRequest): Int
    fun editPerson(id: Int, request: PersonRequest): PersonResponse
    fun deletePerson(id: Int)
}