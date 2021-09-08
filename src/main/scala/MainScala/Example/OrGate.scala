package Example


import chisel3._



class OrGate extends Module {



    val io = IO(new Bundle {

        // UInt for unsigned int (SUInt for signed)
        // 1.W for 1bit input (32.W for 32 bits )

        // Initializing inputs
        
        val a = Input(UInt(1.W))
        val b = Input(UInt(1.W))

        // Initializing output

        val c = Output(UInt(1.W))
    })

    // In this line we wire our 2 inputs to output
    // := is the syntax for wiring

    io.c := io.a | io.b

}