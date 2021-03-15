package br.com.gmfonseca.tcc.business.model

import br.com.gmfonseca.tcc.proto.AlgorithmExecutor
import br.com.gmfonseca.tcc.shared.toProto
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class AnComparableObject(
    @JsonProperty("uuid") private val uuid: UUID,
    @JsonProperty("intNumber") private val intNumber: Int,
    @JsonProperty("floatNumber") private val floatNumber: Float
) : Comparable<AnComparableObject> {
    override fun compareTo(other: AnComparableObject): Int {
        return intNumber.compareTo(other.intNumber)
    }

    fun toAnObject(): AlgorithmExecutor.AnObject = AlgorithmExecutor.AnObject.newBuilder()
            .setFloatNumber(floatNumber)
            .setIntNumber(intNumber)
            .setUuid(uuid.toProto())
            .build()
}
