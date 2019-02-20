package io.github.MehdiAghajani.data.mapper


interface Mapper<E, D> {

    fun mapFromEntity(type: E): D

    fun mapToEntity(type: D): E

}