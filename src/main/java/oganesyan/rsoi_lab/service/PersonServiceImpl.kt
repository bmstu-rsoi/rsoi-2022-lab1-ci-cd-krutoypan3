package oganesyan.rsoi_lab.service

import oganesyan.rsoi_lab.database.PersonEntities
import oganesyan.rsoi_lab.model.PersonRequest
import oganesyan.rsoi_lab.model.PersonResponse
import oganesyan.rsoi_lab.repository.PersonRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityNotFoundException


@Service
class PersonServiceImpl(private val personRepository: PersonRepository) : PersonService {

    @Transactional(readOnly = true)
    override fun getPersonById(id: Int): PersonResponse =
        personRepository.findById(id)
            .map { buildPersonResponse(it) }
            .orElseThrow { throw EntityNotFoundException("Person $id not found") }

    @Transactional(readOnly = true)
    override fun getAllPersons(): List<PersonResponse> =
        personRepository.findAll()
            .map { buildPersonResponse(it) }

    @Transactional
    override fun createPerson(request: PersonRequest): Int {
        val person = PersonEntities(
            name = request.name,
            age = request.age,
            work = request.work,
            address = request.address
        )
        val saved = personRepository.save(person)
        return saved.id!!
    }

    @Transactional
    override fun editPerson(id: Int, request: PersonRequest): PersonResponse {
        val person = personRepository
            .findById(id)
            .orElseThrow { throw EntityNotFoundException("Person $id not found") }

        person.name = request.name
        person.age = request.age ?: person.age
        person.address = request.address ?: person.address
        person.work = request.work ?: person.work
        personRepository.save(person)
        return buildPersonResponse(person)
    }

    @Transactional
    override fun deletePerson(id: Int) = personRepository.deleteById(id)

    private fun buildPersonResponse(person: PersonEntities) =
        PersonResponse(
            id = person.id!!,
            name = person.name!!,
            age = person.age,
            address = person.address,
            work = person.work
        )
}