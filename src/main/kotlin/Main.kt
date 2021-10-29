
class Persona(val DNI: String){

    private var nombre:String = ""
    private var edad:Int = 0
    private var sexo:Char = 'H'
        set(value){
            if(value == 'H' || value == 'M') field = value
            else throw IllegalArgumentException("El sexo solo puede ser H o M.")
        }
    private var peso:Float = 0.0F
    private var altura: Float = 0.0F

    constructor(DNI:String, nombre: String,edad: Int, sexo: Char):this(DNI){
        this.nombre = nombre
        this.edad = edad
        this.sexo = sexo
    }

    constructor(DNI: String, nombre:String, edad:Int, sexo:Char, peso:Float, altura: Float):this(DNI){
        this.nombre = nombre
        this.edad = edad
        this.sexo = sexo
        this.peso = peso
        this.altura = altura
    }

    fun calcularIMC(){

    }

    fun esMayorDeEdad():Boolean{
        return edad>=18
    }
}



fun main(){

    val yo = Persona("55042809F","Alejandro", 21, 'H')
}