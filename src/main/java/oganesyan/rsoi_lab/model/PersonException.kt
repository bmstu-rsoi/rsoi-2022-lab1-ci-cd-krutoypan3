package oganesyan.rsoi_lab.model

data class PersonException(
    override var message: String?,
    var errors: Map<String, String>?
) : PersonError(message)