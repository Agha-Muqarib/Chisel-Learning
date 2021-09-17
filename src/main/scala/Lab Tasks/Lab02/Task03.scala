package Lab02

// / Mux - Onehot example

import chisel3._
import chisel3.util._

class Task03 extends Module {

    val io = IO(new Bundle{

        val in0 = Input (UInt(1.W))
        val in1 = Input (UInt(1.W))
        val in2 = Input (UInt(1.W))
        val in3 = Input (UInt(1.W))
        
        val out = Output (UInt(2.W))

})

val sel = Cat(io.in3, io.in2, io.in1, io.in0)
io.out := Mux1H(sel, Seq("b00".U, "b01".U, "b10".U, "b11".U))

}