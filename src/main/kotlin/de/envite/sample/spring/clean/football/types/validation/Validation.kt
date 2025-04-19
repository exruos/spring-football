package de.envite.sample.spring.clean.football.types.validation

import de.envite.sample.spring.clean.football.types.validation.Validation.Companion.validate

/**
 * DSL used to validate generic `value` instances based on a given set of
 * requirements.
 *
 * This is mostly used when defining _value types_ / _domain primitives_.
 * But it can also be used in more complex scenarios with a mix of custom
 * requirements and data classes.
 *
 * @sample integerValueExample
 * @sample customValueExample
 */
class Validation<T>(
    private val label: String,
    val value: T
) {
    private val problems: MutableList<String> = mutableListOf()

    fun addViolation(violation: String) {
        problems += "'$label' [$value] - $violation"
    }

    private fun validate() {
        if (problems.isNotEmpty()) throw ValidationException(label, problems)
    }

    companion object {
        fun <T> validate(value: T, label: String? = null, constraints: Validation<T>.() -> Unit) {
            Validation(getNonNullLabel(value, label), value)
                .apply(constraints)
                .validate()
        }

        private fun <T> getNonNullLabel(value: T, label: String?) =
            label ?: value?.let { dynamicLabelFor(it) } ?: "?"

        private fun dynamicLabelFor(value: Any): String = value::class.simpleName ?: "?"
    }
}

fun Validation<*>.constraint(value: Boolean, violationSupplier: () -> String) {
    if (!value) addViolation(violationSupplier())
}

@Suppress("MagicNumber", "unused")
private fun integerValueExample() {
    fun Validation<Int>.isEven() =
        constraint(value % 2 == 0) { "must be even" }

    validate(42) {
        isEven()
    }
}

@Suppress("unused")
private fun customValueExample() {
    data class Values(val a: Int, val b: Int)

    validate(Values(a = 5, b = 10), "Two Values") {
        constraint(value.a * value.b % 2 == 0) { "product of a and b must be even" }
    }
}
