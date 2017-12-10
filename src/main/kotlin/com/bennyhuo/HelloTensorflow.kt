import kotlinx.cinterop.*
import org.tensorflow.*
import tensorflow.*

fun main(args: Array<String>) {
    println("Hello, TensorFlow ${TF_Version()!!.toKString()}!")

    val result = Graph().run {
        val input = intInput()

        withSession { invoke(input + constant(2), inputsWithValues = listOf(input to scalarTensor(3))).scalarIntValue }
    }

    println("3 + 2 is $result.")
}