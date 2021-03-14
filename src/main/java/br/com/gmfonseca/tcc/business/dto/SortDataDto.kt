package br.com.gmfonseca.tcc.business.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class SortDataDto(
    @JsonProperty("type") val type: String,
    @JsonProperty("elements") val elements: List<Any>
)