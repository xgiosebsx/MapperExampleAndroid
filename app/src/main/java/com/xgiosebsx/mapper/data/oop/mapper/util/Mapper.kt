package com.xgiosebsx.mapper.data.oop.mapper.util

interface Mapper<I, O> {
    fun map(input: I): O
}