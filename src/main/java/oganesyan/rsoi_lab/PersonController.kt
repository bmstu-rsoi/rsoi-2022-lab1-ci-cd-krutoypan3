package oganesyan.rsoi_lab


import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.headers.Header
import io.swagger.v3.oas.annotations.media.ArraySchema
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import oganesyan.rsoi_lab.model.PersonError
import oganesyan.rsoi_lab.model.PersonException
import oganesyan.rsoi_lab.model.PersonRequest
import oganesyan.rsoi_lab.model.PersonResponse
import oganesyan.rsoi_lab.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

import javax.validation.Valid

@Tag(name = "persons_controller")
@RestController
@RequestMapping("/api/v1/persons")
class PersonController(
    private val personService: PersonService
) {

    @Operation(
        summary = "get_person_by_id",
        responses = [
            ApiResponse(
                responseCode = "200",
                description = "Person for id",
                content = [Content(schema = Schema(implementation = PersonResponse::class))]
            ),
            ApiResponse(
                responseCode = "404",
                description = "Not found person for id",
                content = [Content(schema = Schema(implementation = PersonError::class))]
            ),
        ]
    )
    @GetMapping("/{id}", produces = [APPLICATION_JSON_VALUE])
    fun getPersonById(@PathVariable id: Int) = personService.getPersonById(id)

    @Operation(
        summary = "get_all_persons", responses = [ApiResponse(
            responseCode = "200",
            description = "All persons",
            content = [Content(array = ArraySchema(schema = Schema(implementation = PersonResponse::class)))]
        )]
    )
    @GetMapping(produces = [APPLICATION_JSON_VALUE])
    fun getAllPersons() = personService.getAllPersons()

    @Operation(
        summary = "create_person", responses = [ApiResponse(
            responseCode = "201",
            description = "Created new person",
            headers = [Header(name = "Location", description = "Path to new Person")]
        ), ApiResponse(
            responseCode = "400",
            description = "Invalid data",
            content = [Content(schema = Schema(implementation = PersonException::class))]
        )]
    )
    @PostMapping(consumes = [APPLICATION_JSON_VALUE])
    fun createPerson(@Valid @RequestBody request: PersonRequest): ResponseEntity<Void> {
        val id = personService.createPerson(request)
        return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri()
        ).build()
    }

    @Operation(
        summary = "update_person_by_id", responses = [ApiResponse(
            responseCode = "200",
            description = "Person for id was updated",
            content = [Content(schema = Schema(implementation = PersonResponse::class))]
        ), ApiResponse(
            responseCode = "400",
            description = "Invalid data",
            content = [Content(schema = Schema(implementation = PersonException::class))]
        ), ApiResponse(
            responseCode = "404",
            description = "Not found person for id",
            content = [Content(schema = Schema(implementation = PersonError::class))]
        )]
    )
    @PatchMapping("/{id}", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
    fun editPerson(@PathVariable id: Int, @Valid @RequestBody request: PersonRequest) =
        personService.editPerson(id, request)

    @Operation(
        summary = "remove_person_by_id",
        responses = [ApiResponse(responseCode = "204", description = "Person for id was removed")]
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    fun deletePerson(@PathVariable id: Int) = personService.deletePerson(id)
}