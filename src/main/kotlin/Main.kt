
class Persona(val DNI: String){

    var nombre:String = ""
    val edad:Int = 0
    val sexo:Char = 'M'
    val peso:Float = 0.0F
    val altura: Float = 0.0F

    init {
    }

    constructor(DNI:String, nombre: String,edad: Int, sexo: Char):this(DNI){
        this.nombre = nombre

    }

    constructor(DNI: String, nombre:String, edad:Int, sexo:Char, peso:Float, altura: Float):this(DNI)
}



fun main(){

    val yo = Persona("550428F")
}