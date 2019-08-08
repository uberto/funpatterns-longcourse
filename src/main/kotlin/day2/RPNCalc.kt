package day2

import day1.FunStack


fun calc(cmd: String): Double? {
    val elements = cmd.split(" ")

    val (r, _) = elements.fold(FunStack(), ::rpn).pop()
    return r
}

private fun rpn(stack: FunStack<Double>, elem: String): FunStack<Double> = elem
    .toDoubleOrNull()
    ?.let { stack.push(it) }
    ?: stack.pop().let { (v1, s1) ->
        s1.pop().let { (v2, s2) ->
            if (v1 == null)
                return stack
            if (v2 == null)
                return stack
            s2.push(operation(elem, v1, v2))
        }
    }

private fun operation(op: String, x: Double, y: Double): Double {
    val res = when (op) {
        "+" -> x + y
        "-" -> x - y
        "*" -> x * y
        "/" -> x / y
        else -> throw Exception("Unknown operation $op")
    }
    return res
}


