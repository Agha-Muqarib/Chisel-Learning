
// 1-bit half adder

package Example

import chisel3._

class HalfAdder extends Module {
    val io = IO(new Bundle {

        val a = Input(UInt(1.W))
        val b = Input(UInt(1.W))

        val c = Output(UInt(1.W))
        val d = Output(UInt(1.W))

    })

    // adder output
 
    io.c := io.a ^ io.b

    // carry output    ab+ac+bc

    io.d := io.a & io.b


    // io.c :=((io.a & io.b)) - carry
    // io.s :=(io.a & (~io.b)) | (((~io.a) & io.b)) - sum

}