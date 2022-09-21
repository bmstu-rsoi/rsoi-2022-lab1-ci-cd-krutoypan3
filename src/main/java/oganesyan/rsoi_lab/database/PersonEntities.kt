package oganesyan.rsoi_lab.database

import javax.persistence.*

@Entity
@Table(name = "persons")
class PersonEntities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null

    @Column(nullable = false, length = 80)
    var name: String? = null

    @Column
    var age: Int? = null

    @Column
    var address: String? = null

    @Column
    var work: String? = null

    constructor()

    constructor(name: String, age: Int?, address: String?, work: String?) {
        this.name = name
        this.age = age
        this.address = address
        this.work = work
    }

    constructor(id: Int, name: String, age: Int?, address: String?, work: String?) : this(name, age, address, work) {
        this.id = id
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PersonEntities

        if (name != other.name) return false
        if (age != other.age) return false
        if (address != other.address) return false
        if (work != other.work) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (age ?: 0)
        result = 31 * result + (address?.hashCode() ?: 0)
        result = 31 * result + (work?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Person(id=$id, name='$name', age=$age, address='$address', work='$work')"
    }
}