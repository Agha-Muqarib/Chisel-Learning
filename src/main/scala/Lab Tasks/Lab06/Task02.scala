package Lab06

import chisel3._
import chisel3.util._

// Counter With XOR

class Task02(val max: Int) extends Module{

    val io = IO(new Bundle {

        val in = Input(UInt(max.W))
        val out = Output(UInt((log2Ceil(max).W)))
        val top = Output(Bool())

    })

    val counter = RegInit(0.S(4.W))

    io.out := 0.U
    io.top := 0.B

    when (counter(4.U) ^ 1.B === 0.B) {

            counter := 0.S
            io.top := 1.B

    }
    
    .otherwise {

        counter := counter + 1.S
        io.top := 0.B

    }   
    
    io.out := counter(15.U)

}