package Lab02

// Mux - Onehot example

import chisel3._
import chisel3.util._

class Exercise07 extends Module {
    
val io = IO ( new Bundle {
val in0 = Input(Bool())
val in1 = Input(Bool())
val in2 = Input(Bool())
val in3 = Input(Bool())
val sel = Input(UInt(4.W))
val out = Output(Bool())

})

io.out := Mux1H(io.sel, Seq( io.in0, io.in1, io.in2, io.in3))

}