package br.com.gmfonseca.tcc.business.service.model

import br.com.gmfonseca.tcc.proto.AlgorithmExecutor
import br.com.gmfonseca.tcc.shared.toProto
import java.util.*

class AnComparableObject(
        private val uuid: UUID,
        private val intNumber: Int,
        private val floatNumber: Float
) : Comparable<AnComparableObject> {
    override fun compareTo(other: AnComparableObject): Int {
        return uuid.compareTo(other.uuid)
    }

    fun toAnObject(): AlgorithmExecutor.AnObject = AlgorithmExecutor.AnObject.newBuilder()
            .setFloatNumber(floatNumber)
            .setIntNumber(intNumber)
            .setUuid(uuid.toProto())
            .build()
}