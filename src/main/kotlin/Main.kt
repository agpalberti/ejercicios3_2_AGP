class Persona() {
    val DNI: String
    var nombre: String = ""
    var edad: Int = 0
        set(value) {
            if (value >= 0) field = value
            else throw IllegalArgumentException("La edad no puede ser menor a cero.")
        }

    var sexo: Char = 'H'
        set(value) {
            if (value == 'H' || value == 'M') field = value
            else throw IllegalArgumentException("El sexo solo puede ser H o M.")
        }

    var peso: Float = 65.0F
        set(value) {
            if (value > 0) field = value
            else throw IllegalArgumentException("El peso no puede ser menor o igual a cero.")
        }

    var altura: Float = 1.70F
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
        comprobarSexo()
    }

    fun calcularIMC(): Int {
        return when {
            peso / (altura * altura) < 20.0 -> -1
            peso / (altura * altura) in 20.0..25.0 -> 0
            peso / (altura * altura) > 25.0 -> 1
            else -> 2
        }

    }

    fun esMayorDeEdad(): Boolean {
        return edad >= 18
    }

// comprobarSexo no es necesario, nunca se da esa situación debido al set.

    private fun comprobarSexo() {
        if (sexo != 'H' && sexo != 'M') sexo = 'H'
    }

    override fun toString(): String {
        return "Nombre: \"$nombre\", DNI: $DNI, edad: $edad, sexo: $sexo, peso: $peso, altura: $altura."
    }

    private fun generaDNI(): String {
        var param = ""
        param += (1..9).random()
        repeat(7) { param += (0..9).random() }
        param += ('A'..'Z').random()

        return param
    }
}

//Devuelve un string según el int que le introduzcas, para utilizarlo junto al resultado del IMC
fun pesoIdeal(param: Int): String {
    return when (param) {
        -1 -> "Está en su peso ideal."
        0 -> "Está por debajo de su peso ideal."
        1 -> "Tiene sobrepeso."
        else -> "Error."
    }
}

//Devuelve un string según si eres mayor de edad o no
fun mayoriaEdad(param: Boolean): String {
    return if (param) "Es mayor de edad"
    else "Es menor de edad"
}


fun main() {
    val nombre: String
    val edad: Int
    val sexo: Char
    val peso: Float
    val altura: Float

    println("Introduce tu nombre.")
    nombre = readLine() ?: ""

    println("Introduce la edad.")
    // Hago try/catch para cada variable para gestión de los posibles errores.
    try {
        edad = readLine()?.toInt() ?: 18
    } catch (_: Exception) {
        println("El valor introducido no es correcto.")
        return
    }

    println("Introduce el sexo (H o M).")
    try {
        sexo = readLine()?.get(0) ?: '0'
    } catch (_: Exception) {
        println("El valor introducido no es correcto.")
        return
    }

    println("Introduce el peso.")
    try {
        peso = readLine()?.toFloat() ?: 0.0F
    } catch (_: Exception) {
        println("El valor introducido no es correcto.")
        return
    }

    println("Introduce la altura.")
    try {
        altura = readLine()?.toFloat() ?: 0.0F
    } catch (_: Exception) {
        println("El valor introducido no es correcto.")
        return
    }

    val persona1 = Persona(nombre, edad, sexo, peso, altura)
    val persona2 = Persona(nombre, edad, sexo)
    val persona3 = Persona()
    persona3.apply {
        this.nombre = nombre
        this.edad = edad
        this.sexo = sexo
        this.peso = peso
        this.altura = altura
    }

    println(pesoIdeal(persona1.calcularIMC()))
    println(pesoIdeal(persona2.calcularIMC()))
    println(pesoIdeal(persona3.calcularIMC()))
    println(mayoriaEdad(persona1.esMayorDeEdad()))
    println(mayoriaEdad(persona2.esMayorDeEdad()))
    println(mayoriaEdad(persona3.esMayorDeEdad()))
    println("- $persona1\n- $persona2\n- $persona3")

}