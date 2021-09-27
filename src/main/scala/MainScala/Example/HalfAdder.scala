
// 1-bit half adder

package Example

import chisel3._

class HalfAdder extends Module {

    val io = IO(new Bundle {

        val inputA = Input(UInt(1.W))
        val inputB = Input(UInt(1.W))

        val sum = Output(UInt(1.W))
        val c_out = Output(UInt(1.W))

    })

    // adder output
 
    io.sum := io.inputA ^ io.inputB

    // carry output    ab+ac+bc

    io.c_out := io.inputA & io.inputB

    // io.c :=((io.a & io.b)) - carry
    // io.s :=(io.a & (~io.b)) | (((~io.a) & io.b)) - sum

}