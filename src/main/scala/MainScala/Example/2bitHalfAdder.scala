
// 2 bit Half adder

package Example

import chisel3._

class TwoBitHalfAdder extends Module {
    val io = IO(new Bundle {

        val a = Input(UInt(1.W))
        val b = Input(UInt(1.W))
        val c_in = Input(UInt(1.W))

        val sum = Output(UInt(1.W))
        val c_out = Output(UInt(1.W))

        val finalSum = Output(UInt(1.W))
        val finalC_out = Output(UInt(1.W))

    })

    
// Inner circuit (1bit adder)

    io.sum := io.a ^ io.b
    io.c_out := io.a & io.b

// Final Outer Circuit 

    io.finalSum := io.c_in | io.sum
    io.finalC_out := (io.c_in & io.sum) | io.c_out
    
}