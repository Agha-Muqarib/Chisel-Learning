package Lab06

import chisel3._
import chisel3.util._

// Updown Counter

class Task04(max: Int) extends Module {

    val io = IO (new Bundle {
        
        val up_down = Input(Bool())
        val out = Output(UInt(max.W))

    })

    io.out := 0.U
    
    val up = RegInit(0.U(max.W))
    val down = RegInit(max.U(max.W))
    
    when (io.up_down === 1.B){
        
        up := up + 1.U
        io.out := up

    }
    
    .elsewhen (io.up_down === 0.B) {

        down := down - 1.U
        io.out:= down

    }

}