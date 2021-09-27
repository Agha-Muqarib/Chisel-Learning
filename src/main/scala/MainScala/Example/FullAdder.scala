package Example

import chisel3._

class FullAdder extends Module{

    val io= IO(new Bundle {

        val inputA = Input(UInt(1.W))
        val inputB = Input(UInt(1.W))
        val c_in = Input(UInt(1.W))
        val c_out = Output(UInt(1.W))
        val sum = Output(UInt(1.W))

    })

    io.sum := io.inputB ^ io.inputB ^ io.c_in
    io.c_out := (io.inputA & io.inputB) | (io.inputA & io.c_in) | (io.inputB & io.c_in)
    //io.sum :=(io.inputA & (~io.inputB)) | (((~io.inputB) & io.inputB))
    
}