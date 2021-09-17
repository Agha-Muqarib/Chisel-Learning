package Lab02

// Mux with input priority

import chisel3._

class IO_Interface extends Bundle {
val in = Input(UInt(4.W))
val s1 = Input(Bool())
val s2 = Input(Bool())
val s3 = Input(Bool())
val out = Output(Bool())
// UInt (1. W ) )
}

class Exercise04 extends Module {
val io = IO(new IO_Interface)
io.out := Mux(io.s3, io.in(3), Mux(io.s2, io.in(2), Mux(io.s1, io.in(1), io.in(0))))

}
