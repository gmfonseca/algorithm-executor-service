package br.com.gmfonseca.tcc.shared

import br.com.gmfonseca.tcc.business.model.AnComparableObject
import br.com.gmfonseca.tcc.proto.AlgorithmExecutor.AnObject
import java.util.*
import br.com.gmfonseca.tcc.proto.AlgorithmExecutor.UUID as ProtoUUID

fun ProtoUUID.toJava(): UUID = UUID(mostSigBits, leastSigBits)

fun UUID.toProto(): ProtoUUID = ProtoUUID.newBuilder()
        .setMostSigBits(mostSignificantBits)
        .setLeastSigBits(leastSignificantBits)
        .build()

fun AnObject.toAnComparableObject() = AnComparableObject(uuid.toJava(), intNumber, floatNumber)

fun List<AnObject>.toAnComparableObjectList() = map { it.toAnComparableObject() }
fun List<AnComparableObject>.toAnObjectList() = map { it.toAnObject() }