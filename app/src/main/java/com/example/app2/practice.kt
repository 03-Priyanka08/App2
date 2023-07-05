package com.example.app2

import kotlin.math.abs


fun main(){

}

fun add( a: Int , b: Int): Int{
    return a+b
}
fun substrat( a: Int , b: Int): Int{
    return abs(a-b)
}
fun multiply( a: Int , b: Int): Int{
    return a*b
}
fun divide(a: Int , b: Int): Int {
    return if(b==0) -1 else a/b
}