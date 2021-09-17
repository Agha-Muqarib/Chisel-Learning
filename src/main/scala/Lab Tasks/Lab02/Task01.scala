package Lab02


import chisel3._
import chisel3.util._

// Mux IO interface class

class Mux_2to1_IO extends Bundle {

    val in_A = Input(UInt(32.W))
    val in_B = Input(UInt(32.W))
    val select = Input(Bool())
    val out = Output(UInt(32.W))

}

// 2 to 1 Mux implementation

class Task01 extends Module {

    val io = IO(new Mux_2to1_IO)

    // update the output
    val sel = Fill(32,io.select)

    io . out := io . in_A & (~sel) | io . in_B & (sel)

}
