import kotlin.random.Random

class Persona() {
    private val DNI: String
    private var nombre: String = ""
    private var edad: Int = 0
        set(value) {
            if (value >= 0) field = value
            else throw IllegalArgumentException("La edad no puede ser menor a cero.")
        }

    private var sexo: Char = 'H'
        set(value) {
            if (value == 'H' || value == 'M') field = value
            else throw IllegalArgumentException("El sexo solo puede ser H o M.")
        }

    private var peso: Float = 65.0F
        set(value) {
            if (value > 0) field = value
            else throw IllegalArgumentException("El peso no puede ser menor o igual a cero.")
        }

    private var altura: Float = 1.70F
        set(value) {
            if (value > 0) field = value
            else throw IllegalArgumentException("La altura no puede ser menor o igual a cero.")
        }

    constructor(nombre: String, edad: Int, sexo: Char) : this() {
        this.nombre = nombre
        this.edad = edad
        this.sexo = sexo
    }

    constructor(nombre: String, edad: Int, sexo: Char, peso: Float, altura: Float) : this() {
        this.nombre = nombre
        this.edad = edad
        this.sexo = sexo
        this.peso = peso
        this.altura = altura
    }

    init {
        DNI = generaDNI()
    }

    fun calcularIMC(): Int {
        return when {
            peso / (altura * altura) < 20.0 -> -1
            peso / (altura * altura) in 20.0..25.0 -> 0
            peso / (altura * altura) > 25 -> 1
            else -> 2
        }

    }

    fun esMayorDeEdad(): Boolean {
        return edad >= 18
    }

    fun comprobarSexo() {
        if (sexo != 'H' && sexo != 'M') sexo = 'H'
    }

    override fun toString(): String {
        return "Nombre: \"$nombre\", DNI: $DNI, edad: $edad, sexo: $sexo, peso: $peso, altura: $altura."
    }

    private fun generaDNI(): String {
        var param = ""
        repeat(8) { param += (0..9).random() }
        param += ('A'..'Z').random()

        return param
    }
}


fun main() {

    val yo = Persona("Alejandro", 21, 'H')
    println(yo)
}