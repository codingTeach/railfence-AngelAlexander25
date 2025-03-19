import javax.swing.JOptionPane

fun cifrarRailFence(texto: String, clave: Int): String {
    if (clave <= 1) return texto
    val rail = Array(clave) { StringBuilder() }
    var dir = false
    var pos = 0

    for (c in texto) {
        rail[pos].append(c)
        if (pos == 0 || pos == clave - 1) dir = !dir
        pos += if (dir) 1 else -1
    }

    return rail.joinToString("") { it.toString() }
}

fun main() {
    val texto = JOptionPane.showInputDialog("Introduce el texto que deseas cifrar:")
    val claveTexto = JOptionPane.showInputDialog("Introduce la clave (numero de rieles):")
    val clave = claveTexto?.toIntOrNull() ?: 2

    if (texto != null) {
        val resultado = cifrarRailFence(texto, clave)
        JOptionPane.showMessageDialog(null, "Texto cifrado: $resultado")
    } else {
        JOptionPane.showMessageDialog(null, "No se introdujo texto.")
    }
}